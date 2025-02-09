package net.teamsolar.fantasy_metals

import com.mojang.logging.LogUtils
import net.minecraft.client.Minecraft
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.CreativeModeTabs
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.event.server.ServerStartingEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.item.MetalEquipmentSet
import net.teamsolar.fantasy_metals.item.ModArmorMaterials
import net.teamsolar.fantasy_metals.item.ModCreativeModeTabs
import net.teamsolar.fantasy_metals.item.ModItems
import java.util.function.Supplier

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(FantasyMetals.MODID)
class FantasyMetals {
    companion object {
        // Define mod id in a common place for everything to reference
        const val MODID = "fantasy_metals"
        // Directly reference a slf4j logger
        val LOGGER: org.slf4j.Logger = LogUtils.getLogger();

        // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "examplemod" namespace

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
        object ClientModEvents {
            @SubscribeEvent
            fun onClientSetup(event: FMLClientSetupEvent?) {
                // Some client setup code
                LOGGER.info("HELLO FROM CLIENT SETUP")
                LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().user.name)
            }
        }
    }

    constructor(modEventBus: IEventBus, modContainer: ModContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(::commonSetup)

        // Register the Deferred Register to the mod event bus so blocks get registered
        // BLOCKS.register(modEventBus)
        // Register the Deferred Register to the mod event bus so items get registered
        // Register armor materials before items
        ModItems.register(modEventBus)
        ModBlocks.register(modEventBus)
        ModArmorMaterials.register(modEventBus)
        // Register the Deferred Register to the mod event bus so tabs get registered
        ModCreativeModeTabs.register(modEventBus)

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this)

        // Register the item to a creative tab
        modEventBus.addListener(::addCreative)

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP")
    }

    // Add the example block item to the building blocks tab
    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {
        when(event.tabKey) {
            CreativeModeTabs.TOOLS_AND_UTILITIES -> {
                event.acceptAll(
                    (
                        ModItems.MYTHRIL_SET.tools
                            + ModItems.ADAMANT_SET.tools
                            + ModItems.ORICHALCUM_SET.tools
                            + ModItems.CARMOT_SET.tools
                    ).map{it.toStack()})
            }
            CreativeModeTabs.COMBAT -> {
                event.acceptAll(
                    (
                            ModItems.MYTHRIL_SET.combatItems
                                    + ModItems.ADAMANT_SET.combatItems
                                    + ModItems.ORICHALCUM_SET.combatItems
                                    + ModItems.CARMOT_SET.combatItems
                            ).map{it.toStack()})
            }
            CreativeModeTabs.INGREDIENTS -> {
                event.acceptAll(
                    (
                        ModItems.MYTHRIL_SET.ingredients
                        + ModItems.ADAMANT_SET.ingredients
                        + ModItems.ORICHALCUM_SET.ingredients
                        + ModItems.CARMOT_SET.ingredients
                    ).map{it.toStack()}.sortedBy { BuiltInRegistries.ITEM.getKey(it.item).path }
                    + (ModItems.GEMS).map { it.GEM.toStack() }
                )

            }
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting")
    }
}