package com.ddang_.lastscavanger.managers

import com.ddang_.lastscavanger.guis.DoorToSearch
import com.ddang_.lastscavanger.utils.ComponentUtil
import org.bukkit.Bukkit
import org.bukkit.inventory.Inventory

class GUIManager {
    companion object {
        fun getInventory(name: String): Inventory? {
            when (name) {
                "" -> {
                    val i = Bukkit.createInventory(DoorToSearch(), 9, ComponentUtil.toText("", ""))
                }
            }
            return null
        }
    }
}