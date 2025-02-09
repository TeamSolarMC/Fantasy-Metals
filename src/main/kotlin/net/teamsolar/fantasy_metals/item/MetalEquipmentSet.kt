package net.teamsolar.fantasy_metals.item

import net.minecraft.core.Holder
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.*
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.datagen.*

open class MetalEquipmentSet(
    final override val prefix: String,
    val armorMaterial: Holder<ArmorMaterial>,
    tier: Tier,
    durabilityFactor: Int // For armor; e.g.
        // Iron armor has a durability factor of 15 and a helmet has a base durability of 11,
        // so an iron helmet has a durability of 15 * 11 = 165.
    ) : ItemSet() {
    // provide default constructors for all items
    val SWORD = prefix + "_sword" properties Item.Properties().attributes(SwordItem.createAttributes(tier, 3, -2.4f)) constructor {SwordItem(tier, it)}
    val SHOVEL = prefix + "_shovel" properties Item.Properties().attributes(ShovelItem.createAttributes(tier, 1.5f, -3.0f)) constructor {ShovelItem(tier, it)}
    val PICKAXE = prefix + "_pickaxe" properties Item.Properties().attributes(PickaxeItem.createAttributes(tier, 1.0f, -2.8f)) constructor {PickaxeItem(tier, it)}
    val AXE = prefix + "_axe" properties Item.Properties().attributes(AxeItem.createAttributes(tier, 6.0f, -3.1f)) constructor {AxeItem(tier, it)}
    val HOE = prefix + "_hoe" properties Item.Properties().attributes(HoeItem.createAttributes(tier, -2.0f, -1.0f)) constructor {HoeItem(tier, it)}
    /*
     * see neoforge-21.1.79-minecraft-merged.jar!/net/minecraft/world/item/Items.java:996
     * for default attributes (attack damage and speed) of items
     */

    val HELMET = prefix + "_helmet" properties Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(durabilityFactor)) constructor {ArmorItem(armorMaterial, ArmorItem.Type.HELMET, it)}
    val CHESTPLATE = prefix + "_chestplate" properties Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(durabilityFactor)) constructor {ArmorItem(armorMaterial, ArmorItem.Type.CHESTPLATE, it)}
    val LEGGINGS = prefix + "_leggings" properties Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(durabilityFactor)) constructor {ArmorItem(armorMaterial, ArmorItem.Type.LEGGINGS, it)}
    val BOOTS = prefix + "_boots" properties  Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(durabilityFactor)) constructor {ArmorItem(armorMaterial, ArmorItem.Type.BOOTS, it)}

    val INGOT = prefix + "_ingot" entry {Item(it)}
    val NUGGET = prefix + "_nugget" entry {Item(it)}
    val RAW = "raw_$prefix" entry {Item(it)}

    val INGOT_TAG: TagKey<Item> = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/$prefix"))
    val NUGGET_TAG: TagKey<Item> = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "nuggets/$prefix"))
    val RAW_TAG: TagKey<Item> = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "raw_materials/$prefix"))
    val ORE_TAG: TagKey<Block> = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "ores/$prefix"))
    val ORE_TAG_ITEM: TagKey<Item> = ItemTags.create(ORE_TAG.location)
    val RAW_STORAGE_TAG: TagKey<Block> = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/raw_$prefix"))
    val RAW_STORAGE_TAG_ITEM = ItemTags.create(RAW_STORAGE_TAG.location)
    val STORAGE_TAG: TagKey<Block> = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/$prefix"))
    val STORAGE_TAG_ITEM = ItemTags.create(STORAGE_TAG.location)

    val INCORRECT_FOR_THIS_TOOL: TagKey<Block> = tier.incorrectBlocksForDrops

    protected open val toolEntries = listOf(
        SHOVEL,
        PICKAXE,
        AXE,
        HOE
    )
    protected open val combatItemEntries = listOf(
        SWORD,
        AXE,
        HELMET,
        CHESTPLATE,
        LEGGINGS,
        BOOTS
    )
    protected open val ingredientEntries = listOf(
        INGOT,
        NUGGET,
        RAW
    )

    open val tools: List<DeferredItem<out Item>>
        get() {
            if(toolEntries.any {it.actual == null}) {
                throw IllegalStateException("Items not registered yet")
            }
            return toolEntries.map {it.actual!!}
        }
    open val combatItems: List<DeferredItem<out Item>>
        get() {
            if(combatItemEntries.any {it.actual == null}) {
                throw IllegalStateException("Items not registered yet")
            }
            return combatItemEntries.map {it.actual!!}
        }
    open val ingredients: List<DeferredItem<out Item>>
        get() {
            if(ingredientEntries.any {it.actual == null}) {
                throw IllegalStateException("Items not registered yet")
            }
            return ingredientEntries.map {it.actual!!}
        }

    open fun ItemModelProviderHelper.register() {
        simpleItem(INGOT.actual!!)
        simpleItem(NUGGET.actual!!)
        simpleItem(RAW.actual!!)

        handheldItem(SWORD.actual!!)
        handheldItem(SHOVEL.actual!!)
        handheldItem(PICKAXE.actual!!)
        handheldItem(AXE.actual!!)
        handheldItem(HOE.actual!!)

        trimmedArmorItem(HELMET.actual!!)
        trimmedArmorItem(CHESTPLATE.actual!!)
        trimmedArmorItem(LEGGINGS.actual!!)
        trimmedArmorItem(BOOTS.actual!!)
    }
    open fun ItemTagsProviderHelper.addTags() {
        tag(ItemTags.TRIMMABLE_ARMOR).add(
            HELMET.item(),
            CHESTPLATE.item(),
            LEGGINGS.item(),
            BOOTS.item()
        )
        ItemTags.HEAD_ARMOR.add(HELMET.item())
        ItemTags.CHEST_ARMOR.add(CHESTPLATE.item())
        ItemTags.LEG_ARMOR.add(LEGGINGS.item())
        ItemTags.FOOT_ARMOR.add(BOOTS.item())

        ItemTags.SWORDS.add(SWORD.item())
        ItemTags.SHOVELS.add(SHOVEL.item())
        ItemTags.PICKAXES.add(PICKAXE.item())
        ItemTags.AXES.add(AXE.item())
        ItemTags.HOES.add(HOE.item())

        // Neoforge tags
        INGOT_TAG.add(INGOT.item())
        tag(Tags.Items.INGOTS).addTag(INGOT_TAG)
        RAW_TAG.add(RAW.item())
        tag(Tags.Items.RAW_MATERIALS).addTag(RAW_TAG)
        NUGGET_TAG.add(NUGGET.item())
        tag(Tags.Items.NUGGETS).addTag(NUGGET_TAG)

        // Etc.
        ItemTags.BEACON_PAYMENT_ITEMS.add(INGOT.item())

        copy(ORE_TAG, ORE_TAG_ITEM)
        copy(STORAGE_TAG, STORAGE_TAG_ITEM)
        copy(RAW_STORAGE_TAG, RAW_STORAGE_TAG_ITEM)
    }
    open fun<T> T.addTags()
    where T: BlockTagsProviderHelper, T: ModBlockInputHelper {
        for(ore in oreBlocksWithPrefix(prefix)) {
            val oreBlock = ore.get()
            if(ore.asItem().idWithoutNamespace.matches(Regex("deepslate_.*"))) {
                tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(oreBlock)
            }
            tag(ORE_TAG).add(oreBlock)
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(oreBlock)
        }
        for(metalBlock in metalBlocksWithPrefix(prefix)) {
            tag(STORAGE_TAG).add(metalBlock.get())
            tag(BlockTags.BEACON_BASE_BLOCKS).add(metalBlock.get())
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(metalBlock.get())
        }
        for(rawBlock in rawBlocksWithPrefix(prefix)) {
            tag(RAW_STORAGE_TAG).add(rawBlock.get())
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(rawBlock.get())
        }
        tag(Tags.Blocks.ORES).addTag(ORE_TAG)
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(STORAGE_TAG)
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(RAW_STORAGE_TAG)
    }
    open fun BlockStateProviderHelper.register() {

    }
    protected fun <T: Item> DeferredRegister.Items.doRegister(entry: Entry<T>) {
        // this is type-safe with the generic T;
        // the version where you iterate through, register, & set projected types isn't type safe (for reasons)
        entry.actual = register(entry.registryKey, entry.constructor)
    }
    protected open fun setOfEntries() = toolEntries.toSet() + combatItemEntries.toSet() + ingredientEntries.toSet()
    open fun DeferredRegister.Items.registerAll() {
        for(entry in (setOfEntries())) {
            // entry.actual = register(entry.registryKey, entry.constructor)
            doRegister(entry)
        }
    }

    open fun DeferredRegister.Blocks.registerAll() {

    }
    open fun<T> T.buildRecipes(output: RecipeOutput)
    where T: RecipeProviderHelper, T: ModBlockInputHelper {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, SWORD.item())
            .pattern(" A ")
            .pattern(" A ")
            .pattern(" C ")
            .define('A', INGOT.item())
            .define('C', Items.STICK)
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .unlockedBy(
                getHasName(Items.STICK), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, PICKAXE.item())
            .pattern("AAA")
            .pattern(" C ")
            .pattern(" C ")
            .define('A', INGOT.item())
            .define('C', Items.STICK)
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .unlockedBy(
                getHasName(Items.STICK), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, SHOVEL.item())
            .pattern(" A ")
            .pattern(" C ")
            .pattern(" C ")
            .define('A', INGOT.item())
            .define('C', Items.STICK)
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .unlockedBy(
                getHasName(Items.STICK), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, AXE.item())
            .pattern("AA ")
            .pattern("AC ")
            .pattern(" C ")
            .define('A', INGOT.item())
            .define('C', Items.STICK)
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .unlockedBy(
                getHasName(Items.STICK), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, HOE.item())
            .pattern("AA")
            .pattern(" C")
            .pattern(" C")
            .define('A', INGOT.item())
            .define('C', Items.STICK)
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .unlockedBy(
                getHasName(Items.STICK), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, HELMET.item())
            .pattern("AAA")
            .pattern("A A")
            .pattern("   ")
            .define('A', INGOT.item())
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, CHESTPLATE.item())
            .pattern("A A")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', INGOT.item())
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, LEGGINGS.item())
            .pattern("AAA")
            .pattern("A A")
            .pattern("A A")
            .define('A', INGOT.item())
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, BOOTS.item())
            .pattern("   ")
            .pattern("A A")
            .pattern("A A")
            .define('A', INGOT.item())
            .unlockedBy(
                getHasName(INGOT.item()), hasInInventory(INGOT.item())
            )
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, NUGGET.item(), 9)
            .pattern("A")
            .define('A', INGOT.item())
            .unlockedBy(getHasName(INGOT.item()), hasInInventory(INGOT.item()))
            .save(output)

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, INGOT.item())
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', NUGGET.item())
            .unlockedBy(getHasName(NUGGET.item()), hasInInventory(NUGGET.item()))
            .save(output, ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, "${INGOT.item().idWithoutNamespace}_from_${NUGGET.item().idWithoutNamespace}"))

        for(item in tools.toSet() + combatItems.toSet()) {
            basicBlastingAndSmeltingRecipe(item.get(), NUGGET.item(), output)
        }

        for(metalBlock in metalBlocksWithPrefix(prefix)) {
            blockFromItem(metalBlock, INGOT.item(), output)
        }
        for(rawBlock in rawBlocksWithPrefix(prefix)) {
            blockFromItem(rawBlock, RAW.item(), output)
        }
    }
}

