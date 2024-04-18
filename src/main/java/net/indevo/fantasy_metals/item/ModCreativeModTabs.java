package net.indevo.fantasy_metals.item;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, FantasyMetals.MOD_ID);

    public static final RegistryObject<CreativeModeTab> FANTASY_METALS_TAB = CREATIVE_MODE_TABS.register("fantasy_metals_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ADAMANT_INGOT.get()))
                    .title(Component.translatable("creativetab.fantasy_metals_tab"))
                    .displayItems(((pParameters, pOutput) -> {
                        pOutput.accept(ModBlocks.MYTHRIL_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_MYTHRIL_BLOCK.get());
                        pOutput.accept(ModBlocks.MYTHRIL_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_MYTHRIL_ORE.get());

                        pOutput.accept(ModBlocks.ADAMANT_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ADAMANT_BLOCK.get());
                        pOutput.accept(ModBlocks.ADAMANT_ORE.get());

                        pOutput.accept(ModBlocks.ORICHALCUM_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_ORICHALCUM_BLOCK.get());
                        pOutput.accept(ModBlocks.ORICHALCUM_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get());

                        pOutput.accept(ModBlocks.CARMOT_BLOCK.get());
                        pOutput.accept(ModBlocks.RAW_CARMOT_BLOCK.get());
                        pOutput.accept(ModBlocks.CARMOT_ORE.get());

                        pOutput.accept(ModBlocks.SARDONYX_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_SARDONYX_ORE.get());

                        pOutput.accept(ModBlocks.ALEXANDRITE_ORE.get());
                        pOutput.accept(ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get());

                        pOutput.accept(ModBlocks.TANZANITE_ORE.get());

                        pOutput.accept(ModBlocks.BLACK_OPAL_ORE.get());

                        pOutput.accept(ModBlocks.TSAVORITE_ORE.get());

                        pOutput.accept(ModBlocks.SARDONYX_BLOCK.get());
                        pOutput.accept(ModBlocks.ALEXANDRITE_BLOCK.get());
                        pOutput.accept(ModBlocks.TSAVORITE_BLOCK.get());
                        pOutput.accept(ModBlocks.TANZANITE_BLOCK.get());
                        pOutput.accept(ModBlocks.BLACK_OPAL_BLOCK.get());



                        pOutput.accept(ModItems.RAW_MYTHRIL.get());
                        pOutput.accept(ModItems.MYTHRIL_INGOT.get());
                        pOutput.accept(ModItems.MYTHRIL_NUGGET.get());

                        pOutput.accept(ModItems.RAW_ADAMANT.get());
                        pOutput.accept(ModItems.ADAMANT_INGOT.get());
                        pOutput.accept(ModItems.ADAMANT_NUGGET.get());

                        pOutput.accept(ModItems.RAW_ORICHALCUM.get());
                        pOutput.accept(ModItems.ORICHALCUM_INGOT.get());
                        pOutput.accept(ModItems.ORICHALCUM_NUGGET.get());

                        pOutput.accept(ModItems.RAW_CARMOT.get());
                        pOutput.accept(ModItems.CARMOT_INGOT.get());
                        pOutput.accept(ModItems.CARMOT_NUGGET.get());

                        pOutput.accept(ModItems.SARDONYX.get());

                        pOutput.accept(ModItems.ALEXANDRITE.get());

                        pOutput.accept(ModItems.TANZANITE.get());

                        pOutput.accept(ModItems.BLACK_OPAL.get());

                        pOutput.accept(ModItems.TSAVORITE.get());

                        pOutput.accept(ModItems.MYTHRIL_SWORD.get());
                        pOutput.accept(ModItems.MYTHRIL_PICKAXE.get());
                        pOutput.accept(ModItems.MYTHRIL_SHOVEL.get());
                        pOutput.accept(ModItems.MYTHRIL_AXE.get());
                        pOutput.accept(ModItems.MYTHRIL_HOE.get());

                        pOutput.accept(ModItems.MYTHRIL_HELMET.get());
                        pOutput.accept(ModItems.MYTHRIL_CHESTPLATE.get());
                        pOutput.accept(ModItems.MYTHRIL_LEGGINGS.get());
                        pOutput.accept(ModItems.MYTHRIL_BOOTS.get());

                        pOutput.accept(ModItems.ADAMANT_SWORD.get());
                        pOutput.accept(ModItems.ADAMANT_PICKAXE.get());
                        pOutput.accept(ModItems.ADAMANT_SHOVEL.get());
                        pOutput.accept(ModItems.ADAMANT_AXE.get());
                        pOutput.accept(ModItems.ADAMANT_HOE.get());

                        pOutput.accept(ModItems.ADAMANT_HELMET.get());
                        pOutput.accept(ModItems.ADAMANT_CHESTPLATE.get());
                        pOutput.accept(ModItems.ADAMANT_LEGGINGS.get());
                        pOutput.accept(ModItems.ADAMANT_BOOTS.get());

                        pOutput.accept(ModItems.ORICHALCUM_SWORD.get());
                        pOutput.accept(ModItems.ORICHALCUM_PICKAXE.get());
                        pOutput.accept(ModItems.ORICHALCUM_SHOVEL.get());
                        pOutput.accept(ModItems.ORICHALCUM_AXE.get());
                        pOutput.accept(ModItems.ORICHALCUM_HOE.get());

                        pOutput.accept(ModItems.ORICHALCUM_HELMET.get());
                        pOutput.accept(ModItems.ORICHALCUM_CHESTPLATE.get());
                        pOutput.accept(ModItems.ORICHALCUM_LEGGINGS.get());
                        pOutput.accept(ModItems.ORICHALCUM_BOOTS.get());

                        pOutput.accept(ModItems.CARMOT_SWORD.get());
                        pOutput.accept(ModItems.CARMOT_PICKAXE.get());
                        pOutput.accept(ModItems.CARMOT_SHOVEL.get());
                        pOutput.accept(ModItems.CARMOT_AXE.get());
                        pOutput.accept(ModItems.CARMOT_HOE.get());

                        pOutput.accept(ModItems.CARMOT_HELMET.get());
                        pOutput.accept(ModItems.CARMOT_CHESTPLATE.get());
                        pOutput.accept(ModItems.CARMOT_LEGGINGS.get());
                        pOutput.accept(ModItems.CARMOT_BOOTS.get());
                    }))
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
