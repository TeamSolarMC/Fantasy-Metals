package net.indevo.fantasy_metals.worldgen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> MYTHRIL_ORE_PLACED_KEY = registerKey("mythril_ore_placed");
    public static final ResourceKey<PlacedFeature> ADAMANT_ORE_PLACED_KEY = registerKey("adamant_ore_placed");
    public static final ResourceKey<PlacedFeature> ORICHALCUM_ORE_PLACED_KEY = registerKey("orichalcum_ore_placed");
    public static final ResourceKey<PlacedFeature> CARMOT_ORE_PLACED_KEY = registerKey("carmot_ore_placed");
    public static final ResourceKey<PlacedFeature> SARDONYX_ORE_PLACED_KEY = registerKey("bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> ALEXANDRITE_ORE_PLACED_KEY = registerKey("alexandrite_ore_placed");
    public static final ResourceKey<PlacedFeature> TANZANITE_ORE_PLACED_KEY = registerKey("tanzanite_ore_placed");
    public static final ResourceKey<PlacedFeature> BLACK_OPAL_ORE_PLACED_KEY = registerKey("black_opal_ore_placed");
    public static final ResourceKey<PlacedFeature> TSAVORITE_ORE_PLACED_KEY = registerKey("tsavorite_ore_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, MYTHRIL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_MYTHRIL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-32))));

        register(context, ADAMANT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_ADAMANT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(2,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));

        register(context, ORICHALCUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ORICHALCUM_ORE_KEY),
                ModOrePlacement.commonOrePlacement(8,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-32), VerticalAnchor.absolute(32))));

        register(context, CARMOT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_CARMOT_ORE_KEY),
                ModOrePlacement.commonOrePlacement(6,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(70))));

        register(context, SARDONYX_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_SARDONYX_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(80))));

        register(context, ALEXANDRITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_ALEXANDRITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-20), VerticalAnchor.absolute(50))));

        register(context, TSAVORITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_TSAVORITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(32))));

        register(context, TANZANITE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.END_TANZANITE_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));

        register(context, BLACK_OPAL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_BLACK_OPAL_ORE_KEY),
                ModOrePlacement.commonOrePlacement(3,
                        HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(80))));
    }


    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(FantasyMetals.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}