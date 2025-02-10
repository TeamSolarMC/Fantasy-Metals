package net.teamsolar.fantasy_metals.worldgen

import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderSet
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BiomeTags
import net.minecraft.tags.TagKey
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.RotatedPillarBlock
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers
import net.neoforged.neoforge.registries.DeferredBlock
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.ModTags
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.block.RotatedPillarBlockDropsXP

object ModOregen {
    private val instanceMaps = mutableMapOf<String, MutableList<OregenTarget>>()
    fun getInstanceMaps() = instanceMaps.mapValues {(key, value) -> value.toList() }.toMap()
    private fun registerInsideBiomes(biomesGetter: (HolderGetter<Biome>) -> HolderSet<Biome>): (OregenTarget.BiomeModifierContext).(OregenTarget) -> Unit = {
        context.register(
            it.addKey,
            BiomeModifiers.AddFeaturesBiomeModifier(
                biomesGetter(biomes),
                HolderSet.direct(
                    placedFeatures.getOrThrow(it.placedKey)
                ),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )
    }
    private fun registerInsideBiomes(biomeTags: TagKey<Biome>): (OregenTarget.BiomeModifierContext).(OregenTarget) -> Unit = registerInsideBiomes { it.getOrThrow(biomeTags) }
    private val defaultBiomeModifierCallback: (OregenTarget.BiomeModifierContext).(OregenTarget) -> Unit = {

    }

    // it's required to add multiple keys if you want to add multiple types of ore distributions
    // (see vanilla OrePlacements.ORE_DIAMOND_MEDIUM, OrePlacements.ORE_DIAMOND_LARGE, etc)
    class OregenTarget(
        baseBlockName: String,
        val configuredFeaturesCallback: (ConfiguredFeaturesContext).(OregenTarget) -> Unit,
        val placedFeaturesCallback: (PlacedFeaturesContext).(OregenTarget) -> Unit,
        val biomeModifierCallback: (BiomeModifierContext).(OregenTarget) -> Unit,
        uniqueName: String? = null
    ) {
        val instance: Int
        init {
            if(instanceMaps[baseBlockName] == null) {
                instanceMaps[baseBlockName] = mutableListOf()
            }
            val list = instanceMaps[baseBlockName]!!
            instance = list.size + 1
            instanceMaps[baseBlockName]!!.add(this)
        }
        // Generates a key for ModConfiguredFeatures, ModPlacedFeatures, and ModBiomeModifiers
        val oreKey: ResourceKey<ConfiguredFeature<*, *>>
        val addKey: ResourceKey<BiomeModifier>
        val placedKey: ResourceKey<PlacedFeature>
        init {
            if(uniqueName != null) {
                oreKey = ModConfiguredFeatures.registerKey(uniqueName)
                addKey = ModBiomeModifiers.registerKey("add_$uniqueName")
                placedKey = ModPlacedFeatures.registerKey(uniqueName + "_placed")
            } else {
                oreKey = ModConfiguredFeatures.registerKey(baseBlockName + instance.toString())
                addKey = ModBiomeModifiers.registerKey("add_$baseBlockName$instance")
                placedKey = ModPlacedFeatures.registerKey(baseBlockName + "_placed" + instance.toString())
            }
        }
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
    }



    init {
        FantasyMetals.LOGGER.info("Oregen object was instantiated...")
        // mythril ore
        run {
            OregenTarget(
                "mythril_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.MYTHRIL_ORE,
                        ModBlocks.DEEPSLATE_MYTHRIL_ORE,
                        it.oreKey,
                        size = 3,
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-5),
                                VerticalAnchor.absolute(5)
                            ))
                        // ModOrePlacement.commonOrePlacement(7,
                        //                HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.aboveBottom(32))
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            OregenTarget(
                "mythril_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.MYTHRIL_ORE,
                        ModBlocks.DEEPSLATE_MYTHRIL_ORE,
                        it.oreKey,
                        size = 3,
                        discardChance = 0.5f
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.aboveBottom(32))
                        )
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // adamant ore
        run {
            OregenTarget(
                "adamant_ore",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.ADAMANT_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = {
                    register(it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(120,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)))
                    )
                },
                biomeModifierCallback = registerInsideBiomes (ModTags.Biomes.BIOMES_ADAMANT_GENERATES_NORMALLY_IN)
            )
            OregenTarget(
                "adamant_ore",
                uniqueName = "adamant_ore_highlands",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.ADAMANT_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = {
                    register(it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(240,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)))
                    )
                },
                biomeModifierCallback = registerInsideBiomes { HolderSet.direct(it.getOrThrow(Biomes.END_HIGHLANDS))}
            )
            OregenTarget(
                "adamant_ore",
                uniqueName = "adamant_ore_central_island",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.ADAMANT_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = {
                    register(it.placedKey, it.oreKey,
                        ModOrePlacement.rareOrePlacement(80,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)))
                    )
                },
                biomeModifierCallback = registerInsideBiomes { HolderSet.direct(it.getOrThrow(Biomes.THE_END))}
            )
        }
        // orichalcum ore
        run {
            OregenTarget(
                "orichalcum_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.ORICHALCUM_ORE,
                        ModBlocks.DEEPSLATE_ORICHALCUM_ORE,
                        it.oreKey,
                        size = 6,
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(0),
                                VerticalAnchor.absolute(60)
                            ))
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            OregenTarget(
                "orichalcum_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.ORICHALCUM_ORE,
                        ModBlocks.DEEPSLATE_ORICHALCUM_ORE,
                        it.oreKey,
                        size = 6,
                        discardChance = 0.8f
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(-32),
                                VerticalAnchor.absolute(32)
                            ))
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // carmot ore
        run {
            OregenTarget(
                "carmot_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.CARMOT_ORE,
                        ModBlocks.DEEPSLATE_CARMOT_ORE,
                        it.oreKey,
                        size = 6,
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(60),
                                VerticalAnchor.absolute(120)
                            ))
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            OregenTarget(
                "carmot_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.CARMOT_ORE,
                        ModBlocks.DEEPSLATE_CARMOT_ORE,
                        it.oreKey,
                        size = 6,
                        discardChance = 0.8f
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.uniform(
                                VerticalAnchor.absolute(20),
                                VerticalAnchor.absolute(70)
                            ))
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }

        // Alexandrite
        run {
            OregenTarget(
                "alexandrite_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.ALEXANDRITE_ORE,
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE,
                        it.oreKey,
                        size = 3,
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.triangle(
                                VerticalAnchor.absolute(-20),
                                VerticalAnchor.absolute(20)
                            ))
                        // ModOrePlacement.commonOrePlacement(7,
                        //                HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.aboveBottom(32))
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            OregenTarget(
                "alexandrite_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.ALEXANDRITE_ORE,
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE,
                        it.oreKey,
                        size = 3,
                        discardChance = 0.5f
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.aboveBottom(50))
                        )
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // Black opal
        run {
            OregenTarget(
                "black_opal",
                configuredFeaturesCallback = {
                    val blackOpalOres = mutableListOf(
                        OreConfiguration.target(netherrackReplaceables, ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState())
                    )
                    for(blockState in Blocks.BASALT.stateDefinition.possibleStates) {
                        val axis = blockState.getValue(RotatedPillarBlock.AXIS)
                        val baseState = ModBlocks.BASALT_BLACK_OPAL_ORE.get().defaultBlockState()
                        val nextState = baseState.setValue(RotatedPillarBlockDropsXP.AXIS, axis)
                        blackOpalOres.add(
                            OreConfiguration.target(BlockStateMatchTest(blockState), nextState)
                        )
                    }
                    context.register(
                        it.oreKey,
                        ConfiguredFeature(
                            Feature.ORE,
                            OreConfiguration(
                                blackOpalOres, 3
                            )
                        )
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            6 * 20,
                            HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(10))
                        )
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_NETHER)
            )
        }
        // Tanzanite
        run {
            OregenTarget(
                "tanzanite_ore",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.TANZANITE_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = {
                    register(it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(120,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80)))
                    )
                },
                biomeModifierCallback = registerInsideBiomes (ModTags.Biomes.BIOMES_TANZANITE_GENERATES_IN)
            )
        }
        // Sardonyx
        run {
            OregenTarget(
                "sardonyx_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.SARDONYX_ORE,
                        ModBlocks.DEEPSLATE_SARDONYX_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = {
                    register(it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(7,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-15), VerticalAnchor.absolute(45))))
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            OregenTarget(
                "sardonyx_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.SARDONYX_ORE,
                        ModBlocks.DEEPSLATE_SARDONYX_ORE,
                        it.oreKey,
                        size = 3,
                        discardChance = 0.5f
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(80))
                        )
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // Tsavorite
        run {
            OregenTarget(
                "tsavorite_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.TSAVORITE_ORE,
                        ModBlocks.DEEPSLATE_TSAVORITE_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = {
                    register(it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(7,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(0))))
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            OregenTarget(
                "sardonyx_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.TSAVORITE_ORE,
                        ModBlocks.DEEPSLATE_TSAVORITE_ORE,
                        it.oreKey,
                        size = 3,
                        discardChance = 0.5f
                    )
                },
                placedFeaturesCallback = {
                    register(
                        it.placedKey, it.oreKey,
                        ModOrePlacement.commonOrePlacement(
                            7,
                            HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(10))
                        )
                    )
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
    }
}
