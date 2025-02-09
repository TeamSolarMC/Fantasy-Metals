package net.teamsolar.fantasy_metals.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider
import net.neoforged.neoforge.registries.NeoForgeRegistries
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.worldgen.ModBiomeModifiers
import net.teamsolar.fantasy_metals.worldgen.ModConfiguredFeatures
import net.teamsolar.fantasy_metals.worldgen.ModPlacedFeatures
import java.util.concurrent.CompletableFuture

class ModDatapackProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider>): DatapackBuiltinEntriesProvider(output, registries, BUILDER, setOf(FantasyMetals.MODID)) {
    companion object {
        val BUILDER = RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap)
    }
}