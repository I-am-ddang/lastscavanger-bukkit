package com.ddang_.lastscavanger.guis

import org.bukkit.Bukkit
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.InventoryHolder

abstract class CustomGUIHolder: InventoryHolder {
    override fun getInventory(): Inventory {
        return Bukkit.createInventory(this, 9)
    }
    abstract fun process(e: InventoryClickEvent)
}