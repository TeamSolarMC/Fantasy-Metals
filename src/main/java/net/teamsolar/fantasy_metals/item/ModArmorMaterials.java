package net.teamsolar.fantasy_metals.item;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.teamsolar.fantasy_metals.FantasyMetals;

import java.util.EnumMap;
import java.util.List;

public class ModArmorMaterials {
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(Registries.ARMOR_MATERIAL, FantasyMetals.MODID);
    public static final Holder<ArmorMaterial> MYTHRIL =
            ARMOR_MATERIALS.register("mythril", () -> new ArmorMaterial(
                            // Determines the defense value of this armor material, depending on what armor piece it is.
                            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                                map.put(ArmorItem.Type.BOOTS, 1);
                                map.put(ArmorItem.Type.LEGGINGS, 4);
                                map.put(ArmorItem.Type.CHESTPLATE, 5);
                                map.put(ArmorItem.Type.HELMET, 1);
                                map.put(ArmorItem.Type.BODY, 4);
                            }),
                            // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                            22,
                            // Determines the sound played when equipping this armor.
                            // This is wrapped with a Holder.
                            SoundEvents.ARMOR_EQUIP_IRON,
                            // Determines the repair item for this armor.
                            () -> Ingredient.of(ModItems.INSTANCE.getMYTHRIL_SET().getINGOT().item()),
                            // Determines the texture locations of the armor to apply when rendering
                            // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                            List.of(
                                    // Creates a new armor texture that will be located at:
                                    // - 'assets/mod_id/textures/models/armor/mythril_layer_1.png' for the outer texture
                                    // - 'assets/mod_id/textures/models/armor/mythril_layer_2.png' for the inner texture (only legs)
                                    new ArmorMaterial.Layer(
                                            ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, "mythril")
                                    )
                            ),
                            // Toughness value
                            1,
                            // Knockback resistance
                            0
                    )
            );
    public static final Holder<ArmorMaterial> ADAMANT =
            ARMOR_MATERIALS.register("adamant", () -> new ArmorMaterial(
                            // Determines the defense value of this armor material, depending on what armor piece it is.
                            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                                map.put(ArmorItem.Type.BOOTS, 4);
                                map.put(ArmorItem.Type.LEGGINGS, 6);
                                map.put(ArmorItem.Type.CHESTPLATE, 8);
                                map.put(ArmorItem.Type.HELMET, 4);
                                map.put(ArmorItem.Type.BODY, 8);
                            }),
                            // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                            10,
                            // Determines the sound played when equipping this armor.
                            // This is wrapped with a Holder.
                            SoundEvents.ARMOR_EQUIP_IRON,
                            // Determines the repair item for this armor.
                            () -> Ingredient.of(ModItems.INSTANCE.getADAMANT_SET().getINGOT().item()),
                            // Determines the texture locations of the armor to apply when rendering
                            // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                            List.of(
                                    // Creates a new armor texture that will be located at:
                                    // - 'assets/mod_id/textures/models/armor/adamant_layer_1.png' for the outer texture
                                    // - 'assets/mod_id/textures/models/armor/adamant_layer_2.png' for the inner texture (only legs)
                                    new ArmorMaterial.Layer(
                                            ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, "adamant")
                                    )
                            ),
                            // Toughness value
                            4,
                            // Knockback resistance
                            0
                    )
            );
    public static final Holder<ArmorMaterial> ORICHALCUM =
            ARMOR_MATERIALS.register("orichalcum", () -> new ArmorMaterial(
                            // Determines the defense value of this armor material, depending on what armor piece it is.
                            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                                map.put(ArmorItem.Type.BOOTS, 3);
                                map.put(ArmorItem.Type.LEGGINGS, 5);
                                map.put(ArmorItem.Type.CHESTPLATE, 6);
                                map.put(ArmorItem.Type.HELMET, 3);
                                map.put(ArmorItem.Type.BODY, 6);
                            }),
                            // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                            12,
                            // Determines the sound played when equipping this armor.
                            // This is wrapped with a Holder.
                            SoundEvents.ARMOR_EQUIP_IRON,
                            // Determines the repair item for this armor.
                            () -> Ingredient.of(ModItems.INSTANCE.getORICHALCUM_SET().getINGOT().item()),
                            // Determines the texture locations of the armor to apply when rendering
                            // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                            List.of(
                                    // Creates a new armor texture that will be located at:
                                    // - 'assets/mod_id/textures/models/armor/orichalcum_layer_1.png' for the outer texture
                                    // - 'assets/mod_id/textures/models/armor/orichalcum_layer_2.png' for the inner texture (only legs)
                                    new ArmorMaterial.Layer(
                                            ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, "orichalcum")
                                    )
                            ),
                            // Toughness value
                            0,
                            // Knockback resistance
                            0
                    )
            );
    public static final Holder<ArmorMaterial> CARMOT =
            ARMOR_MATERIALS.register("carmot", () -> new ArmorMaterial(
                            // Determines the defense value of this armor material, depending on what armor piece it is.
                            Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                                map.put(ArmorItem.Type.BOOTS, 2);
                                map.put(ArmorItem.Type.LEGGINGS, 5);
                                map.put(ArmorItem.Type.CHESTPLATE, 6);
                                map.put(ArmorItem.Type.HELMET, 2);
                                map.put(ArmorItem.Type.BODY, 6);
                            }),
                            // Determines the enchantability of the tier. This represents how good the enchantments on this armor will be.
                            15,
                            // Determines the sound played when equipping this armor.
                            // This is wrapped with a Holder.
                            SoundEvents.ARMOR_EQUIP_IRON,
                            // Determines the repair item for this armor.
                            () -> Ingredient.of(ModItems.INSTANCE.getCARMOT_SET().getINGOT().item()),
                            // Determines the texture locations of the armor to apply when rendering
                            // This can also be specified by overriding 'IItemExtension#getArmorTexture' on your item if the armor texture needs to be more dynamic
                            List.of(
                                    // Creates a new armor texture that will be located at:
                                    // - 'assets/mod_id/textures/models/armor/carmot_layer_1.png' for the outer texture
                                    // - 'assets/mod_id/textures/models/armor/carmot_layer_2.png' for the inner texture (only legs)
                                    new ArmorMaterial.Layer(
                                            ResourceLocation.fromNamespaceAndPath(FantasyMetals.MODID, "carmot")
                                    )
                            ),
                            // Toughness value
                            0,
                            // Knockback resistance
                            0
                    )
            );

    public static void register(IEventBus eventBus) {
        ARMOR_MATERIALS.register(eventBus);
    }
}
