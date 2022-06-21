package com.ddang_.lastscavanger.objects

import com.ddang_.lastscavanger.managers.PartyManager
import org.bukkit.entity.Player

class Party (val leader: Player,
             val members: List<Player>) {
    init {
        PartyManager.partyList.add(this)
    }
}