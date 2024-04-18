package net.indevo.fantasy_metals.datagen.loot;

import net.indevo.fantasy_metals.block.ModBlocks;
import net.indevo.fantasy_metals.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(ModBlocks.MYTHRIL_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_MYTHRIL_BLOCK.get());

        this.dropSelf(ModBlocks.ADAMANT_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ADAMANT_BLOCK.get());

        this.dropSelf(ModBlocks.ORICHALCUM_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_ORICHALCUM_BLOCK.get());

        this.dropSelf(ModBlocks.CARMOT_BLOCK.get());
        this.dropSelf(ModBlocks.RAW_CARMOT_BLOCK.get());

        this.dropSelf(ModBlocks.SARDONYX_BLOCK.get());
        this.dropSelf(ModBlocks.ALEXANDRITE_BLOCK.get());

        this.dropSelf(ModBlocks.TSAVORITE_BLOCK.get());
        this.dropSelf(ModBlocks.TANZANITE_BLOCK.get());

        this.dropSelf(ModBlocks.BLACK_OPAL_BLOCK.get());

        this.add(ModBlocks.MYTHRIL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));
        this.add(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get(), ModItems.RAW_MYTHRIL.get()));

        this.add(ModBlocks.ADAMANT_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ADAMANT_ORE.get(), ModItems.RAW_ADAMANT.get()));

        this.add(ModBlocks.ORICHALCUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ORICHALCUM_ORE.get(), ModItems.RAW_ORICHALCUM.get()));
        this.add(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get(), ModItems.RAW_ORICHALCUM.get()));

        this.add(ModBlocks.CARMOT_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.CARMOT_ORE.get(), ModItems.RAW_CARMOT.get()));
        this.add(ModBlocks.DEEPSlATE_CARMOT_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSlATE_CARMOT_ORE.get(), ModItems.RAW_CARMOT.get()));

        this.add(ModBlocks.SARDONYX_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.SARDONYX_ORE.get(), ModItems.SARDONYX.get()));
        this.add(ModBlocks.DEEPSLATE_SARDONYX_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_SARDONYX_ORE.get(), ModItems.SARDONYX.get()));

        this.add(ModBlocks.ALEXANDRITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.ALEXANDRITE_ORE.get(), ModItems.ALEXANDRITE.get()));
        this.add(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get(), ModItems.ALEXANDRITE.get()));

        this.add(ModBlocks.TANZANITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TANZANITE_ORE.get(), ModItems.TANZANITE.get()));

        this.add(ModBlocks.BLACK_OPAL_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.BLACK_OPAL_ORE.get(), ModItems.BLACK_OPAL.get()));

        this.add(ModBlocks.TSAVORITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.TSAVORITE_ORE.get(), ModItems.TSAVORITE.get()));
        this.add(ModBlocks.DEEPSLATE_TSAVORITE_ORE.get(),
                block -> createCopperLikeOreDrops(ModBlocks.DEEPSLATE_TSAVORITE_ORE.get(), ModItems.TSAVORITE.get()));

    }

    protected LootTable.Builder createCopperLikeOreDrops(Block pBlock, Item item) {
        return createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock,
                        LootItem.lootTableItem(item)
                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 5.0F)))
                                .apply(ApplyBonusCount.addOreBonusCount(Enchantments.BLOCK_FORTUNE))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
