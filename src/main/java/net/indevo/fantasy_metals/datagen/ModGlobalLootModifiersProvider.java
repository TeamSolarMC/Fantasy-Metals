package net.indevo.fantasy_metals.datagen;

import net.indevo.fantasy_metals.FantasyMetals;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.GlobalLootModifierProvider;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {

    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, FantasyMetals.MOD_ID);
    }

    @Override
    protected void start() {

    }
}
