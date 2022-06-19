package com.ddang_.lastscavanger.utils

import org.bukkit.Location

class LocUtil {
    companion object {
        fun isInArea(pl: Location, l1: Location, l2: Location): Boolean {
            val minX: Double = if (l1.x < l2.x) l1.x else l2.x
            val maxX: Double = if (l1.x > l2.x) l1.x else l2.x
            val minY: Double = if (l1.y < l2.y) l1.y else l2.y
            val maxY: Double = if (l1.y > l2.y) l1.y else l2.y
            val minZ: Double = if (l1.z < l2.z) l1.z else l2.z
            val maxZ: Double = if (l1.z > l2.z) l1.z else l2.z
            return pl.x in minX..maxX && pl.y in minY..maxY && pl.z in minZ..maxZ
        }
    }
}