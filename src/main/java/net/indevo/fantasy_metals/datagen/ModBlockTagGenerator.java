package net.indevo.fantasy_metals.datagen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.block.ModBlocks;
import net.indevo.fantasy_metals.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, FantasyMetals.MOD_ID, existingFileHelper);
    }

    private static TagKey<Block> create(String p_203847_) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(p_203847_));
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(
                        ModBlocks.MYTHRIL_BLOCK.get(),
                        ModBlocks.RAW_MYTHRIL_BLOCK.get(),
                        ModBlocks.MYTHRIL_ORE.get(),
                        ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),

                        ModBlocks.ADAMANT_BLOCK.get(),
                        ModBlocks.RAW_ADAMANT_BLOCK.get(),
                        ModBlocks.ADAMANT_ORE.get(),

                        ModBlocks.CARMOT_BLOCK.get(),
                        ModBlocks.RAW_CARMOT_BLOCK.get(),
                        ModBlocks.CARMOT_ORE.get(),
                        ModBlocks.DEEPSlATE_CARMOT_ORE.get(),

                        ModBlocks.SARDONYX_ORE.get(),
                        ModBlocks.DEEPSLATE_SARDONYX_ORE.get(),

                        ModBlocks.ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),

                        ModBlocks.SARDONYX_BLOCK.get(),
                        ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.TSAVORITE_BLOCK.get(),
                        ModBlocks.TANZANITE_BLOCK.get(),
                        ModBlocks.BLACK_OPAL_BLOCK.get(),

                        ModBlocks.TANZANITE_ORE.get(),

                        ModBlocks.BLACK_OPAL_ORE.get(),

                        ModBlocks.TSAVORITE_ORE.get(),
                        ModBlocks.DEEPSLATE_TSAVORITE_ORE.get(),

                        ModBlocks.ORICHALCUM_BLOCK.get(),
                        ModBlocks.RAW_ORICHALCUM_BLOCK.get(),
                        ModBlocks.ORICHALCUM_ORE.get(),
                        ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(
                        ModBlocks.ORICHALCUM_BLOCK.get(),
                        ModBlocks.RAW_ORICHALCUM_BLOCK.get(),
                        ModBlocks.ORICHALCUM_ORE.get(),

                        ModBlocks.CARMOT_BLOCK.get(),
                        ModBlocks.RAW_CARMOT_BLOCK.get(),
                        ModBlocks.CARMOT_ORE.get(),
                        ModBlocks.DEEPSlATE_CARMOT_ORE.get(),

                        ModBlocks.BLACK_OPAL_ORE.get(),
                        ModBlocks.BLACK_OPAL_BLOCK.get(),

                        ModBlocks.TANZANITE_ORE.get(),
                        ModBlocks.TANZANITE_BLOCK.get(),

                        ModBlocks.SARDONYX_ORE.get(),
                        ModBlocks.DEEPSLATE_SARDONYX_ORE.get(),
                        ModBlocks.SARDONYX_BLOCK.get(),

                        ModBlocks.ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                        ModBlocks.ALEXANDRITE_BLOCK.get(),

                        ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get());

        this.tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(
                        ModBlocks.MYTHRIL_BLOCK.get(),
                        ModBlocks.RAW_MYTHRIL_BLOCK.get(),
                        ModBlocks.MYTHRIL_ORE.get(),
                        ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),

                        ModBlocks.TSAVORITE_ORE.get(),
                        ModBlocks.DEEPSLATE_TSAVORITE_ORE.get(),
                        ModBlocks.TSAVORITE_BLOCK.get(),

                        ModBlocks.ADAMANT_BLOCK.get(),
                        ModBlocks.RAW_ADAMANT_BLOCK.get(),
                        ModBlocks.ADAMANT_ORE.get());

        this.tag(ModTags.Blocks.STORAGE_BLOCKS)
                .add(
                        ModBlocks.MYTHRIL_BLOCK.get(),
                        ModBlocks.RAW_MYTHRIL_BLOCK.get(),

                        ModBlocks.ORICHALCUM_BLOCK.get(),
                        ModBlocks.RAW_ORICHALCUM_BLOCK.get(),

                        ModBlocks.CARMOT_BLOCK.get(),
                        ModBlocks.RAW_CARMOT_BLOCK.get(),

                        ModBlocks.SARDONYX_BLOCK.get(),
                        ModBlocks.ALEXANDRITE_BLOCK.get(),
                        ModBlocks.TSAVORITE_BLOCK.get(),
                        ModBlocks.TANZANITE_BLOCK.get(),
                        ModBlocks.BLACK_OPAL_BLOCK.get(),

                        ModBlocks.ADAMANT_BLOCK.get(),
                        ModBlocks.RAW_ADAMANT_BLOCK.get());

        this.tag(ModTags.Blocks.ORES)
                .add(
                        ModBlocks.MYTHRIL_ORE.get(),
                        ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),

                        ModBlocks.ORICHALCUM_ORE.get(),
                        ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),

                        ModBlocks.SARDONYX_ORE.get(),
                        ModBlocks.DEEPSLATE_SARDONYX_ORE.get(),

                        ModBlocks.ALEXANDRITE_ORE.get(),
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),

                        ModBlocks.TANZANITE_ORE.get(),

                        ModBlocks.BLACK_OPAL_ORE.get(),

                        ModBlocks.TSAVORITE_ORE.get(),
                        ModBlocks.DEEPSLATE_TSAVORITE_ORE.get(),

                        ModBlocks.CARMOT_ORE.get(),
                        ModBlocks.DEEPSlATE_CARMOT_ORE.get(),

                        ModBlocks.ADAMANT_ORE.get());
    }
}