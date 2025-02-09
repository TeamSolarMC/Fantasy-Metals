package net.teamsolar.fantasy_metals.worldgen

import net.minecraft.core.HolderGetter
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers
import net.neoforged.neoforge.registries.NeoForgeRegistries
import net.teamsolar.fantasy_metals.FantasyMetals


object ModBiomeModifiers {
    // val ADD_MYTHRIL_ORE = registerKey("add_mythril_ore")
    fun bootstrap(context: BootstrapContext<BiomeModifier>) {
        val helper = object : ModOregen.OregenTarget.BiomeModifierContext {
            override val biomes: HolderGetter<Biome> = context.lookup(Registries.BIOME)
            override val placedFeatures: HolderGetter<PlacedFeature> = context.lookup(Registries.PLACED_FEATURE)
            override val context: BootstrapContext<BiomeModifier> = context
        }
        for((oreName, targets) in ModOregen.getInstanceMaps()) {
            for(target in targets) {
                target.biomeModifierCallback.invoke(helper, target)
            }
        }
        /*context.register(
            ADD_MYTHRIL_ORE,
            BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(
                    placedFeatures.getOrThrow(ModPlacedFeatures.MYTHRIL_ORE_PLACED_KEY1),
                    placedFeatures.getOrThrow(ModPlacedFeatures.MYTHRIL_ORE_PLACED_KEY2)
                ),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        )*/
    }

    public fun registerKey(name: String): ResourceKey<BiomeModifier> {
        return ResourceKey.create<BiomeModifier>(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS,
            ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, name)
        )
    }
}