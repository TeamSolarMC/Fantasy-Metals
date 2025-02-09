package net.teamsolar.fantasy_metals.datagen

import net.minecraft.data.DataGenerator
import net.minecraft.data.DataProvider
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.data.event.GatherDataEvent
import net.teamsolar.fantasy_metals.FantasyMetals
import java.util.Collections

@EventBusSubscriber(modid = FantasyMetals.MODID, bus = EventBusSubscriber.Bus.MOD)
object DataGenerators {
    @SubscribeEvent
    fun gatherData(event: GatherDataEvent) {
        fun <T: DataProvider> DataGenerator.add(provider: T) {
            addProvider(event.includeServer(), provider)
        }
        FantasyMetals.LOGGER.info("Loading gatherdata")
        val generator = event.generator
        val packOutput = generator.packOutput
        val existingFileHelper = event.existingFileHelper
        val lookupProvider = event.lookupProvider
        generator.add(ModItemModelProvider(packOutput, existingFileHelper))
        generator.add(ModBlockStateProvider(packOutput, existingFileHelper))
        val blockTagGenerator = ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper)
            .also{generator.add(it)}

        generator.add(ModItemTagsProvider(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper))
        generator.add(ModBiomeTagsProvider(packOutput, lookupProvider, existingFileHelper))
        // Must pass in our own lookupProvider or else datagen won't know where to find our enchantment in registries... apparently
        generator.add(ModRecipeProvider(packOutput, lookupProvider))
        generator.add(LootTableProvider(packOutput, Collections.emptySet(),
            listOf(LootTableProvider.SubProviderEntry(::ModBlockLootTableProvider, LootContextParamSets.BLOCK)), lookupProvider))
        generator.add(ModDatapackProvider(packOutput, lookupProvider))
    }
}