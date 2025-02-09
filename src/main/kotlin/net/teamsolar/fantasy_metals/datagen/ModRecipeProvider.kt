package net.teamsolar.fantasy_metals.datagen

import net.minecraft.advancements.Criterion
import net.minecraft.advancements.critereon.InventoryChangeTrigger
import net.minecraft.advancements.critereon.ItemPredicate
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.ItemLike
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.conditions.IConditionBuilder
import net.neoforged.neoforge.registries.DeferredBlock
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.item.GemItemSet
import net.teamsolar.fantasy_metals.item.MetalEquipmentSet
import net.teamsolar.fantasy_metals.item.ModItems
import java.util.concurrent.CompletableFuture

class ModRecipeProvider(packOutput: PackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>) :
    RecipeProvider(packOutput, lookupProvider), IConditionBuilder {
    override fun buildRecipes(output: RecipeOutput) {
        fun doInventoryTrigger(predicates: ItemPredicate): Criterion<InventoryChangeTrigger.TriggerInstance>
                = inventoryTrigger(predicates)
        fun doGetHasName(item: ItemLike) = getHasName(item)
        val recipeProviderHelper = object: RecipeProviderHelper, ModBlockInputHelper {
            override fun inventoryTrigger(predicates: ItemPredicate): Criterion<InventoryChangeTrigger.TriggerInstance>
                = doInventoryTrigger(predicates)

            override fun getHasName(item: ItemLike): String = doGetHasName(item)
            override fun hasInInventory(item: ItemLike) = inventoryTrigger(ItemPredicate.Builder.item().of(item).build())

            override val ORE_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.ORE_BLOCKS
            override val RAW_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.RAW_BLOCKS
            override val METAL_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.METAL_BLOCKS
        }

        fun MetalEquipmentSet.thenBuildRecipes() = recipeProviderHelper.buildRecipes(output)
        fun GemItemSet.thenBuildRecipes() = recipeProviderHelper.buildRecipes(output)

        val metalSetSmeltingXPAmounts = mapOf(
            ModItems.MYTHRIL_SET to 0.7f,
            ModItems.ADAMANT_SET to 0.7f,
            ModItems.ORICHALCUM_SET to 0.7f,
            ModItems.CARMOT_SET to 0.7f
        )

        ModItems.MYTHRIL_SET.thenBuildRecipes()
        ModItems.ADAMANT_SET.thenBuildRecipes()
        ModItems.ORICHALCUM_SET.thenBuildRecipes()
        ModItems.CARMOT_SET.thenBuildRecipes()
        // Crafting blocks from gems and gems from blocks

        /*blockFromItem(ModBlocks.SARDONYX_BLOCK.asItem(), ModItems.SARDONYX.get())
        blockFromItem(ModBlocks.ALEXANDRITE_BLOCK.asItem(), ModItems.ALEXANDRITE.get())
        blockFromItem(ModBlocks.TANZANITE_BLOCK.asItem(), ModItems.TANZANITE.get())
        blockFromItem(ModBlocks.BLACK_OPAL_BLOCK.asItem(), ModItems.BLACK_OPAL.get())
        blockFromItem(ModBlocks.TSAVORITE_BLOCK.asItem(), ModItems.TSAVORITE.get())*/
        with(recipeProviderHelper) {
            for((set, xp) in metalSetSmeltingXPAmounts) {
                basicBlastingAndSmeltingRecipe(set.RAW.item(), set.INGOT.item(), output, xp = xp)
                for(ore in oreBlocksWithPrefix(set.prefix)) {
                    basicBlastingAndSmeltingRecipe(ore.asItem(), set.INGOT.item(), output, xp = xp)
                }
            }
            for(gem in ModItems.GEMS) {
                for(ore in oreBlocksWithPrefix(gem.prefix)) {
                    basicBlastingAndSmeltingRecipe(ore.asItem(), gem.GEM.asItem(), output, xp = 0.7f)
                }
                gem.thenBuildRecipes()
                /*for(metalBlock in recipeProviderHelper.metalBlocksWithPrefix(gem.prefix)) {
                    recipeProviderHelper.blockFromItem(metalBlock.get(), gem.GEM, output)
                }*/
            }
        }


    }
}
