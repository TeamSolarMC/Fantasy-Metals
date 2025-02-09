package net.teamsolar.fantasy_metals.block

import net.minecraft.util.valueproviders.ConstantInt
import net.minecraft.util.valueproviders.IntProvider
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.item.ModItems
import java.util.function.Supplier

object ModBlocks {
    val BLOCKS_REGISTER = DeferredRegister.createBlocks(FantasyMetals.MODID)

    val MYTHRIL_BLOCK = registerBlockAndItem("mythril_block", metalBlock(8.0f, 9.6f))
    val MYTHRIL_ORE = registerBlockAndItem("mythril_ore", oreBlock(4.8f, 4.8f))
    val DEEPSLATE_MYTHRIL_ORE = registerBlockAndItem("deepslate_mythril_ore", oreBlock(7.2f, 4.8f))
    val RAW_MYTHRIL_BLOCK = registerBlockAndItem("raw_mythril_block", rawBlock(8.0f, 9.6f))

    val ADAMANT_BLOCK = registerBlockAndItem("adamant_block", metalBlock(75.0F, 1200.0F))
    val ADAMANT_ORE = registerBlockAndItem("adamant_ore", oreBlock(45.0f, 1200.0f))
    val RAW_ADAMANT_BLOCK = registerBlockAndItem("raw_adamant_block", rawBlock(75.0f, 1200.0f))

    val ORICHALCUM_BLOCK = registerBlockAndItem("orichalcum_block", metalBlock(5.0f, 6.0f))
    val ORICHALCUM_ORE = registerBlockAndItem("orichalcum_ore", oreBlock(3.0f))
    val DEEPSLATE_ORICHALCUM_ORE = registerBlockAndItem("deepslate_orichalcum_ore", oreBlock(4.5f, 3.0f))
    val RAW_ORICHALCUM_BLOCK = registerBlockAndItem("raw_orichalcum_block", rawBlock(5.0f, 6.0f))

    val CARMOT_BLOCK = registerBlockAndItem("carmot_block", metalBlock(6.0f, 7.2f))
    val CARMOT_ORE = registerBlockAndItem("carmot_ore", oreBlock(3.6f, xpRange = UniformInt.of(3, 7)))
    val DEEPSLATE_CARMOT_ORE = registerBlockAndItem("deepslate_carmot_ore", oreBlock(5.4f, 3.6f))
    val RAW_CARMOT_BLOCK = registerBlockAndItem("raw_carmot_block", rawBlock(6.0f, 7.2f))

    val SARDONYX_BLOCK = registerBlockAndItem("sardonyx_block", gemBlock(5.0f, 6.0f))
    val SARDONYX_ORE = registerBlockAndItem("sardonyx_ore", oreBlock(3.0f, xpRange = UniformInt.of(3, 7)))
    val DEEPSLATE_SARDONYX_ORE = registerBlockAndItem("deepslate_sardonyx_ore", oreBlock(4.5f, 3.0f))

    val ALEXANDRITE_BLOCK = registerBlockAndItem("alexandrite_block", gemBlock(5.0f, 6.0f))
    val ALEXANDRITE_ORE = registerBlockAndItem("alexandrite_ore", oreBlock(3.0f, 3.0f, xpRange = UniformInt.of(3, 7)))
    val DEEPSLATE_ALEXANDRITE_ORE = registerBlockAndItem("deepslate_alexandrite_ore", oreBlock(4.5f, 3.0f))

    val TANZANITE_BLOCK = registerBlockAndItem("tanzanite_block", gemBlock(7.5f, 9.0f))
    val TANZANITE_ORE = registerBlockAndItem("tanzanite_ore", oreBlock(4.5f, xpRange = UniformInt.of(3, 7)))

