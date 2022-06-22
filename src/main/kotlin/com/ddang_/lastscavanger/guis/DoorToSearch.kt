package com.ddang_.lastscavanger.guis

import org.bukkit.entity.Player
import org.bukkit.event.inventory.InventoryClickEvent

class DoorToSearch: CustomGUIHolder() {
    override fun process(e: InventoryClickEvent) {
        val p = e.whoClicked as Player
        e.isCancelled = true
    }
}