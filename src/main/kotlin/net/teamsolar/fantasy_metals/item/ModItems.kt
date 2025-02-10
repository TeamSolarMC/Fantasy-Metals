package net.teamsolar.fantasy_metals.item

import net.minecraft.resources.ResourceLocation
import net.minecraft.world.entity.EquipmentSlotGroup
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.AxeItem
import net.minecraft.world.item.HoeItem
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.ShovelItem
import net.minecraft.world.item.SwordItem
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import net.teamsolar.fantasy_metals.FantasyMetals
import java.util.function.Supplier

object ModItems {
    val ITEMS_REGISTER: DeferredRegister.Items = DeferredRegister.createItems(FantasyMetals.MODID)
    private fun MetalEquipmentSet.thenRegister() = apply {
        ITEMS_REGISTER.registerAll()
    }
    val MYTHRIL_SET = object : MetalEquipmentSet(
        prefix = "mythril",
        armorMaterial = ModArmorMaterials.MYTHRIL,
        tier = ModToolTiers.MYTHRIL,
        armorDurabilities = mapOf(
            ArmorItem.Type.HELMET to 279,
            ArmorItem.Type.CHESTPLATE to 406,
            ArmorItem.Type.LEGGINGS to 380,
            ArmorItem.Type.BOOTS to 279
        )
    ) {
        init {
            // Entity base attack damage: 1
            // Mod tool tier attack damage bonus: 3
            // Entity base attack speed: 4
            SWORD.properties = SWORD.properties.attributes(SwordItem.createAttributes(
                tier,
                3f,
                -2f
            ))
            AXE.properties = AXE.properties.attributes(AxeItem.createAttributes(
                tier,
                5.0f,
                -2.75f
            ))
            PICKAXE.properties = PICKAXE.properties.attributes(PickaxeItem.createAttributes(
                tier,
                1f,
                -2.5f
            ))
            SHOVEL.properties = SHOVEL.properties.attributes(ShovelItem.createAttributes(
                tier,
                1.5f,
                -2.75f
            ))
            HOE.properties = HOE.properties.attributes(HoeItem.createAttributes(
                tier,
                -3.0f,
                0.0f
            ))
        }
    }.thenRegister()
    val ADAMANT_SET = object : MetalEquipmentSet(
        prefix = "adamant",
        armorMaterial = ModArmorMaterials.ADAMANT,
        tier = ModToolTiers.ADAMANT,
        armorDurabilities = mapOf(
            ArmorItem.Type.HELMET to 726,
            ArmorItem.Type.CHESTPLATE to 1057,
            ArmorItem.Type.LEGGINGS to 991,
            ArmorItem.Type.BOOTS to 859
        )
    ) {
        init {
            // Entity base attack damage: 1
            // Mod tool tier attack damage bonus: 4
            // Entity base attack speed: 4
            SWORD.properties = SWORD.properties.attributes(SwordItem.createAttributes(
                tier,
                3.0f,
                -2.8f
            ))
            AXE.properties = AXE.properties.attributes(AxeItem.createAttributes(
                tier,
                5.0f,
                -3.25f
            ))
            PICKAXE.properties = PICKAXE.properties.attributes(PickaxeItem.createAttributes(
                tier,
                1f,
                -3.1f
            ))
            SHOVEL.properties = SHOVEL.properties.attributes(ShovelItem.createAttributes(
                tier,
                1.5f,
                -3.25f
            ))
            HOE.properties = HOE.properties.attributes(HoeItem.createAttributes(
                tier,
                -4.0f,
                -1.0f
            ))
            for(entry in toolEntries.toSet() + combatItemEntries.toSet() + ingredientEntries.toSet()) {
                entry.properties = entry.properties.fireResistant()
            }
            BOOTS.properties = BOOTS.properties.attributes(armorAndToughness(armor = 4.0, toughness = 1.0, type = ArmorItem.Type.BOOTS))
        }
    }.thenRegister()
    val ORICHALCUM_SET = object : MetalEquipmentSet(
        prefix = "orichalcum",
        armorMaterial = ModArmorMaterials.ORICHALCUM,
        tier = ModToolTiers.ORICHALCUM,
        armorDurabilities = mapOf(
            ArmorItem.Type.HELMET to 290,
            ArmorItem.Type.CHESTPLATE to 421,
            ArmorItem.Type.LEGGINGS to 395,
            ArmorItem.Type.BOOTS to 342
        )
    ) {
        init {
            // Entity base attack damage: 1
            // Mod tool tier attack damage bonus: 4
            // Entity base attack speed: 4
            AXE.properties = AXE.properties.attributes(AxeItem.createAttributes(
                tier,
                5f,
                -3f
            ))
            HOE.properties = HOE.properties.attributes(HoeItem.createAttributes(
                tier,
                -4f,
                0f
            ))
        }
    }.thenRegister()
    val CARMOT_SET = MetalEquipmentSet(
        prefix = "carmot",
        armorMaterial = ModArmorMaterials.CARMOT,
        tier = ModToolTiers.CARMOT,
        armorDurabilities = mapOf(
            ArmorItem.Type.HELMET to 438,
            ArmorItem.Type.CHESTPLATE to 637,
            ArmorItem.Type.LEGGINGS to 597,
            ArmorItem.Type.BOOTS to 517
        )
    ).thenRegister()

    val SARDONYX_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("sardonyx"))
    val ALEXANDRITE_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("alexandrite"))
    val TANZANITE_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("tanzanite"))
    val BLACK_OPAL_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("black_opal"))
    val TSAVORITE_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("tsavorite"))

    val TEST_ITEM = ITEMS_REGISTER.register("test_item", Supplier{BlockCharacteristicCheckerItem()})
    val ORE_SCANNER_ITEM = ITEMS_REGISTER.register("ore_scanner_item", Supplier{ChunkOreDetectorItem()})

    val GEMS = listOf(
        SARDONYX_SET,
        ALEXANDRITE_SET,
        TANZANITE_SET,
        BLACK_OPAL_SET,
        TSAVORITE_SET
    )

    fun register(eventBus: IEventBus) {
        ITEMS_REGISTER.register(eventBus)
    }
}