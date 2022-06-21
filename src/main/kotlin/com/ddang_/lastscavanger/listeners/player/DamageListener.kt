package com.ddang_.lastscavanger.listeners.player

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent

class DamageListener: Listener {
    @EventHandler
    fun onDamage(e: EntityDamageEvent) {
        val p = e.entity
        if (p !is Player) {
            return
        }
    }
}