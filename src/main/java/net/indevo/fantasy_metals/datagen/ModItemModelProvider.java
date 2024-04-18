package net.indevo.fantasy_metals.datagen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, FantasyMetals.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.MYTHRIL_INGOT);
        simpleItem(ModItems.MYTHRIL_NUGGET);
        simpleItem(ModItems.RAW_MYTHRIL);

        simpleItem(ModItems.ADAMANT_INGOT);
        simpleItem(ModItems.ADAMANT_NUGGET);
        simpleItem(ModItems.RAW_ADAMANT);

        simpleItem(ModItems.ORICHALCUM_INGOT);
        simpleItem(ModItems.ORICHALCUM_NUGGET);
        simpleItem(ModItems.RAW_ORICHALCUM);

        simpleItem(ModItems.CARMOT_INGOT);
        simpleItem(ModItems.CARMOT_NUGGET);
        simpleItem(ModItems.RAW_CARMOT);

        simpleItem(ModItems.SARDONYX);

        simpleItem(ModItems.ALEXANDRITE);

        simpleItem(ModItems.TANZANITE);

        simpleItem(ModItems.BLACK_OPAL);

        simpleItem(ModItems.TSAVORITE);

        handheldItem(ModItems.MYTHRIL_SWORD);
        handheldItem(ModItems.MYTHRIL_PICKAXE);
        handheldItem(ModItems.MYTHRIL_SHOVEL);
        handheldItem(ModItems.MYTHRIL_AXE);
        handheldItem(ModItems.MYTHRIL_HOE);

        handheldItem(ModItems.ADAMANT_SWORD);
        handheldItem(ModItems.ADAMANT_PICKAXE);
        handheldItem(ModItems.ADAMANT_SHOVEL);
        handheldItem(ModItems.ADAMANT_AXE);
        handheldItem(ModItems.ADAMANT_HOE);

        handheldItem(ModItems.ORICHALCUM_SWORD);
        handheldItem(ModItems.ORICHALCUM_PICKAXE);
        handheldItem(ModItems.ORICHALCUM_SHOVEL);
        handheldItem(ModItems.ORICHALCUM_AXE);
        handheldItem(ModItems.ORICHALCUM_HOE);

        handheldItem(ModItems.CARMOT_SWORD);
        handheldItem(ModItems.CARMOT_PICKAXE);
        handheldItem(ModItems.CARMOT_SHOVEL);
        handheldItem(ModItems.CARMOT_AXE);
        handheldItem(ModItems.CARMOT_HOE);

        handheldItem(ModItems.CARMOT_SWORD);
        handheldItem(ModItems.CARMOT_PICKAXE);
        handheldItem(ModItems.CARMOT_SHOVEL);
        handheldItem(ModItems.CARMOT_AXE);
        handheldItem(ModItems.CARMOT_HOE);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FantasyMetals.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(FantasyMetals.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FantasyMetals.MOD_ID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleBlockItemBlockTexture(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(FantasyMetals.MOD_ID, "block/" + item.getId().getPath()));
    }

    public void evenSimplerBlockItem(RegistryObject<Block> block) {
        this.withExistingParent(FantasyMetals.MOD_ID + ":" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath(),
                modLoc("block/" + ForgeRegistries.BLOCKS.getKey(block.get()).getPath()));
    }
}