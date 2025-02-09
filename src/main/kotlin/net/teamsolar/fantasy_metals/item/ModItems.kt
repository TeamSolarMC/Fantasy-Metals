package net.teamsolar.fantasy_metals.item

import net.minecraft.world.item.Item
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.SwordItem
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import net.teamsolar.fantasy_metals.FantasyMetals
import java.util.function.Supplier

object ModItems {
    val ITEMS_REGISTER: DeferredRegister.Items = DeferredRegister.createItems(FantasyMetals.MODID)
    private fun MetalEquipmentSet.thenRegister() = apply {
        ITEMS_REGISTER.registerAll()
    }
    val MYTHRIL_SET = object : MetalEquipmentSet(
        prefix = "mythril",
        armorMaterial = ModArmorMaterials.MYTHRIL,
        tier = ModToolTiers.MYTHRIL,
        durabilityFactor = 33
    ) {
        init {

        }
    }.thenRegister()
    val ADAMANT_SET = object : MetalEquipmentSet(
        prefix = "adamant",
        armorMaterial = ModArmorMaterials.ADAMANT,
        tier = ModToolTiers.ADAMANT,
        durabilityFactor = 66
    ) {
        init {
            // Entity base attack damage: 1
            // Mod tool tier attack damage bonus: 4
            // Entity base attack speed: 4
            SWORD.properties = SWORD.properties.attributes(SwordItem.createAttributes(
                ModToolTiers.ADAMANT,
                5.0f,
                -2.8f
            ))
            PICKAXE.properties = PICKAXE.properties.attributes(PickaxeItem.createAttributes(
                ModToolTiers.ADAMANT,
                1.2f,
                -3.1f
            ))
            for(entry in toolEntries.toSet() + combatItemEntries.toSet() + ingredientEntries.toSet()) {
                entry.properties = entry.properties.fireResistant()
            }
        }
    }.thenRegister()
    val ORICHALCUM_SET = MetalEquipmentSet(
        prefix = "orichalcum",
        armorMaterial = ModArmorMaterials.ORICHALCUM,
        tier = ModToolTiers.ORICHALCUM,
        durabilityFactor = 11
    ).thenRegister()
    val CARMOT_SET = MetalEquipmentSet(
        prefix = "carmot",
        armorMaterial = ModArmorMaterials.CARMOT,
        tier = ModToolTiers.CARMOT,
        durabilityFactor = 11
    ).thenRegister()

    val SARDONYX_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("sardonyx"))
    val ALEXANDRITE_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("alexandrite"))
    val TANZANITE_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("tanzanite"))
    val BLACK_OPAL_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("black_opal"))
    val TSAVORITE_SET = GemItemSet(ITEMS_REGISTER.registerSimpleItem("tsavorite"))

    val TEST_ITEM = ITEMS_REGISTER.register("test_item", Supplier{BlockCharacteristicCheckerItem()})
    val ORE_SCANNER_ITEM = ITEMS_REGISTER.register("ore_scanner_item", Supplier{ChunkOreDetectorItem()})

    val GEMS = listOf(
        SARDONYX_SET,
        ALEXANDRITE_SET,
        TANZANITE_SET,
        BLACK_OPAL_SET,
        TSAVORITE_SET
    )

    fun register(eventBus: IEventBus) {
        ITEMS_REGISTER.register(eventBus)
    }
}