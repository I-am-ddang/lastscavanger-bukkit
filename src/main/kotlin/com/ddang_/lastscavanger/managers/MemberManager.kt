package com.ddang_.lastscavanger.managers

import com.ddang_.lastscavanger.Lastscavanger
import com.ddang_.lastscavanger.objects.Member
import com.ddang_.lastscavanger.objects.Party
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import java.io.File

class MemberManager {
    companion object {
        val memberList = arrayListOf<Member>()

        fun getMember(name: String) = memberList.find { it.player.name == name }

        fun set(p: Player) {
            val file = File(Lastscavanger.instance.dataFolder, "${File.separator}PlayerData${File.separator}${p.uniqueId}.yml")
            val userdata = YamlConfiguration.loadConfiguration(file)
            Member(
                p,
                Party(p, arrayListOf(p))
            )
        }

        fun remove(p: Player) {
            val m = getMember(p.name) ?: return

            val file = File(Lastscavanger.instance.dataFolder, "${File.separator}PlayerData${File.separator}${p.uniqueId}.yml")
            val userdata = YamlConfiguration.loadConfiguration(file)

            userdata.save(file)
        }
    }
}