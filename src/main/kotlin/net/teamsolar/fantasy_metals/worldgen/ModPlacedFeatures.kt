package net.teamsolar.fantasy_metals.worldgen

import net.minecraft.core.Holder
import net.minecraft.core.HolderGetter
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.teamsolar.fantasy_metals.FantasyMetals


object ModPlacedFeatures {
    /*val MYTHRIL_ORE_PLACED_KEY1 = registerKey("mythril_ore_placed1")
    val MYTHRIL_ORE_PLACED_KEY2 = registerKey("mythril_ore_placed2")
    val ADAMANT_ORE_PLACED_KEY = registerKey("adamant_ore_placed")
    val ORICHALCUM_ORE_PLACED_KEY = registerKey("orichalcum_ore_placed")
    val CARMOT_ORE_PLACED_KEY = registerKey("carmot_ore_placed")

    val SARDONYX_ORE_PLACED_KEY = registerKey("sardonyx_ore_placed")
    val ALEXANDRITE_ORE_PLACED_KEY = registerKey("alexandrite_ore_placed")
    val TANZANITE_ORE_PLACED_KEY = registerKey("tanzanite_ore_placed")
    val BLACK_OPAL_ORE_PLACED_KEY = registerKey("black_opal_ore_placed")
    val TSAVORITE_ORE_PLACED_KEY = registerKey("tsavorite_ore_placed")*/

    fun bootstrap(context: BootstrapContext<PlacedFeature>) {
        val helper = object : ModOregen.OregenTarget.PlacedFeaturesContext {
            override val configuredFeatures: HolderGetter<ConfiguredFeature<*, *>> = context.lookup(Registries.CONFIGURED_FEATURE)
            override fun register(placedKey: ResourceKey<PlacedFeature>, oreKey: ResourceKey<ConfiguredFeature<*, *>>, modifiers: List<PlacementModifier>) {
                register(context, placedKey, configuredFeatures.getOrThrow(oreKey), modifiers)
            }
            override val context: BootstrapContext<PlacedFeature> = context
        }
        for((oreName, targets) in ModOregen.getInstanceMaps()) {
            for(target in targets) {
                target.placedFeaturesCallback.invoke(helper, target)
            }
        }
        /*with(ModConfiguredFeatures) {
            register(MYTHRIL_ORE_PLACED_KEY1, MYTHRIL_ORE_KEY1, ModOrePlacement.commonOrePlacement(7,
                HeightRangePlacement.triangle(VerticalAnchor.absolute(-5), VerticalAnchor.absolute(5))))
            register(MYTHRIL_ORE_PLACED_KEY2, MYTHRIL_ORE_KEY2, ModOrePlacement.commonOrePlacement(7,
                HeightRangePlacement.uniform(VerticalAnchor.BOTTOM, VerticalAnchor.aboveBottom(32))))
        }*/
    }

    public fun registerKey(name: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, name)
        )
    }

    private fun register(
        context: BootstrapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        configuration: Holder<ConfiguredFeature<*, *>>,
        modifiers: List<PlacementModifier>
    ) {
        context.register(key, PlacedFeature(configuration, java.util.List.copyOf(modifiers)))
    }
}