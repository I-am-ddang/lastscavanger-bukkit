package com.ddang_.lastscavanger.listeners.player

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent

class JoinQuitListener: Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player
    }

    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        val p = e.player

    }
}