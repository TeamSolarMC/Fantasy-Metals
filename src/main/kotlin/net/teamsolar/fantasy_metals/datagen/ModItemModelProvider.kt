package net.teamsolar.fantasy_metals.datagen

import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.packs.PackType
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.armortrim.TrimMaterial
import net.minecraft.world.item.armortrim.TrimMaterials
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder
import net.neoforged.neoforge.client.model.generators.ItemModelProvider
import net.neoforged.neoforge.client.model.generators.ModelFile.UncheckedModelFile
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredItem
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.item.GemItemSet
import net.teamsolar.fantasy_metals.item.MetalEquipmentSet
import net.teamsolar.fantasy_metals.item.ModItems

class ModItemModelProvider(output: PackOutput, existingFileHelper: ExistingFileHelper) :
    ItemModelProvider(output, FantasyMetals.MODID, existingFileHelper) {
    override fun registerModels() {
        val providerHelper = object: ItemModelProviderHelper {
            override fun handheldItem(item: DeferredItem<out Item>) {
                this@ModItemModelProvider.handheldItem(item)
            }
            override fun simpleItem(item: DeferredItem<out Item>) {
                this@ModItemModelProvider.simpleItem(item)
            }
            override fun trimmedArmorItem(armorItem: DeferredItem<out ArmorItem>) {
                this@ModItemModelProvider.trimmedArmorItem(armorItem)
            }
        }
        fun MetalEquipmentSet.thenProvideModels() = providerHelper.register()
        fun GemItemSet.thenProvideModels() = providerHelper.register()

        ModItems.MYTHRIL_SET.thenProvideModels()
        ModItems.ADAMANT_SET.thenProvideModels()
        ModItems.ORICHALCUM_SET.thenProvideModels()
        ModItems.CARMOT_SET.thenProvideModels()

        for(gemItemSet in ModItems.GEMS) {
            gemItemSet.thenProvideModels()
        }
    }
    fun <T : Item> handheldItem(item: DeferredItem<T>): ItemModelBuilder {
        return withExistingParent(
            item.id.path,
            mcLoc("item/handheld")
        ).texture(
            "layer0",
            modLoc("item/" + item.id.path)
        )
    }
    fun <T : Item> simpleItem(item: DeferredItem<T>): ItemModelBuilder {
        return withExistingParent(
            item.id.path,
            mcLoc("item/generated")
        ).texture(
            "layer0",
            modLoc("item/" + item.id.path)
        )
    }

    private val trimMaterials: LinkedHashMap<ResourceKey<TrimMaterial>, Float> = LinkedHashMap()
    init {
        trimMaterials[TrimMaterials.QUARTZ] = 0.1F
        trimMaterials[TrimMaterials.IRON] = 0.2F
        trimMaterials[TrimMaterials.NETHERITE] = 0.3F
        trimMaterials[TrimMaterials.REDSTONE] = 0.4F
        trimMaterials[TrimMaterials.COPPER] = 0.5F
        trimMaterials[TrimMaterials.GOLD] = 0.6F
        trimMaterials[TrimMaterials.EMERALD] = 0.7F
        trimMaterials[TrimMaterials.DIAMOND] = 0.8F
        trimMaterials[TrimMaterials.LAPIS] = 0.9F
        trimMaterials[TrimMaterials.AMETHYST] = 1.0F
    }

    private fun trimmedArmorItem(itemDeferredItem: DeferredItem<out ArmorItem>) {
        val modid: String = FantasyMetals.MODID // Change this to your mod id
        val armorItem = itemDeferredItem.get()
        trimMaterials.forEach { (trimMaterial: ResourceKey<TrimMaterial>, trimValue: Float) ->
            val armorType = when (armorItem.equipmentSlot) {
                EquipmentSlot.HEAD -> "helmet"
                EquipmentSlot.CHEST -> "chestplate"
                EquipmentSlot.LEGS -> "leggings"
                EquipmentSlot.FEET -> "boots"
                else -> ""
            }

            val armorItemPath: String = armorItem.toString()
            val trimPath = "trims/items/" + armorType + "_trim_" + trimMaterial.location().path
            val currentTrimName = armorItemPath + "_" + trimMaterial.location().path + "_trim"
            val armorItemResLoc = ResourceLocation.parse(armorItemPath)
            val trimResLoc = ResourceLocation.parse(trimPath) // minecraft namespace
            val trimNameResLoc = ResourceLocation.parse(currentTrimName)

            // This is used for making the ExistingFileHelper acknowledge that this texture exist, so this will
            // avoid an IllegalArgumentException
            existingFileHelper.trackGenerated(trimResLoc, PackType.CLIENT_RESOURCES, ".png", "textures")

            // Trimmed armorItem files
            getBuilder(currentTrimName)
                .parent(UncheckedModelFile("item/generated"))
                .texture("layer0", armorItemResLoc.namespace + ":item/" + armorItemResLoc.path)
                .texture("layer1", trimResLoc)

            // Non-trimmed armorItem file (normal variant)
            withExistingParent(
                itemDeferredItem.id.path,
                mcLoc("item/generated")
            )
                .override()
                .model(UncheckedModelFile(trimNameResLoc.namespace + ":item/" + trimNameResLoc.path))
                .predicate(mcLoc("trim_type"), trimValue).end()
                .texture(
                    "layer0",
                    ResourceLocation.fromNamespaceAndPath(
                        modid,
                        "item/" + itemDeferredItem.id.path
                    )
                )
        }
    }
}
