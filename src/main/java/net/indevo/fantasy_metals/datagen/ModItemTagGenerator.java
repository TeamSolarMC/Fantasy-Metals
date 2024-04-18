package net.indevo.fantasy_metals.datagen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.item.ModItems;
import net.indevo.fantasy_metals.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_,
                               CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, FantasyMetals.MOD_ID, existingFileHelper);
    }


    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTags.Items.INGOTS)
                .add(
                        ModItems.MYTHRIL_INGOT.get(),
                        ModItems.ORICHALCUM_INGOT.get(),
                        ModItems.CARMOT_INGOT.get(),
                        ModItems.ADAMANT_INGOT.get());

        this.tag(ModTags.Items.NUGGETS)
                .add(
                        ModItems.MYTHRIL_NUGGET.get(),
                        ModItems.ORICHALCUM_NUGGET.get(),
                        ModItems.CARMOT_NUGGET.get(),
                        ModItems.ADAMANT_NUGGET.get());

        this.tag(ModTags.Items.RAW_MATERIALS)
                .add(
                        ModItems.RAW_MYTHRIL.get(),
                        ModItems.RAW_ORICHALCUM.get(),
                        ModItems.RAW_CARMOT.get(),
                        ModItems.RAW_ADAMANT.get());

        this.tag(ModTags.Items.GEMS)
                .add(
                        ModItems.SARDONYX.get(),
                        ModItems.ALEXANDRITE.get(),
                        ModItems.TANZANITE.get(),
                        ModItems.BLACK_OPAL.get(),
                        ModItems.TSAVORITE.get());

        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.MYTHRIL_HELMET.get(),
                        ModItems.MYTHRIL_CHESTPLATE.get(),
                        ModItems.MYTHRIL_LEGGINGS.get(),
                        ModItems.MYTHRIL_BOOTS.get(),
                        ModItems.ADAMANT_HELMET.get(),
                        ModItems.ADAMANT_CHESTPLATE.get(),
                        ModItems.ADAMANT_LEGGINGS.get(),
                        ModItems.ADAMANT_BOOTS.get(),
                        ModItems.ORICHALCUM_HELMET.get(),
                        ModItems.ORICHALCUM_CHESTPLATE.get(),
                        ModItems.ORICHALCUM_LEGGINGS.get(),
                        ModItems.ORICHALCUM_BOOTS.get(),
                        ModItems.CARMOT_HELMET.get(),
                        ModItems.CARMOT_CHESTPLATE.get(),
                        ModItems.CARMOT_LEGGINGS.get(),
                        ModItems.CARMOT_BOOTS.get());

        this.tag(ModTags.Items.SWORDS)
                .add(ModItems.MYTHRIL_SWORD.get(),
                        ModItems.ADAMANT_SWORD.get(),
                        ModItems.ORICHALCUM_SWORD.get(),
                        ModItems.CARMOT_SWORD.get());

        this.tag(ModTags.Items.PICKAXES)
                .add(ModItems.MYTHRIL_PICKAXE.get(),
                        ModItems.ADAMANT_PICKAXE.get(),
                        ModItems.CARMOT_PICKAXE.get(),
                        ModItems.ORICHALCUM_PICKAXE.get());

        this.tag(ModTags.Items.AXES)
                .add(ModItems.MYTHRIL_AXE.get(),
                        ModItems.ADAMANT_AXE.get(),
                        ModItems.CARMOT_AXE.get(),
                        ModItems.ORICHALCUM_AXE.get());

        this.tag(ModTags.Items.SHOVELS)
                .add(ModItems.MYTHRIL_SHOVEL.get(),
                        ModItems.ADAMANT_SHOVEL.get(),
                        ModItems.CARMOT_SHOVEL.get(),
                        ModItems.ORICHALCUM_SHOVEL.get());

        this.tag(ModTags.Items.HOES)
                .add(ModItems.MYTHRIL_HOE.get(),
                        ModItems.ADAMANT_HOE.get(),
                        ModItems.CARMOT_HOE.get(),
                        ModItems.ORICHALCUM_HOE.get());

        this.tag(ModTags.Items.HELMETS)
                .add(ModItems.MYTHRIL_HELMET.get(),
                        ModItems.ADAMANT_HELMET.get(),
                        ModItems.CARMOT_HELMET.get(),
                        ModItems.ORICHALCUM_HELMET.get());

        this.tag(ModTags.Items.CHESTPLATES)
                .add(ModItems.MYTHRIL_CHESTPLATE.get(),
                        ModItems.ADAMANT_CHESTPLATE.get(),
                        ModItems.CARMOT_CHESTPLATE.get(),
                        ModItems.ORICHALCUM_CHESTPLATE.get());

        this.tag(ModTags.Items.LEGGINGS)
                .add(ModItems.MYTHRIL_LEGGINGS.get(),
                        ModItems.ADAMANT_LEGGINGS.get(),
                        ModItems.CARMOT_LEGGINGS.get(),
                        ModItems.ORICHALCUM_LEGGINGS.get());

        this.tag(ModTags.Items.BOOTS)
                .add(ModItems.MYTHRIL_BOOTS.get(),
                        ModItems.ADAMANT_BOOTS.get(),
                        ModItems.CARMOT_BOOTS.get(),
                        ModItems.ORICHALCUM_BOOTS.get());
    }
}