    val BLACK_OPAL_BLOCK = registerBlockAndItem("black_opal_block", gemBlock(0.8f))
    val BLACK_OPAL_ORE = registerBlockAndItem("black_opal_ore", oreBlock(3.0f, xpRange = UniformInt.of(3, 7)))
    val BASALT_BLACK_OPAL_ORE = registerBlockAndItem("basalt_black_opal_ore",
        {RotatedPillarBlockDropsXP(
            BlockBehaviour.Properties.ofLegacyCopy(Blocks.BASALT).requiresCorrectToolForDrops(),
            UniformInt.of(3, 7)
        )}
    )

    val TSAVORITE_BLOCK = registerBlockAndItem("tsavorite_block", gemBlock(5.0f, 6.0f))
    val TSAVORITE_ORE = registerBlockAndItem("tsavorite_ore", oreBlock(3.0f, xpRange = UniformInt.of(3, 7)))
    val DEEPSLATE_TSAVORITE_ORE = registerBlockAndItem("deepslate_tsavorite_ore", oreBlock(4.5f, 3.0f))

    val ORE_BLOCKS = listOf(
        MYTHRIL_ORE,
        DEEPSLATE_MYTHRIL_ORE,
        ADAMANT_ORE,
        ORICHALCUM_ORE,
        DEEPSLATE_ORICHALCUM_ORE,
        CARMOT_ORE,
        DEEPSLATE_CARMOT_ORE,

        SARDONYX_ORE,
        DEEPSLATE_SARDONYX_ORE,
        ALEXANDRITE_ORE,
        DEEPSLATE_ALEXANDRITE_ORE,
        TANZANITE_ORE,
        BLACK_OPAL_ORE,
        BASALT_BLACK_OPAL_ORE,
        TSAVORITE_ORE,
        DEEPSLATE_TSAVORITE_ORE
    )

    val RAW_BLOCKS = listOf(
        RAW_MYTHRIL_BLOCK,
        RAW_ADAMANT_BLOCK,
        RAW_ORICHALCUM_BLOCK,
        RAW_CARMOT_BLOCK
    )

    val METAL_BLOCKS = listOf(
        MYTHRIL_BLOCK,
        ADAMANT_BLOCK,
        ORICHALCUM_BLOCK,
        CARMOT_BLOCK,

        SARDONYX_BLOCK,
        ALEXANDRITE_BLOCK,
        TANZANITE_BLOCK,
        BLACK_OPAL_BLOCK,
        TSAVORITE_BLOCK
    )

    private fun metalBlock(strength: Float = 4.0f, blastResistance: Float = strength) = Supplier { Block(
        BlockBehaviour.Properties.ofLegacyCopy(Blocks.IRON_BLOCK)
            .strength(strength, blastResistance).requiresCorrectToolForDrops().sound(SoundType.METAL)
    )}
    private fun gemBlock(strength: Float = 4.0f, blastResistance: Float = strength) = Supplier { Block(
        BlockBehaviour.Properties.ofLegacyCopy(Blocks.DIAMOND_BLOCK)
            .strength(strength, blastResistance).requiresCorrectToolForDrops().sound(SoundType.METAL)
    )}
    private fun oreBlock(strength: Float = 4.0f, blastResistance: Float = strength, xpRange: IntProvider = ConstantInt.ZERO) = Supplier { DropExperienceBlock(
        xpRange,
        BlockBehaviour.Properties.ofLegacyCopy(Blocks.STONE)
            .strength(strength, blastResistance).requiresCorrectToolForDrops()
    )}
    private fun rawBlock(strength: Float = 4.0f, blastResistance: Float = strength) = Supplier { Block(
        BlockBehaviour.Properties.ofLegacyCopy(Blocks.RAW_IRON_BLOCK)
            .strength(strength, blastResistance).requiresCorrectToolForDrops()
    )}

    private fun <T: Block> registerBlockAndItem(name: String, block: Supplier<T>): DeferredBlock<T> {
        return BLOCKS_REGISTER.register(name, block).also {
                deferredBlock ->
            ModItems.ITEMS_REGISTER.register(name, Supplier { BlockItem(deferredBlock.get(), Item.Properties()) })
        }
    }

    fun register(eventBus: IEventBus) {
        BLOCKS_REGISTER.register(eventBus)
    }
}