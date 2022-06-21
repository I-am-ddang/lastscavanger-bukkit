package com.ddang_.lastscavanger.listeners

import com.ddang_.lastscavanger.enums.Color
import com.ddang_.lastscavanger.managers.MemberManager
import com.ddang_.lastscavanger.utils.ComponentUtil
import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent
import io.papermc.paper.event.player.AsyncChatEvent
import net.kyori.adventure.text.Component
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.ItemSpawnEvent
import org.bukkit.event.player.PlayerCommandPreprocessEvent
import org.bukkit.event.player.PlayerCommandSendEvent

class BasicListener: Listener {
    companion object {
        val allowedCommand = arrayListOf("")
    }

    //아이템 이름
    @EventHandler
    fun itemSpawn(e: ItemSpawnEvent) {
        val item = e.entity
        item.isCustomNameVisible = true
    }

    //채팅
    @EventHandler
    fun onAsyncChat(e: AsyncChatEvent) {
        val p = e.player
        val m = MemberManager.getMember(p.name) ?: return
        if (m.party.members.size != 1) {
            return
        }
        p.sendMessage(
            Component.text().append(
                ComponentUtil.toText("  오류", Color.RED.code),
                ComponentUtil.toText(" 메시지를 보낼 파티원이 없습니다.", Color.LIGHT_GRAY.code),
                Component.newline(),
                ComponentUtil.toText("  오류", Color.RED.code),
                ComponentUtil.toText(" 은신처 -> 통신 장치", Color.WHITE.code),
                ComponentUtil.toText(" 를 사용해 채팅을 보낼 파티원을 구하세요.", Color.LIGHT_GRAY.code)
        ).build()
        )
        e.isCancelled = true
    }


    //탭
    @EventHandler
    fun asyncTab(e: AsyncTabCompleteEvent){

        if (e.sender.isOp){
            return
        }
        val buffer = e.buffer
        if (buffer.contains(" ")){
            return
        }
        val args = buffer.split(" ")
        if (args.isEmpty()){
            return
        }
        if (allowedCommand.contains(args[0].replace("/", ""))){
            e.completions.clear()
        }
    }

    //명령어 보내기
    @EventHandler
    fun commandSend(e: PlayerCommandSendEvent){

        if (e.player.isOp){
            return
        }

        e.commands.removeIf { cmd -> !allowedCommand.contains("/${cmd}") }
    }

    //명령어 작동
    @EventHandler
    fun onPlayerCommandPreprocess(e: PlayerCommandPreprocessEvent) {

        if (e.player.isOp) {
            return
        }

        val message = e.message.split(" ")[0]

        var can = false
        for (s in allowedCommand) {
            if (message == s) {
                can = true
            }
        }
        if (!can) e.isCancelled = true
    }
}