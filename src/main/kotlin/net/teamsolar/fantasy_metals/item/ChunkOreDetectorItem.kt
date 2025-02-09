package net.teamsolar.fantasy_metals.item

import net.minecraft.core.Vec3i
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResult
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.context.UseOnContext
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.chunk.ChunkAccess
import net.minecraft.world.level.levelgen.structure.BoundingBox
import net.minecraft.world.phys.AABB
import net.neoforged.neoforge.common.Tags
import net.teamsolar.fantasy_metals.item.ModCreativeModeTabs.idWithoutNamespace
import net.teamsolar.fantasy_metals.item.style.plus

class ChunkOreDetectorItem: Item(Item.Properties().stacksTo(1)) {

    private fun boundingBoxOfChunk(chunk: ChunkAccess): AABB {
        return AABB.of(
            BoundingBox.fromCorners(
                Vec3i(
                    chunk.pos.minBlockX + 1,
                    chunk.minBuildHeight,
                    chunk.pos.minBlockZ + 1
                ),
                Vec3i(
                    chunk.pos.maxBlockX,
                    chunk.maxBuildHeight,
                    chunk.pos.maxBlockZ
                )
            )
        )
    }
    private fun sortOreNames(entry: MutableMap. MutableEntry<BlockState, Int>): String {
        val name = BuiltInRegistries.BLOCK.getKey(entry.key.block).namespace
        val regex = Regex("Deepslate (.+)")
        val match = regex.matchEntire(name)
        if(match != null) {
            return match.groupValues[1]
        }
        return name
    }
    override fun use(level: Level, player: Player, usedHand: InteractionHand): InteractionResultHolder<ItemStack> {
        val itemStack = player.getItemInHand(usedHand)
        val blockPos = player.onPos
        player.swing(usedHand)
        if(!level.isClientSide) {
            val ores = mutableMapOf<BlockState, Int>()
            val chunk = level.getChunk(blockPos)
            val tag = Tags.Blocks.ORES
            for(blockState in chunk.getBlockStates(boundingBoxOfChunk(chunk))) {
                if(blockState.`is`(tag)) {
                    ores[blockState] = (ores[blockState] ?: 0) + 1
                }
            }
            val groups = ores.entries.groupBy { (ore, count) -> BuiltInRegistries.BLOCK.getKey(ore.block).namespace }
            for((modid, entries) in groups) {
                player.displayClientMessage(Component.literal("Source $modid"), false)
                for((oreType, count) in entries.sortedBy(::sortOreNames)) {
                    player.displayClientMessage(Component.literal("    ") + oreType.block.name + " x$count", false)
                }
            }
        }
        return InteractionResultHolder.sidedSuccess(itemStack, level.isClientSide)
    }
}