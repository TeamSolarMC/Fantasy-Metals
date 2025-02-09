package net.teamsolar.fantasy_metals.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.IntrinsicHolderTagsProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredBlock
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.ModTags
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.item.GemItemSet
import net.teamsolar.fantasy_metals.item.ItemSet
import net.teamsolar.fantasy_metals.item.MetalEquipmentSet
import net.teamsolar.fantasy_metals.item.ModItems
import java.util.concurrent.CompletableFuture

class ModBlockTagGenerator(
    output: PackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper
) :
    BlockTagsProvider(output, lookupProvider, FantasyMetals.MODID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        val providerHelper = object: BlockTagsProviderHelper, ModBlockInputHelper {
            override fun tag(tagKey: TagKey<Block>): IntrinsicTagAppender<Block> = this@ModBlockTagGenerator.tag(tagKey)
            override val ORE_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.ORE_BLOCKS
            override val RAW_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.RAW_BLOCKS
            override val METAL_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.METAL_BLOCKS
        }
        fun MetalEquipmentSet.thenAddTags() = providerHelper.addTags()
        fun GemItemSet.thenAddTags() = providerHelper.addTags()
        fun IntrinsicHolderTagsProvider.IntrinsicTagAppender<Block>.addSet(set: ItemSet) {
            for(block in providerHelper.blocksWithPrefix(set.prefix)) {
                add(block.get())
            }
        }

        tag(ModTags.Blocks.INCORRECT_FOR_MYTHRIL_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)
        tag(ModTags.Blocks.INCORRECT_FOR_ADAMANT_TOOL).addTag(BlockTags.INCORRECT_FOR_NETHERITE_TOOL)
        tag(ModTags.Blocks.INCORRECT_FOR_ORICHALCUM_TOOL).addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
        tag(ModTags.Blocks.INCORRECT_FOR_CARMOT_TOOL).addTag(BlockTags.INCORRECT_FOR_DIAMOND_TOOL)

        ModItems.MYTHRIL_SET.thenAddTags()
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addSet(ModItems.MYTHRIL_SET)
        ModItems.ADAMANT_SET.thenAddTags()
        tag(BlockTags.NEEDS_DIAMOND_TOOL).addSet(ModItems.ADAMANT_SET)
        ModItems.ORICHALCUM_SET.thenAddTags()
        tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.ORICHALCUM_SET)
        ModItems.CARMOT_SET.thenAddTags()
        tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.CARMOT_SET)


        ModItems.ALEXANDRITE_SET.thenAddTags()
        tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.ALEXANDRITE_SET)
        ModItems.BLACK_OPAL_SET.thenAddTags()
        tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.BLACK_OPAL_SET)
        ModItems.TANZANITE_SET.thenAddTags()
        tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.TANZANITE_SET)
        ModItems.SARDONYX_SET.thenAddTags()
        tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.SARDONYX_SET)
        ModItems.TSAVORITE_SET.thenAddTags()
        tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.TSAVORITE_SET)
        // tag(BlockTags.NEEDS_IRON_TOOL).addSet(ModItems.)

        tag(Tags.Blocks.ORES_IN_GROUND_STONE).add(
            ModBlocks.MYTHRIL_ORE.get(),
            ModBlocks.ORICHALCUM_ORE.get(),
            ModBlocks.CARMOT_ORE.get(),

            ModBlocks.SARDONYX_ORE.get(),
            ModBlocks.ALEXANDRITE_ORE.get(),
            ModBlocks.TSAVORITE_ORE.get()
        )
        tag(Tags.Blocks.ORES_IN_GROUND_NETHERRACK).add(
            ModBlocks.BLACK_OPAL_ORE.get()
        )
        tag(ModTags.Blocks.ORES_IN_GROUND_ENDSTONE).add(
            ModBlocks.ADAMANT_ORE.get(),
            ModBlocks.TANZANITE_ORE.get()
        )
        tag(ModTags.Blocks.ORE_BEARING_ENDSTONE).add(
            Blocks.END_STONE
        )
    }

    override fun getName(): String {
        return "Block Tags"
    }
}
