package com.ddang_.lastscavanger.objects

import com.ddang_.lastscavanger.managers.MemberManager
import org.bukkit.entity.Player

class Member (val player: Player) {
    init {
        MemberManager.memberList.add(this)
    }
}