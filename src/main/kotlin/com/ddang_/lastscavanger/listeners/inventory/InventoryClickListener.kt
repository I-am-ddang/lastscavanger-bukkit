package com.ddang_.lastscavanger.listeners.inventory

import com.ddang_.lastscavanger.guis.CustomGUIHolder
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent

class InventoryClickListener: Listener {
    @EventHandler
    fun onInvClick(e: InventoryClickEvent) {
        val holder = e.view.topInventory.holder ?: return
        if (holder is CustomGUIHolder) {
            holder.process(e)
        }
    }
}