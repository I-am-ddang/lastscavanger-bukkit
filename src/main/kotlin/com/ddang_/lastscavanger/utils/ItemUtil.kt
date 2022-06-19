package com.ddang_.lastscavanger.utils

import com.ddang_.lastscavanger.Lastscavanger
import net.kyori.adventure.text.Component
import org.bukkit.Material
import org.bukkit.NamespacedKey
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemFlag
import org.bukkit.inventory.ItemStack
import org.bukkit.inventory.meta.SkullMeta
import org.bukkit.persistence.PersistentDataType

class ItemUtil {
    fun toItem(name: Component,
               material: Material,
               amount: Int,
               loreLine: List<Component>,
               cmd: Int?): ItemStack {
        val i = ItemStack(material, amount)
        val meta = i.itemMeta?.apply {
            displayName(name)
            lore(loreLine)
            setCustomModelData(cmd)
            addItemFlags(
                ItemFlag.HIDE_ATTRIBUTES,
                ItemFlag.HIDE_DYE,
                ItemFlag.HIDE_POTION_EFFECTS,
                ItemFlag.HIDE_ENCHANTS)
        }
        i.itemMeta = meta
        return i
    }

    fun toHead(name: Component,
               owner: Player,
               amount: Int,
               loreLine: List<Component>): ItemStack {
        val i = ItemStack(Material.PLAYER_HEAD, amount)
        val meta = i.itemMeta as SkullMeta
        meta.displayName(name)
        meta.owningPlayer = owner
        meta.lore(loreLine)
        meta.addItemFlags(
            ItemFlag.HIDE_ENCHANTS)
        i.itemMeta = meta
        return i
    }

    fun applyStringPDC(itemstack: ItemStack, keyName: String, value: String): ItemStack {
        val key = NamespacedKey(Lastscavanger.instance, keyName)
        val meta = itemstack.itemMeta.apply {
            persistentDataContainer.set(key, PersistentDataType.STRING, value)
        }
        itemstack.itemMeta = meta
        return itemstack
    }

    fun getStringPDC(itemstack: ItemStack, keyName: String): String? {
        val meta = itemstack.itemMeta
        val key = NamespacedKey(Lastscavanger.instance, keyName)
        return meta.persistentDataContainer.get(key, PersistentDataType.STRING)
    }
}