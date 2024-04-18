package net.indevo.fantasy_metals.item;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.util.ModTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class ModToolTiers {
    public static final Tier MYTHRIL = TierSortingRegistry.registerTier(
            new ForgeTier(3, 937, 8.0F, 3.0F, 22,
                    ModTags.Blocks.NEEDS_MYTHRIL_TOOL, () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get())),
            new ResourceLocation(FantasyMetals.MOD_ID, "mythril"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier ADAMANT = TierSortingRegistry.registerTier(
            new ForgeTier(3, 3626, 6.0F, 4.0F, 10,
                    ModTags.Blocks.NEEDS_ADAMANT_TOOL, () -> Ingredient.of(ModItems.ADAMANT_INGOT.get())),
            new ResourceLocation(FantasyMetals.MOD_ID, "adamant"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier ORICHALCUM = TierSortingRegistry.registerTier(
            new ForgeTier(2, 439, 8.0F, 4.0F, 12,
                    ModTags.Blocks.NEEDS_ORICHALCUM_TOOL, () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get())),
            new ResourceLocation(FantasyMetals.MOD_ID, "orichalcum"), List.of(Tiers.NETHERITE), List.of());

    public static final Tier CARMOT = TierSortingRegistry.registerTier(
            new ForgeTier(2, 666, 9.0F, 2.0F, 15,
                    ModTags.Blocks.NEEDS_CARMOT_TOOL, () -> Ingredient.of(ModItems.CARMOT_INGOT.get())),
            new ResourceLocation(FantasyMetals.MOD_ID, "carmot"), List.of(Tiers.NETHERITE), List.of());

}
