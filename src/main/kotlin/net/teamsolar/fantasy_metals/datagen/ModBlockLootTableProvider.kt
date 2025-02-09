package net.teamsolar.fantasy_metals.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.Registries
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantments
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.entries.LootItem
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredHolder
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.item.ModItems


class ModBlockLootTableProvider(registries: HolderLookup.Provider): BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags(), registries),
    ModBlockInputHelper {
    override fun generate() {
        for(block in ModBlocks.METAL_BLOCKS) {
            dropSelf(block.get())
        }
        for(block in ModBlocks.RAW_BLOCKS) {
            dropSelf(block.get())
        }
        val metals = setOf(ModItems.MYTHRIL_SET, ModItems.ADAMANT_SET, ModItems.ORICHALCUM_SET, ModItems.CARMOT_SET)
        for(metalSet in metals) {
            for(ore in oreBlocksWithPrefix(metalSet.prefix)) {
                add(ore.get(), createOreDrops(ore.get(), metalSet.RAW.item()))
            }
        }
        for(gem in ModItems.GEMS) {
            for(ore in oreBlocksWithPrefix(gem.prefix)) {
                add(ore.get(), createOreDrops(ore.get(), gem.GEM.get()))
            }
        }
    }
    override fun getKnownBlocks(): Iterable<Block> {
        val streamMap = ModBlocks.BLOCKS_REGISTER.entries.stream().map { obj: DeferredHolder<Block, out Block> -> obj.value() }
        return Iterable(streamMap::iterator)
    }
    private fun createCopperLikeOreDrops(block: Block, item: Item): LootTable.Builder {
        val registrylookup = registries.lookupOrThrow(Registries.ENCHANTMENT)
        return this.createSilkTouchDispatchTable(
            block,
            applyExplosionDecay(
                block,
                LootItem.lootTableItem(item)
                    .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0f, 5.0f)))
                    .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }
    private fun createOreDrops(block: Block, item: Item): LootTable.Builder {
        val registrylookup = registries.lookupOrThrow(Registries.ENCHANTMENT)
        return this.createSilkTouchDispatchTable(
            block,
            applyExplosionDecay(
                block,
                LootItem.lootTableItem(item)
                //    .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
            ) as LootPoolEntryContainer.Builder<*>
        )
    }


    override val ORE_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.ORE_BLOCKS
    override val RAW_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.RAW_BLOCKS
    override val METAL_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.METAL_BLOCKS
}