package com.ddang_.lastscavanger.managers

import com.ddang_.lastscavanger.utils.LocUtil
import org.bukkit.Bukkit
import org.bukkit.Location

class AreaManager {
    companion object {
        fun isInSpawn(loc: Location): Boolean {

            if (loc.world?.name != "world") {
                return false
            }

            val w = Bukkit.getWorld("world") ?: return false
            val loc1 = Location(w, 10.0, -60.0, 10.0)
            val loc2 = Location(w, -10.0, 320.0, -10.0)

            return LocUtil.isInArea(loc, loc1, loc2)
        }
    }
}