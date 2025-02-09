package net.teamsolar.fantasy_metals.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.BiomeTagsProvider
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.biome.Biomes
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.ModTags
import java.util.concurrent.CompletableFuture

class ModBiomeTagsProvider(
    output: PackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>,
    existingFileHelper: ExistingFileHelper
) :
    BiomeTagsProvider(output, lookupProvider, FantasyMetals.MODID, existingFileHelper) {
    override fun addTags(provider: HolderLookup.Provider) {
        tag(ModTags.Biomes.BIOMES_ADAMANT_GENERATES_NORMALLY_IN)
            .addTag(BiomeTags.IS_END)
            .remove(Biomes.END_HIGHLANDS)
            .remove(Biomes.THE_END)
        tag(ModTags.Biomes.BIOMES_TANZANITE_GENERATES_IN)
            .add(
                Biomes.THE_END,
                Biomes.SMALL_END_ISLANDS
            )
    }
}