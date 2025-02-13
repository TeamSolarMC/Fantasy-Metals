package net.teamsolar.fantasy_metals.worldgen

import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderSet
import net.minecraft.resources.ResourceKey
import net.minecraft.tags.BiomeTags
import net.minecraft.tags.TagKey
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.biome.Biomes
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
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockStateMatchTest
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers

import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.ModTags
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.block.RotatedPillarBlockDropsXP

import net.teamsolar.fantasy_metals.worldgen.ModOrePlacement.commonOrePlacement
import net.teamsolar.fantasy_metals.worldgen.ModOrePlacement.rareOrePlacement
import net.teamsolar.fantasy_metals.worldgen.ModOregen.Oregen.Companion.oregenTarget


object ModOregen {
    private val instanceMaps = mutableMapOf<String, MutableList<Oregen>>()
    fun getInstanceMaps() = instanceMaps.mapValues {(key, value) -> value.toList() }.toMap()
    private fun registerInsideBiomes(biomesGetter: (HolderGetter<Biome>) -> HolderSet<Biome>): (BiomeModifierContext).(Oregen) -> Unit = {
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
    private fun registerInsideBiomes(biomeTags: TagKey<Biome>): (BiomeModifierContext).(Oregen) -> Unit = registerInsideBiomes { it.getOrThrow(biomeTags) }
    private fun modifier(modifiers: List<PlacementModifier>): (PlacedFeaturesContext).(Oregen) -> Unit = {
        register(it.placedKey, it.oreKey, modifiers)
    }

    // it's required to add multiple keys if you want to add multiple types of ore distributions
    // (see vanilla OrePlacements.ORE_DIAMOND_MEDIUM, OrePlacements.ORE_DIAMOND_LARGE, etc)
    class Oregen private constructor(
        baseBlockName: String,
        val configuredFeaturesCallback: (ConfiguredFeaturesContext).(Oregen) -> Unit,
        val placedFeaturesCallback: (PlacedFeaturesContext).(Oregen) -> Unit,
        val biomeModifierCallback: (BiomeModifierContext).(Oregen) -> Unit,
        uniqueName: String? = null
    )
    {
        private val instance: Int
        init {
            /*if(instanceMaps[baseBlockName] == null) {
                instanceMaps[baseBlockName] = mutableListOf()
            }*/
            val list = instanceMaps[baseBlockName]
            instance = (list?.size ?: 0) + 1
            // instanceMaps[baseBlockName]!!.add(this)
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

        companion object {
            fun oregenTarget(
                baseBlockName: String,
                configuredFeaturesCallback: (ConfiguredFeaturesContext).(Oregen) -> Unit,
                placedFeaturesCallback: (PlacedFeaturesContext).(Oregen) -> Unit,
                biomeModifierCallback: (BiomeModifierContext).(Oregen) -> Unit,
                uniqueName: String? = null
            ): Oregen {
                return Oregen(baseBlockName, configuredFeaturesCallback, placedFeaturesCallback, biomeModifierCallback, uniqueName).also {
                    if(instanceMaps[baseBlockName] == null) {
                        instanceMaps[baseBlockName] = mutableListOf()
                    }
                    instanceMaps[baseBlockName]!!.add(it)
                }
            }
        }
    }

    init {
        FantasyMetals.LOGGER.info("Oregen object was instantiated...")
        // mythril ore
        run {
            oregenTarget(
                "mythril_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.MYTHRIL_ORE,
                        ModBlocks.DEEPSLATE_MYTHRIL_ORE,
                        it.oreKey,
                        size = 3,
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.triangle(
                        VerticalAnchor.absolute(-5),
                        VerticalAnchor.absolute(5)
                    )
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            oregenTarget(
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
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.aboveBottom(32))
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // adamant ore
        run {
            oregenTarget(
                "adamant_ore",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.ADAMANT_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                    120,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))
                )),
                biomeModifierCallback = registerInsideBiomes (ModTags.Biomes.BIOMES_ADAMANT_GENERATES_NORMALLY_IN)
            )
            oregenTarget(
                "adamant_ore",
                uniqueName = "adamant_ore_highlands",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.ADAMANT_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                    240,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(0), VerticalAnchor.absolute(80))
                )),
                biomeModifierCallback = registerInsideBiomes { HolderSet.direct(it.getOrThrow(Biomes.END_HIGHLANDS))}
            )
            oregenTarget(
                "adamant_ore",
                uniqueName = "adamant_ore_central_island",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.ADAMANT_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = modifier(rareOrePlacement(
                    80,
                    HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(0),
                        VerticalAnchor.absolute(80)
                    )
                )),
                biomeModifierCallback = registerInsideBiomes { HolderSet.direct(it.getOrThrow(Biomes.THE_END))}
            )
        }
        // orichalcum ore
        run {
            oregenTarget(
                "orichalcum_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.ORICHALCUM_ORE,
                        ModBlocks.DEEPSLATE_ORICHALCUM_ORE,
                        it.oreKey,
                        size = 6,
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.triangle(
                        VerticalAnchor.absolute(0),
                        VerticalAnchor.absolute(60)
                    )
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            oregenTarget(
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
                placedFeaturesCallback = modifier(commonOrePlacement(
                   7,
                    HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(-32),
                        VerticalAnchor.absolute(32)
                    )
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // carmot ore
        run {
            oregenTarget(
                "carmot_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.CARMOT_ORE,
                        ModBlocks.DEEPSLATE_CARMOT_ORE,
                        it.oreKey,
                        size = 6,
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.triangle(
                        VerticalAnchor.absolute(60),
                        VerticalAnchor.absolute(120)
                    )
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            oregenTarget(
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
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.uniform(
                        VerticalAnchor.absolute(20),
                        VerticalAnchor.absolute(70)
                    )
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }

        // Alexandrite
        run {
            oregenTarget(
                "alexandrite_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.ALEXANDRITE_ORE,
                        ModBlocks.DEEPSLATE_ALEXANDRITE_ORE,
                        it.oreKey,
                        size = 3,
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                        7,
                        HeightRangePlacement.triangle(
                            VerticalAnchor.absolute(-20),
                            VerticalAnchor.absolute(20)
                        )
                    )
                    // commonOrePlacement(7,
                    //                HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.aboveBottom(32))
                ),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            oregenTarget(
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
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.aboveBottom(50))
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // Black opal
        run {
            oregenTarget(
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
                placedFeaturesCallback = modifier(commonOrePlacement(
                    6 * 20,
                    HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(10), VerticalAnchor.belowTop(10))
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_NETHER)
            )
        }
        // Tanzanite
        run {
            oregenTarget(
                "tanzanite_ore",
                configuredFeaturesCallback = {
                    endOre(
                        ModBlocks.TANZANITE_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                    120,
                    HeightRangePlacement.triangle(
                        VerticalAnchor.bottom(),
                        VerticalAnchor.aboveBottom(40)
                    )
                )),
                biomeModifierCallback = registerInsideBiomes (BiomeTags.IS_END)
            )
        }
        // Sardonyx
        run {
            oregenTarget(
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
                        commonOrePlacement(7,
                            HeightRangePlacement.triangle(VerticalAnchor.absolute(-15), VerticalAnchor.absolute(45))))
                },
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            oregenTarget(
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
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(80))
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
        // Tsavorite
        run {
            oregenTarget(
                "tsavorite_ore",
                configuredFeaturesCallback = {
                    overworldOre(
                        ModBlocks.TSAVORITE_ORE,
                        ModBlocks.DEEPSLATE_TSAVORITE_ORE,
                        it.oreKey,
                        size = 3
                    )
                },
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.triangle(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(0))
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
            oregenTarget(
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
                placedFeaturesCallback = modifier(commonOrePlacement(
                    7,
                    HeightRangePlacement.uniform(VerticalAnchor.absolute(-40), VerticalAnchor.absolute(10))
                )),
                biomeModifierCallback = registerInsideBiomes(BiomeTags.IS_OVERWORLD)
            )
        }
    }

}
