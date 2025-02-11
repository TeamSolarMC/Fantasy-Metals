package net.teamsolar.fantasy_metals.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.teamsolar.fantasy_metals.ModTags;

public class ModToolTiers {
    public static final Tier MYTHRIL = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_MYTHRIL_TOOL,
            // Durability
            959,
            // Mining speed
            8.0F,
            // Attack damage bonus
            3.0F,
            // Enchantability (see also ModArmorMaterials)
            22,
            () -> Ingredient.of(ModItems.INSTANCE.getMYTHRIL_SET().getINGOT().item())
    );
    public static final Tier ADAMANT = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_ADAMANT_TOOL,
            3626,
            6.0F,
            4.0F,
            10,
            () -> Ingredient.of(ModItems.INSTANCE.getADAMANT_SET().getINGOT().item())
    );
    public static final Tier ORICHALCUM = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_ORICHALCUM_TOOL,
            439,
            8.0F,
            4.0F,
            12,
            () -> Ingredient.of(ModItems.INSTANCE.getORICHALCUM_SET().getINGOT().item())
    );
    public static final Tier CARMOT = new SimpleTier(
            ModTags.Blocks.INCORRECT_FOR_CARMOT_TOOL,
            666,
            9.0F,
            2.0F,
            15,
            () -> Ingredient.of(ModItems.INSTANCE.getCARMOT_SET().getINGOT().item())
    );
}
