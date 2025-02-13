package net.teamsolar.fantasy_metals.worldgen

import net.minecraft.core.HolderGetter
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.registries.DeferredBlock

interface ConfiguredFeaturesContext {
    fun overworldOre(oreBlock: DeferredBlock<out Block>, deepslateOreBlock: DeferredBlock<out Block>, key: ResourceKey<ConfiguredFeature<*, *>>, size: Int = 3, discardChance: Float? = null)
    fun netherOre(oreBlock: DeferredBlock<out Block>, key: ResourceKey<ConfiguredFeature<*, *>>, size: Int = 3, discardChance: Float? = null)
    fun endOre(oreBlock: DeferredBlock<out Block>, key: ResourceKey<ConfiguredFeature<*, *>>, size: Int = 3, discardChance: Float? = null)
    val stoneReplaceables: RuleTest
    val deepslateReplaceables: RuleTest
    val netherrackReplaceables: RuleTest
    val endReplaceables: RuleTest
    val context: BootstrapContext<ConfiguredFeature<*, *>>
}

interface PlacedFeaturesContext {
    val configuredFeatures: HolderGetter<ConfiguredFeature<*, *>>
    fun register(placedKey: ResourceKey<PlacedFeature>, oreKey: ResourceKey<ConfiguredFeature<*, *>>, modifiers: List<PlacementModifier>)
    val context: BootstrapContext<PlacedFeature>
}

interface BiomeModifierContext {
    val biomes: HolderGetter<Biome>
    val placedFeatures: HolderGetter<PlacedFeature>
    val context: BootstrapContext<BiomeModifier>
}