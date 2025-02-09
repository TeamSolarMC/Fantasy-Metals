package net.teamsolar.fantasy_metals.item.style

import net.minecraft.ChatFormatting
import net.minecraft.network.chat.Component
import net.minecraft.network.chat.MutableComponent

operator fun MutableComponent.plus(other: Component): MutableComponent = this.append(other)
operator fun MutableComponent.plus(other: String): MutableComponent = this.append(Component.literal(other))
infix fun String.style(style: ChatFormatting): MutableComponent = Component.literal(this).withStyle(style)
infix fun MutableComponent.style(style: ChatFormatting): MutableComponent = this.withStyle(style)