package net.teamsolar.fantasy_metals.worldgen

import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.registries.DeferredBlock
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.ModTags


object ModConfiguredFeatures {
    /*val MYTHRIL_ORE_KEY1 = registerKey("mythril_ore1")
    val MYTHRIL_ORE_KEY2 = registerKey("mythril_ore2")
    val ADAMANT_ORE_KEY1 = registerKey("adamant_ore1")
    val ADAMANT_ORE_KEY2 = registerKey("adamant_ore2")
    val ORICHALCUM_ORE_KEY = registerKey("orichalcum_ore")
    val CARMOT_ORE_KEY = registerKey("carmot_ore")

    val SARDONYX_ORE_KEY = registerKey("sardonyx_ore")
    val ALEXANDRITE_ORE_KEY = registerKey("alexandrite_ore")
    val TANZANITE_ORE_KEY = registerKey("tanzanite_ore")
    val BLACK_OPAL_ORE_KEY = registerKey("black_opal_ore")
    val TSAVORITE_ORE_KEY = registerKey("tsavorite_ore")*/

    fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {


        val helper = object : ConfiguredFeaturesContext {
            override val context: BootstrapContext<ConfiguredFeature<*, *>> = context

            override val stoneReplaceables: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
            override val deepslateReplaceables: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
            override val netherrackReplaceables: RuleTest = TagMatchTest(Tags.Blocks.ORE_BEARING_GROUND_NETHERRACK)
            override val endReplaceables: RuleTest = TagMatchTest(ModTags.Blocks.ORE_BEARING_ENDSTONE)
            override fun overworldOre(oreBlock: DeferredBlock<out Block>, deepslateOreBlock: DeferredBlock<out Block>, key: ResourceKey<ConfiguredFeature<*, *>>, size: Int, discardChance: Float?) {
                val overworldOres = listOf(
                    OreConfiguration.target(stoneReplaceables, oreBlock.get().defaultBlockState()),
                    OreConfiguration.target(deepslateReplaceables, deepslateOreBlock.get().defaultBlockState())
                )
                if(discardChance != null) {
                    register(
                        context,
                        key,
                        Feature.ORE,
                        OreConfiguration(overworldOres, size, discardChance)
                    )
                } else {
                    register(
                        context,
                        key,
                        Feature.ORE,
                        OreConfiguration(overworldOres, size)
                    )
                }
            }
            override fun netherOre(oreBlock: DeferredBlock<out Block>, key: ResourceKey<ConfiguredFeature<*, *>>, size: Int, discardChance: Float?) {
                if(discardChance != null) {
                    register(
                        context,
                        key,
                        Feature.ORE,
                        OreConfiguration(netherrackReplaceables, oreBlock.get().defaultBlockState(), size, discardChance)
                    )
                } else {
                    register(
                        context,
                        key,
                        Feature.ORE,
                        OreConfiguration(netherrackReplaceables, oreBlock.get().defaultBlockState(), size)
                    )
                }
            }
            override fun endOre(oreBlock: DeferredBlock<out Block>, key: ResourceKey<ConfiguredFeature<*, *>>, size: Int, discardChance: Float?) {
                if(discardChance != null) {
                    register(
                        context,
                        key,
                        Feature.ORE,
                        OreConfiguration(endReplaceables, oreBlock.get().defaultBlockState(), size, discardChance)
                    )
                } else {
                    register(
                        context,
                        key,
                        Feature.ORE,
                        OreConfiguration(endReplaceables, oreBlock.get().defaultBlockState(), size)
                    )
                }
            }
        }



        for((oreName, targets) in ModOregen.getInstanceMaps()) {
            for(target in targets) {
                target.configuredFeaturesCallback.invoke(helper, target)
            }
        }

        /*overworldOre(
            ModBlocks.MYTHRIL_ORE,
            ModBlocks.DEEPSLATE_MYTHRIL_ORE,
            MYTHRIL_ORE_KEY1,
            size = 3,
            discardChance = 0.5f
        )
        overworldOre(
            ModBlocks.MYTHRIL_ORE,
            ModBlocks.DEEPSLATE_MYTHRIL_ORE,
            MYTHRIL_ORE_KEY2,
            size = 3,
            discardChance = 0.5f
        )
        endOre(
            ModBlocks.ADAMANT_ORE,
            ADAMANT_ORE_KEY1,
            size = 3
        )
        endOre(
            ModBlocks.ADAMANT_ORE,
            ADAMANT_ORE_KEY2,
            size = 3
        )
        overworldOre(
            ModBlocks.CARMOT_ORE,
            ModBlocks.DEEPSLATE_CARMOT_ORE,
            CARMOT_ORE_KEY,
            size = 6
        )
        overworldOre(
            ModBlocks.ORICHALCUM_ORE,
            ModBlocks.DEEPSLATE_ORICHALCUM_ORE,
            ORICHALCUM_ORE_KEY,
            size = 6
        )

        overworldOre(
            ModBlocks.SARDONYX_ORE,
            ModBlocks.DEEPSLATE_SARDONYX_ORE,
            SARDONYX_ORE_KEY,
            size = 4
        )
        overworldOre(
            ModBlocks.ALEXANDRITE_ORE,
            ModBlocks.DEEPSLATE_ALEXANDRITE_ORE,
            ALEXANDRITE_ORE_KEY,
            size = 4
        )
        endOre(
            ModBlocks.TANZANITE_ORE,
            TANZANITE_ORE_KEY,
            4
        )
        netherOre(
            ModBlocks.BLACK_OPAL_ORE,
            BLACK_OPAL_ORE_KEY,
            4
        )
        overworldOre(
            ModBlocks.TSAVORITE_ORE,
            ModBlocks.DEEPSLATE_TSAVORITE_ORE,
            TSAVORITE_ORE_KEY,
            size = 4
        )*/

    }

    fun registerKey(name: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create<ConfiguredFeature<*, *>>(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, name)
        )
    }

    private fun <FC : FeatureConfiguration, F : Feature<FC>> register(
        context: BootstrapContext<ConfiguredFeature<*, *>>,
        key: ResourceKey<ConfiguredFeature<*, *>>, feature: F, configuration: FC
    ) {
        context.register(key, ConfiguredFeature(feature, configuration))
    }
}