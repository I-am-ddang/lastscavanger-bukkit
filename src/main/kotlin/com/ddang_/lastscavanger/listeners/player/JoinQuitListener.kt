package com.ddang_.lastscavanger.listeners.player

import net.md_5.bungee.api.ChatColor
import org.bukkit.GameMode
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent
import org.bukkit.event.player.PlayerQuitEvent
import java.text.SimpleDateFormat
import java.util.*

class JoinQuitListener: Listener {
    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        val p = e.player

        //게임 모드 모험으로 설정
        p.gameMode = GameMode.ADVENTURE

        //접속 메시지
        val now = Date()
        val format = SimpleDateFormat("yyyy:MM:dd HH:mm:ss.SS", Locale.KOREA)

        e.joinMessage = "${ChatColor.of("#ccffbf")}   접속 ${p.name} §7// ${format.format(now)}"
    }

    @EventHandler
    fun onQuit(e: PlayerQuitEvent) {
        val p = e.player

        //퇴장 메시지
        val now = Date()
        val format = SimpleDateFormat("yyyy:MM:dd HH:mm:ss.SS", Locale.KOREA)

        e.quitMessage = "${ChatColor.of("#ffc9bf")}   퇴장 ${p.name} §7// ${format.format(now)}"
    }
}