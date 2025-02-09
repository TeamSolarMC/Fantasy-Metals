package net.teamsolar.fantasy_metals.item

import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.registries.DeferredItem
import net.teamsolar.fantasy_metals.datagen.*

open class GemItemSet(val GEM: DeferredItem<out Item>): ItemSet() {
    final override val prefix = (GEM.id.path)

    val GEM_TAG: TagKey<Item> = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "gems/$prefix"))
    val ORE_TAG: TagKey<Block> = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "ores/$prefix"))
    val ORE_TAG_ITEM: TagKey<Item> = ItemTags.create(ORE_TAG.location)

    val STORAGE_TAG: TagKey<Block> = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/$prefix"))
    val STORAGE_TAG_ITEM = ItemTags.create(STORAGE_TAG.location)

    open fun ItemTagsProviderHelper.addTags() {
        // Etc.
        ItemTags.BEACON_PAYMENT_ITEMS.add(GEM.get())
        tag(GEM_TAG).add(GEM.get())
        tag(Tags.Items.GEMS).addTag(GEM_TAG)

        copy(ORE_TAG, ORE_TAG_ITEM)
        copy(STORAGE_TAG, STORAGE_TAG_ITEM)
    }

    open fun<T> T.addTags()
    where T: BlockTagsProviderHelper, T: ModBlockInputHelper {
        for(ore in oreBlocksWithPrefix(prefix)) {
            val oreBlock = ore.get()
            if(ore.asItem().idWithoutNamespace.matches(Regex("deepslate_.*"))) {
                tag(Tags.Blocks.ORES_IN_GROUND_DEEPSLATE).add(oreBlock)
            }
            tag(ORE_TAG).add(oreBlock)
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(oreBlock)
        }
        for(metalBlock in metalBlocksWithPrefix(prefix)) {
            tag(STORAGE_TAG).add(metalBlock.get())
            tag(BlockTags.BEACON_BASE_BLOCKS).add(metalBlock.get())
            tag(BlockTags.MINEABLE_WITH_PICKAXE).add(metalBlock.get())
        }
        tag(Tags.Blocks.ORES).addTag(ORE_TAG)
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(STORAGE_TAG)
    }
    open fun<T> T.buildRecipes(output: RecipeOutput)
            where T: RecipeProviderHelper, T: ModBlockInputHelper {
        for(metalBlock in metalBlocksWithPrefix(prefix)) {
            blockFromItem(metalBlock, GEM, output)
        }
    }
    open fun ItemModelProviderHelper.register() {
        simpleItem(GEM)
    }
}