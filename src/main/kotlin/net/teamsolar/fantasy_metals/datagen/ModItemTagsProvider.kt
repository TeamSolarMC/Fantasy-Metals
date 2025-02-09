package net.teamsolar.fantasy_metals.datagen

import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.common.data.ExistingFileHelper
import net.teamsolar.fantasy_metals.FantasyMetals
import net.teamsolar.fantasy_metals.item.MetalEquipmentSet
import net.teamsolar.fantasy_metals.item.GemItemSet
import net.teamsolar.fantasy_metals.item.ModItems
import java.util.concurrent.CompletableFuture
import javax.annotation.ParametersAreNonnullByDefault

class ModItemTagsProvider(
    packOutput: PackOutput, future: CompletableFuture<HolderLookup.Provider>,
    completableFuture: CompletableFuture<TagLookup<Block>>, existingFileHelper: ExistingFileHelper
) :
    ItemTagsProvider(packOutput, future, completableFuture, FantasyMetals.MODID, existingFileHelper) {
    @ParametersAreNonnullByDefault
    override fun addTags(provider: HolderLookup.Provider) {
        val providerHelper = object: ItemTagsProviderHelper {
            override fun tag(tagKey: TagKey<Item>): IntrinsicTagAppender<Item> = this@ModItemTagsProvider.tag(tagKey)
            override fun copy(blockTag: TagKey<Block>, itemTag: TagKey<Item>) = this@ModItemTagsProvider.copy(blockTag, itemTag)
        }
        fun MetalEquipmentSet.thenAddTags() = providerHelper.addTags()
        fun GemItemSet.thenAddTags() = providerHelper.addTags()

        ModItems.MYTHRIL_SET.thenAddTags()
        ModItems.ADAMANT_SET.thenAddTags()
        ModItems.ORICHALCUM_SET.thenAddTags()
        ModItems.CARMOT_SET.thenAddTags()

        for(gem in ModItems.GEMS) {
            gem.thenAddTags()
            /*tag(Tags.Items.GEMS).add(
                gem.gem.get()
            )
            tag(ItemTags.BEACON_PAYMENT_ITEMS).add(
                gem.gem.get()
            )*/
        }
    }

    override fun getName(): String {
        return "Item Tags"
    }
}
