package net.indevo.fantasy_metals.item;

import net.indevo.fantasy_metals.FantasyMetals;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, FantasyMetals.MOD_ID);

    public static final RegistryObject<Item> RAW_MYTHRIL = ITEMS.register("raw_mythril",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_INGOT = ITEMS.register("mythril_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_NUGGET = ITEMS.register("mythril_nugget",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> RAW_ADAMANT = ITEMS.register("raw_adamant",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANT_INGOT = ITEMS.register("adamant_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ADAMANT_NUGGET = ITEMS.register("adamant_nugget",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> RAW_ORICHALCUM = ITEMS.register("raw_orichalcum",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_INGOT = ITEMS.register("orichalcum_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_NUGGET = ITEMS.register("orichalcum_nugget",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> RAW_CARMOT = ITEMS.register("raw_carmot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARMOT_INGOT = ITEMS.register("carmot_ingot",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARMOT_NUGGET = ITEMS.register("carmot_nugget",
            () -> new Item(new Item.Properties()));


    public static final RegistryObject<Item> SARDONYX = ITEMS.register("sardonyx",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ALEXANDRITE = ITEMS.register("alexandrite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TANZANITE = ITEMS.register("tanzanite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BLACK_OPAL = ITEMS.register("black_opal",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> TSAVORITE = ITEMS.register("tsavorite",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> MYTHRIL_SWORD = ITEMS.register("mythril_sword",
            () -> new SwordItem(ModToolTiers.MYTHRIL, 3, -2.1F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> MYTHRIL_PICKAXE = ITEMS.register("mythril_pickaxe",
            () -> new PickaxeItem(ModToolTiers.MYTHRIL, 1, -2.5F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> MYTHRIL_SHOVEL = ITEMS.register("mythril_shovel",
            () -> new ShovelItem(ModToolTiers.MYTHRIL, 1.5F, -2.7F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> MYTHRIL_AXE = ITEMS.register("mythril_axe",
            () -> new AxeItem(ModToolTiers.MYTHRIL, 5.0F, -2.7F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> MYTHRIL_HOE = ITEMS.register("mythril_hoe",
            () -> new HoeItem(ModToolTiers.MYTHRIL, -3, 0.0F, new Item.Properties().durability(256)));

    public static final RegistryObject<Item> MYTHRIL_HELMET = ITEMS.register("mythril_helmet",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_CHESTPLATE = ITEMS.register("mythril_chestplate",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_LEGGINGS = ITEMS.register("mythril_leggings",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> MYTHRIL_BOOTS = ITEMS.register("mythril_boots",
            () -> new ArmorItem(ModArmorMaterials.MYTHRIL, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ADAMANT_SWORD = ITEMS.register("adamant_sword",
            () -> new SwordItem(ModToolTiers.ADAMANT, 3, -2.7F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ADAMANT_PICKAXE = ITEMS.register("adamant_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ADAMANT, 1, -3.1F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ADAMANT_SHOVEL = ITEMS.register("adamant_shovel",
            () -> new ShovelItem(ModToolTiers.ADAMANT, 1.5F, -3.3F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ADAMANT_AXE = ITEMS.register("adamant_axe",
            () -> new AxeItem(ModToolTiers.ADAMANT, 5.0F, -3.3F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ADAMANT_HOE = ITEMS.register("adamant_hoe",
            () -> new HoeItem(ModToolTiers.ADAMANT, -4, 0.0F, new Item.Properties().durability(256)));

    public static final RegistryObject<Item> ADAMANT_HELMET = ITEMS.register("adamant_helmet",
            () -> new ArmorItem(ModArmorMaterials.ADAMANT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANT_CHESTPLATE = ITEMS.register("adamant_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ADAMANT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANT_LEGGINGS = ITEMS.register("adamant_leggings",
            () -> new ArmorItem(ModArmorMaterials.ADAMANT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ADAMANT_BOOTS = ITEMS.register("adamant_boots",
            () -> new ArmorItem(ModArmorMaterials.ADAMANT, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> ORICHALCUM_SWORD = ITEMS.register("orichalcum_sword",
            () -> new SwordItem(ModToolTiers.ORICHALCUM, 3, -2.4F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ORICHALCUM_PICKAXE = ITEMS.register("orichalcum_pickaxe",
            () -> new PickaxeItem(ModToolTiers.ORICHALCUM, 1, -2.8F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ORICHALCUM_SHOVEL = ITEMS.register("orichalcum_shovel",
            () -> new ShovelItem(ModToolTiers.ORICHALCUM, 1.5F, -3.0F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ORICHALCUM_AXE = ITEMS.register("orichalcum_axe",
            () -> new AxeItem(ModToolTiers.ORICHALCUM, 5.0F, -3.0F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> ORICHALCUM_HOE = ITEMS.register("orichalcum_hoe",
            () -> new HoeItem(ModToolTiers.ORICHALCUM, -4, -0.0F, new Item.Properties().durability(256)));

    public static final RegistryObject<Item> ORICHALCUM_HELMET = ITEMS.register("orichalcum_helmet",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_CHESTPLATE = ITEMS.register("orichalcum_chestplate",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_LEGGINGS = ITEMS.register("orichalcum_leggings",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> ORICHALCUM_BOOTS = ITEMS.register("orichalcum_boots",
            () -> new ArmorItem(ModArmorMaterials.ORICHALCUM, ArmorItem.Type.BOOTS, new Item.Properties()));

    public static final RegistryObject<Item> CARMOT_SWORD = ITEMS.register("carmot_sword",
            () -> new SwordItem(ModToolTiers.CARMOT, 3, -2.4F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CARMOT_PICKAXE = ITEMS.register("carmot_pickaxe",
            () -> new PickaxeItem(ModToolTiers.CARMOT, 1, -2.8F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CARMOT_SHOVEL = ITEMS.register("carmot_shovel",
            () -> new ShovelItem(ModToolTiers.CARMOT, 1.5F, -3.0F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CARMOT_AXE = ITEMS.register("carmot_axe",
            () -> new AxeItem(ModToolTiers.CARMOT, 6.0F, -3.1F, new Item.Properties().durability(256)));
    public static final RegistryObject<Item> CARMOT_HOE = ITEMS.register("carmot_hoe",
            () -> new HoeItem(ModToolTiers.CARMOT, -2, -1.0F, new Item.Properties().durability(256)));

    public static final RegistryObject<Item> CARMOT_HELMET = ITEMS.register("carmot_helmet",
            () -> new ArmorItem(ModArmorMaterials.CARMOT, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> CARMOT_CHESTPLATE = ITEMS.register("carmot_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CARMOT, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> CARMOT_LEGGINGS = ITEMS.register("carmot_leggings",
            () -> new ArmorItem(ModArmorMaterials.CARMOT, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> CARMOT_BOOTS = ITEMS.register("carmot_boots",
            () -> new ArmorItem(ModArmorMaterials.CARMOT, ArmorItem.Type.BOOTS, new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
