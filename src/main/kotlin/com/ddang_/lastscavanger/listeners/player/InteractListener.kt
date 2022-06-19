package com.ddang_.lastscavanger.listeners.player

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerInteractEvent

class InteractListener: Listener {
    @EventHandler
    fun onInteract(e: PlayerInteractEvent) {
        val p = e.player
    }
}