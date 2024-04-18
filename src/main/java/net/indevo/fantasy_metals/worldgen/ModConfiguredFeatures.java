package net.indevo.fantasy_metals.worldgen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_MYTHRIL_ORE_KEY = registerKey("mythril_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_ADAMANT_ORE_KEY = registerKey("end_adamant_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ORICHALCUM_ORE_KEY = registerKey("orichalcum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_CARMOT_ORE_KEY = registerKey("carmot_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_SARDONYX_ORE_KEY = registerKey("bismuth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_ALEXANDRITE_ORE_KEY = registerKey("alexandrite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_TANZANITE_ORE_KEY = registerKey("end_tanzanite_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_BLACK_OPAL_ORE_KEY = registerKey("nether_black_opal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TSAVORITE_ORE_KEY = registerKey("tsavorite_ore");

    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldMythrilOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.MYTHRIL_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_MYTHRIL_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_MYTHRIL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldMythrilOres, 3));

        List<OreConfiguration.TargetBlockState> overworldCarmotOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.CARMOT_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSlATE_CARMOT_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_CARMOT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldCarmotOres, 3));

        List<OreConfiguration.TargetBlockState> overworldOrichalcumOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.ORICHALCUM_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ORICHALCUM_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_ORICHALCUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOrichalcumOres, 3));

        List<OreConfiguration.TargetBlockState> overworldBismuthOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.SARDONYX_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_SARDONYX_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_SARDONYX_ORE_KEY, Feature.ORE, new OreConfiguration(overworldBismuthOres, 3));

        List<OreConfiguration.TargetBlockState> overworldAlexandriteOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.ALEXANDRITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_ALEXANDRITE_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_ALEXANDRITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldAlexandriteOres, 3));

        List<OreConfiguration.TargetBlockState> overworldTsavoriteOres = List.of(OreConfiguration.target(stoneReplaceable,
                ModBlocks.TSAVORITE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_TSAVORITE_ORE.get().defaultBlockState()));
        register(context, OVERWORLD_TSAVORITE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTsavoriteOres, 3));

        register(context, END_ADAMANT_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.CARMOT_ORE.get().defaultBlockState(), 3));

        register(context, END_TANZANITE_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                ModBlocks.TANZANITE_ORE.get().defaultBlockState(), 3));

        register(context, NETHER_BLACK_OPAL_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.BLACK_OPAL_ORE.get().defaultBlockState(), 3));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, new ResourceLocation(FantasyMetals.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}