package net.indevo.fantasy_metals.item;

import net.indevo.fantasy_metals.FantasyMetals;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.EnumMap;
import java.util.function.Supplier;

public enum ModArmorMaterials implements ArmorMaterial {
    MYTHRIL("mythril", 23, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266655_) -> {
        p_266655_.put(ArmorItem.Type.BOOTS, 3);
        p_266655_.put(ArmorItem.Type.LEGGINGS, 5);
        p_266655_.put(ArmorItem.Type.CHESTPLATE, 7);
        p_266655_.put(ArmorItem.Type.HELMET, 3);
    }), 22, SoundEvents.ARMOR_EQUIP_NETHERITE, 1.0F, 0.0F, () -> Ingredient.of(ModItems.MYTHRIL_INGOT.get())),
    ADAMANT("adamant", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266651_) -> {
        p_266651_.put(ArmorItem.Type.BOOTS, 4);
        p_266651_.put(ArmorItem.Type.LEGGINGS, 5);
        p_266651_.put(ArmorItem.Type.CHESTPLATE, 7);
        p_266651_.put(ArmorItem.Type.HELMET, 4);
    }), 10, SoundEvents.ARMOR_EQUIP_NETHERITE, 4.0F, 0.0F, () -> Ingredient.of(ModItems.ADAMANT_INGOT.get())),
    CARMOT("carmot", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266651_) -> {
        p_266651_.put(ArmorItem.Type.BOOTS, 3);
        p_266651_.put(ArmorItem.Type.LEGGINGS, 4);
        p_266651_.put(ArmorItem.Type.CHESTPLATE, 5);
        p_266651_.put(ArmorItem.Type.HELMET, 3);
    }), 12, SoundEvents.ARMOR_EQUIP_NETHERITE, 0.0F, 0.0F, () -> Ingredient.of(ModItems.CARMOT_INGOT.get())),
    ORICHALCUM("orichalcum", 15, Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266654_) -> {
        p_266654_.put(ArmorItem.Type.BOOTS, 3);
        p_266654_.put(ArmorItem.Type.LEGGINGS, 4);
        p_266654_.put(ArmorItem.Type.CHESTPLATE, 6);
        p_266654_.put(ArmorItem.Type.HELMET, 3);
    }), 12, SoundEvents.ARMOR_EQUIP_NETHERITE, 0.0F, 0.0F, () -> Ingredient.of(ModItems.ORICHALCUM_INGOT.get()));

    public static final StringRepresentable.EnumCodec<ArmorMaterials> CODEC = StringRepresentable.fromEnum(ArmorMaterials::values);
    private static final EnumMap<ArmorItem.Type, Integer> HEALTH_FUNCTION_FOR_TYPE = Util.make(new EnumMap<>(ArmorItem.Type.class), (p_266653_) -> {
        p_266653_.put(ArmorItem.Type.BOOTS, 13);
        p_266653_.put(ArmorItem.Type.LEGGINGS, 15);
        p_266653_.put(ArmorItem.Type.CHESTPLATE, 16);
        p_266653_.put(ArmorItem.Type.HELMET, 11);
    });

    private final String name;
    private final int durabilityMultiplier;
    private final EnumMap<ArmorItem.Type, Integer> protectionFunctionForType;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final Supplier<Ingredient> repairIngredient;

    ModArmorMaterials(String name, int durabilityMultiplier, EnumMap<ArmorItem.Type, Integer> protectionTypeMap,
                      int enchantmentValue, SoundEvent soundEvent, float toughness, float knockbackRes, Supplier<Ingredient> repairMaterial) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionFunctionForType = protectionTypeMap;
        this.enchantmentValue = enchantmentValue;
        this.sound = soundEvent;
        this.toughness = toughness;
        this.knockbackResistance = knockbackRes;
        this.repairIngredient = repairMaterial;
    }

    public int getDurabilityForType(ArmorItem.Type pType) {
        return HEALTH_FUNCTION_FOR_TYPE.get(pType) * this.durabilityMultiplier;
    }

    public int getDefenseForType(ArmorItem.Type pType) {
        return this.protectionFunctionForType.get(pType);
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {
        return this.sound;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    public String getName() {
        return FantasyMetals.MOD_ID + ":" + this.name;
    }

    public float getToughness() {
        return this.toughness;
    }

    /**
     * Gets the percentage of knockback resistance provided by armor of the material.
     */
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }

    public String getSerializedName() {
        return FantasyMetals.MOD_ID + ":" + this.name;
    }
}
