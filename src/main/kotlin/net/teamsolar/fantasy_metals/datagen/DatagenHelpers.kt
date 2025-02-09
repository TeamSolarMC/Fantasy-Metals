package net.teamsolar.fantasy_metals.datagen

import net.minecraft.advancements.Criterion
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.advancements.critereon.ItemPredicate
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.data.tags.IntrinsicHolderTagsProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.TagKey
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredItem
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.block.ModBlocks

interface ProviderHelper {
    val Item.idWithoutNamespace: String
        get() = BuiltInRegistries.ITEM.getKey(this).path
}

interface ItemModelProviderHelper: ProviderHelper {
    fun handheldItem(item: DeferredItem<out Item>)
    fun simpleItem(item: DeferredItem<out Item>)
    fun trimmedArmorItem(armorItem: DeferredItem<out ArmorItem>)
}

interface BlockStateProviderHelper: ProviderHelper {
    fun blockWithItem(block: DeferredBlock<Block>)
}

interface RecipeProviderHelper: ProviderHelper {
    fun inventoryTrigger(predicates: ItemPredicate): Criterion<InventoryChangeTrigger.TriggerInstance>
    fun getHasName(item: ItemLike): String
    fun hasInInventory(item: ItemLike): Criterion<InventoryChangeTrigger.TriggerInstance>

    fun basicBlastingAndSmeltingRecipe(input: Item, outputItem: Item, output: RecipeOutput, category: RecipeCategory = RecipeCategory.MISC, xp: Float = 0.1f) {
        val unqualifiedItemName = input.idWithoutNamespace
        SimpleCookingRecipeBuilder.blasting(
            Ingredient.of(input),
            category,
            outputItem,
            xp,
            100
        )
            .unlockedBy(getHasName(input), hasInInventory(input))
            .save(output, ResourceLocation.withDefaultNamespace(unqualifiedItemName + "_blasting"))
        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(input),
            category,
            outputItem,
            xp,
            200
        )
            .unlockedBy(getHasName(input), hasInInventory(input))
            .save(output, ResourceLocation.withDefaultNamespace(unqualifiedItemName + "_smelting"))
    }
    fun blockFromItem(block: ItemLike, item: ItemLike, output: RecipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, item, 9)
            .pattern("A")
            .define('A', block)
            .unlockedBy(getHasName(block), hasInInventory(block))
            .save(output, ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, "${item.asItem().idWithoutNamespace}_from_${block.asItem().idWithoutNamespace}"))

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, block)
            .pattern("AAA")
            .pattern("AAA")
            .pattern("AAA")
            .define('A', item)
            .unlockedBy(getHasName(item), hasInInventory(item))
            .save(output, ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, "${block.asItem().idWithoutNamespace}_from_${item.asItem().idWithoutNamespace}"))
    }
}

interface ModBlockInputHelper: ProviderHelper {
    val ORE_BLOCKS: List<DeferredBlock<out Block>>
    val RAW_BLOCKS: List<DeferredBlock<out Block>>
    val METAL_BLOCKS: List<DeferredBlock<out Block>>
    val BLOCKS: List<DeferredBlock<out Block>>
        get() = ModBlocks.ORE_BLOCKS + ModBlocks.RAW_BLOCKS + ModBlocks.METAL_BLOCKS
    fun metalBlocksWithPrefix(prefix: String): List<DeferredBlock<out Block>> = METAL_BLOCKS
        .filter { it.asItem().idWithoutNamespace.matches(Regex(prefix + "_block")) }

    fun oreBlocksWithPrefix(prefix: String): List<DeferredBlock<out Block>> = ORE_BLOCKS
        .filter { it.asItem().idWithoutNamespace.matches(Regex(".*" + prefix + "_ore")) }

    fun rawBlocksWithPrefix(prefix: String): List<DeferredBlock<out Block>> = RAW_BLOCKS
        .filter { it.asItem().idWithoutNamespace.matches(Regex("raw_" + prefix + "_block")) }
    fun blocksWithPrefix(prefix: String) = metalBlocksWithPrefix(prefix) + oreBlocksWithPrefix(prefix) + rawBlocksWithPrefix(prefix)
}

interface ItemTagsProviderHelper: ProviderHelper {
    fun tag(tagKey: TagKey<Item>): IntrinsicHolderTagsProvider.IntrinsicTagAppender<Item>
    fun TagKey<Item>.add(t: Item) {
        tag(this).add(t)
    }
    fun copy(blockTag: TagKey<Block>, itemTag: TagKey<Item>)
}

interface BlockTagsProviderHelper: ProviderHelper {
    fun tag(tagKey: TagKey<Block>): IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block>
    fun TagKey<Block>.add(t: Block) {
        tag(this).add(t)
    }
}