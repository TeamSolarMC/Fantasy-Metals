package net.teamsolar.fantasy_metals;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.internal.NeoForgeBiomeTagsProvider;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_MYTHRIL_TOOL = tag("incorrect_for_mythril_tool");
        public static final TagKey<Block> INCORRECT_FOR_ADAMANT_TOOL = tag("incorrect_for_adamant_tool");
        public static final TagKey<Block> INCORRECT_FOR_ORICHALCUM_TOOL = tag("incorrect_for_orichalcum_tool");
        public static final TagKey<Block> INCORRECT_FOR_CARMOT_TOOL = tag("incorrect_for_carmot_tool");

        public static final TagKey<Block> ORES_IN_GROUND_ENDSTONE = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "ores_in_ground/end_stone"));
        public static final TagKey<Block> ORE_BEARING_ENDSTONE = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "ore_bearing_ground/end_stone"));

        private static TagKey<Block> tag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, name));
        }
        private static TagKey<Block> commonTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }

    public static class Biomes {
        public static final TagKey<Biome> BIOMES_ADAMANT_GENERATES_NORMALLY_IN = tag("end_normal_adamant_spawns");
        public static final TagKey<Biome> BIOMES_TANZANITE_GENERATES_IN = tag("end_tanzanite_spawns");
        private static TagKey<Biome> tag(String name) {
            return TagKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, name));
        }
    }

    public static class Items {
        private static TagKey<Item> tag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, name));
        }
        private static TagKey<Item> commonTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", name));
        }
    }
}
