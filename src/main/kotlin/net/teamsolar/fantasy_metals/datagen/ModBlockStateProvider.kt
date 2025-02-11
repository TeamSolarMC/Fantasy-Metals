package net.teamsolar.fantasy_metals.datagen

import net.minecraft.core.Direction
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.PackOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.RotatedPillarBlock
import net.neoforged.neoforge.client.model.generators.BlockStateProvider
import net.neoforged.neoforge.client.model.generators.ModelFile
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.neoforged.neoforge.registries.DeferredBlock
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.block.ModBlocks
import net.teamsolar.fantasy_metals.block.RotatedPillarBlockDropsXP

class ModBlockStateProvider(output: PackOutput, exFileHelper: ExistingFileHelper) : BlockStateProvider(output, FantasyMetals.MODID,
    exFileHelper
) {
    override fun registerStatesAndModels() {
        val helper = object : ModBlockInputHelper {
            override val ORE_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.ORE_BLOCKS
            override val RAW_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.RAW_BLOCKS
            override val METAL_BLOCKS: List<DeferredBlock<out Block>> = ModBlocks.METAL_BLOCKS
        }
        for(block in helper.BLOCKS) {
            val actual = block.get()
            when (actual) {
                is RotatedPillarBlockDropsXP -> {
                    val resourceLocation = key(actual)
                    val side = ResourceLocation.fromNamespaceAndPath(resourceLocation.namespace, "block/" + resourceLocation.path + "_side")
                    val top = ResourceLocation.fromNamespaceAndPath(resourceLocation.namespace, "block/" + resourceLocation.path + "_top")
                    axisBlock(actual, side, top)
                    itemModels().withExistingParent(resourceLocation.toString(), ResourceLocation.fromNamespaceAndPath(resourceLocation.namespace, "block/" + resourceLocation.path))
                }
                is RotatedPillarBlock -> {
                    axisBlock(actual)
                }
                else -> {
                    blockWithItem(block)
                }
            }
        }
    }

    private fun blockWithItem(block: DeferredBlock<out Block>) {
        simpleBlockWithItem(block.get(), cubeAll(block.get()))
    }
    fun axisBlock(block: RotatedPillarBlockDropsXP, side: ResourceLocation, end: ResourceLocation) {
        axisBlock(
            block,
            models().cubeColumn(name(block), side, end),
            models().cubeColumnHorizontal(name(block) + "_horizontal", side, end)
        )
    }
    fun axisBlock(block: RotatedPillarBlockDropsXP, vertical: ModelFile, horizontal: ModelFile) {
        val builder = getVariantBuilder(block)
            .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Y)
            .modelForState().modelFile(vertical).addModel()
            .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.Z)
            .modelForState().modelFile(horizontal).rotationX(90).addModel()
            .partialState().with(RotatedPillarBlock.AXIS, Direction.Axis.X)
            .modelForState().modelFile(horizontal).rotationX(90).rotationY(90).addModel()

        builder.models
    }

    private fun key(block: Block): ResourceLocation {
        return BuiltInRegistries.BLOCK.getKey(block)
    }

    private fun name(block: Block): String {
        return key(block).path
    }
}