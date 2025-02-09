package net.teamsolar.fantasy_metals.item

import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.FantasyMetals.Companion
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.datagen.ModBlockInputHelper
import java.util.function.Supplier


object ModCreativeModeTabs: ModBlockInputHelper {
    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create<CreativeModeTab>(Registries.CREATIVE_MODE_TAB, FantasyMetals.MODID)

    val TOOLS_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_MODE_TABS.register("fantasy_metals_items",
        Supplier {
            CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.fantasy_metals")) //The language key for the title of your CreativeModeTab
                .icon { ModItems.ADAMANT_SET.INGOT.item().defaultInstance }
                .displayItems { parameters: ItemDisplayParameters, output: CreativeModeTab.Output ->
                    fun addSet(set: MetalEquipmentSet) {
                        output.accept(set.RAW.item())
                        output.accept(set.INGOT.item())
                        output.accept(set.NUGGET.item())
                        for (item in set.tools.toSet() + set.combatItems.toSet()) {
                            output.accept(item)
                        }
                    }
                    for(block in BLOCKS) {
                        output.accept(block.asItem())
                    }
                    addSet(ModItems.MYTHRIL_SET)
                    addSet(ModItems.ADAMANT_SET)
                    addSet(ModItems.ORICHALCUM_SET)
                    addSet(ModItems.CARMOT_SET)

                    for(gem in ModItems.GEMS) {
                        output.accept(gem.GEM)
                    }
                    // output.accept(EXAMPLE_ITEM.get()) // Add the example item to the tab. For your own tabs, this method is preferred over the event
                }
                .build()
        })
    /*val BLOCKS_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_MODE_TABS.register("fantasy_metals_blocks",
        Supplier {
            CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.fantasy_metals.blocks"))
                .icon { ModBlocks.CARMOT_ORE.asItem().defaultInstance }
                .displayItems {
                        parameters: ItemDisplayParameters, output: CreativeModeTab.Output ->
                    for(ore in ModBlocks.ORE_BLOCKS) {
                        output.accept(ore)
                    }
                    for(metalBlock in ModBlocks.METAL_BLOCKS) {
                        output.accept(metalBlock)
                    }
                    for(rawBlock in ModBlocks.RAW_BLOCKS) {
                        output.accept(rawBlock)
                    }
                }
                .withTabsBefore(TOOLS_TAB.id)
                .build()
        })*/

    private fun oreBlocksAssociatedWith(set: MetalEquipmentSet) = oreBlocksWithPrefix(set.prefix)
    private fun rawBlocksAssociatedWith(set: MetalEquipmentSet) = rawBlocksWithPrefix(set.prefix)
    private fun metalBlocksAssociatedWith(set: MetalEquipmentSet) = metalBlocksWithPrefix(set.prefix)

    fun register(eventBus: IEventBus) {
        CREATIVE_MODE_TABS.register(eventBus)
    }

    override val ORE_BLOCKS = ModBlocks.ORE_BLOCKS
    override val RAW_BLOCKS = ModBlocks.RAW_BLOCKS
    override val METAL_BLOCKS = ModBlocks.METAL_BLOCKS
}