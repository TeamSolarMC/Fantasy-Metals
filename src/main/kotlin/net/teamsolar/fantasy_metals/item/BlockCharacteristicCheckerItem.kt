package net.teamsolar.fantasy_metals.item

import net.minecraft.network.chat.Component
import net.minecraft.world.InteractionResult
import net.minecraft.world.item.Item
import net.minecraft.world.item.context.UseOnContext
import net.teamsolar.fantasy_metals.item.style.plus

class BlockCharacteristicCheckerItem: Item(Item.Properties().stacksTo(1)) {
    override fun useOn(context: UseOnContext): InteractionResult {
        val blockPos = context.clickedPos
        val blockState = context.level.getBlockState(blockPos)

        val speed = blockState.getDestroySpeed(context.level, blockPos)
        val resistance = blockState.block.explosionResistance
        context.player?.swing(context.hand)
        if(context.level.isClientSide) {
            context.player?.displayClientMessage(Component.literal("Block ")
                + blockState.block.name + " has hardness $speed and blast resistance $resistance", false)
        }
        return InteractionResult.sidedSuccess(context.level.isClientSide)
    }
}