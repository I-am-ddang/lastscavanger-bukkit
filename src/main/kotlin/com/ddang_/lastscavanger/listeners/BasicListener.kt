package com.ddang_.lastscavanger.listeners

import com.destroystokyo.paper.event.server.AsyncTabCompleteEvent
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

    @EventHandler
    fun commandSend(e: PlayerCommandSendEvent){

        if (e.player.isOp){
            return
        }

        e.commands.removeIf { cmd -> !allowedCommand.contains("/${cmd}") }
    }

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