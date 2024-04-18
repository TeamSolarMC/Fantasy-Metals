package net.indevo.fantasy_metals.datagen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;


public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, FantasyMetals.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.MYTHRIL_BLOCK);
        blockWithItem(ModBlocks.RAW_MYTHRIL_BLOCK);
        blockWithItem(ModBlocks.MYTHRIL_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_MYTHRIL_ORE);

        blockWithItem(ModBlocks.ADAMANT_BLOCK);
        blockWithItem(ModBlocks.RAW_ADAMANT_BLOCK);
        blockWithItem(ModBlocks.ADAMANT_ORE);

        blockWithItem(ModBlocks.ORICHALCUM_BLOCK);
        blockWithItem(ModBlocks.RAW_ORICHALCUM_BLOCK);
        blockWithItem(ModBlocks.ORICHALCUM_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ORICHALCUM_ORE);

        blockWithItem(ModBlocks.CARMOT_BLOCK);
        blockWithItem(ModBlocks.RAW_CARMOT_BLOCK);
        blockWithItem(ModBlocks.CARMOT_ORE);
        blockWithItem(ModBlocks.DEEPSlATE_CARMOT_ORE);

        blockWithItem(ModBlocks.SARDONYX_BLOCK);
        blockWithItem(ModBlocks.ALEXANDRITE_BLOCK);
        blockWithItem(ModBlocks.TSAVORITE_BLOCK);
        blockWithItem(ModBlocks.TANZANITE_BLOCK);
        blockWithItem(ModBlocks.BLACK_OPAL_BLOCK);

        blockWithItem(ModBlocks.SARDONYX_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_SARDONYX_ORE);

        blockWithItem(ModBlocks.ALEXANDRITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE);

        blockWithItem(ModBlocks.TANZANITE_ORE);

        blockWithItem(ModBlocks.BLACK_OPAL_ORE);

        blockWithItem(ModBlocks.TSAVORITE_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_TSAVORITE_ORE);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
