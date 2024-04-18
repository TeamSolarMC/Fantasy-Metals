package net.indevo.fantasy_metals.block;

import net.indevo.fantasy_metals.FantasyMetals;
import net.indevo.fantasy_metals.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, FantasyMetals.MOD_ID);

    public static final RegistryObject<Block> MYTHRIL_BLOCK = registerBlock("mythril_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(4.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> MYTHRIL_ORE = registerBlock("mythril_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_MYTHRIL_ORE = registerBlock("deepslate_mythril_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(4.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_MYTHRIL_BLOCK = registerBlock("raw_mythril_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(4.0F).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ADAMANT_BLOCK = registerBlock("adamant_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(5.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> ADAMANT_ORE = registerBlock("adamant_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(5.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_ADAMANT_BLOCK = registerBlock("raw_adamant_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(5.0F).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> ORICHALCUM_BLOCK = registerBlock("orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2.5F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> ORICHALCUM_ORE = registerBlock("orichalcum_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ORICHALCUM_ORE = registerBlock("deepslate_orichalcum_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.5F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_ORICHALCUM_BLOCK = registerBlock("raw_orichalcum_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(2.5F).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> CARMOT_BLOCK = registerBlock("carmot_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));
    public static final RegistryObject<Block> CARMOT_ORE = registerBlock("carmot_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSlATE_CARMOT_ORE = registerBlock("deepslate_carmot_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RAW_CARMOT_BLOCK = registerBlock("raw_carmot_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)
                    .strength(3.0F).requiresCorrectToolForDrops()));


    public static final RegistryObject<Block> SARDONYX_ORE = registerBlock("sardonyx_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_SARDONYX_ORE = registerBlock("deepslate_sardonyx_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SARDONYX_BLOCK = registerBlock("sardonyx_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));


    public static final RegistryObject<Block> ALEXANDRITE_ORE = registerBlock("alexandrite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_ALEXANDRITE_ORE = registerBlock("deepslate_alexandrite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> ALEXANDRITE_BLOCK = registerBlock("alexandrite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(2.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));


    public static final RegistryObject<Block> TANZANITE_ORE = registerBlock("tanzanite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TANZANITE_BLOCK = registerBlock("tanzanite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));


    public static final RegistryObject<Block> BLACK_OPAL_ORE = registerBlock("black_opal_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> BLACK_OPAL_BLOCK = registerBlock("black_opal_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));


    public static final RegistryObject<Block> TSAVORITE_ORE = registerBlock("tsavorite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DEEPSLATE_TSAVORITE_ORE = registerBlock("deepslate_tsavorite_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TSAVORITE_BLOCK = registerBlock("tsavorite_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                    .strength(3.0F).requiresCorrectToolForDrops().sound(SoundType.METAL)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
