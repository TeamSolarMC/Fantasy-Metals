package net.teamsolar.fantasy_metals.item

import net.minecraft.world.item.Item
import net.neoforged.neoforge.registries.DeferredItem

abstract class ItemSet {
    abstract val prefix: String
    // overridable constructors
    class Entry<T: Item> (intermediate: EntryIntermediate, altConstructor: (Item.Properties) -> T) {
        // before it's registered:
        val registryKey = intermediate.registryKey
        var properties = intermediate.properties
        var constructor = fun(): T {
            return altConstructor(properties)
        }

        // once registered:
        var actual: DeferredItem<T>? = null
        fun item(): T = actual!!.get()
    }
    class EntryIntermediate(val registryKey: String, val properties: Item.Properties)
    protected infix fun<T: Item> String.entry(constructor: (Item.Properties) -> T): Entry<T> {
        return Entry(EntryIntermediate(this, Item.Properties()), constructor)
    }
    protected infix fun String.properties(properties: Item.Properties) = EntryIntermediate(this, properties)
    protected infix fun<T: Item> EntryIntermediate.constructor(constructor: (Item.Properties) -> T): Entry<T> {
        return Entry(this, constructor)
    }
}