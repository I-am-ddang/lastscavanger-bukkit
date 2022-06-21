package com.ddang_.lastscavanger.managers

import com.ddang_.lastscavanger.objects.Party
import org.bukkit.entity.Player

class PartyManager {
    companion object {
        val partyList = arrayListOf<Party>()

        fun getParty(leaderName: String) = partyList.find { it.leader.name == leaderName }
    }
}