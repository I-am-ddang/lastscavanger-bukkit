package com.ddang_.lastscavanger

import com.ddang_.lastscavanger.listeners.BasicListener
import com.ddang_.lastscavanger.listeners.inventory.InventoryClickListener
import com.ddang_.lastscavanger.listeners.player.DamageListener
import com.ddang_.lastscavanger.listeners.player.InteractListener
import com.ddang_.lastscavanger.listeners.player.JoinQuitListener
import com.ddang_.lastscavanger.managers.MemberManager
import eu.decentsoftware.holograms.api.DHAPI
import org.bukkit.Bukkit
import org.bukkit.GameRule
import org.bukkit.World
import org.bukkit.entity.Player
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.scheduler.BukkitScheduler

class Lastscavanger : JavaPlugin() {
    companion object {
        fun String.info() = Bukkit.getLogger().info(this)
        fun String.warn() = Bukkit.getLogger().warning(this)
        fun String.broad() = Bukkit.broadcastMessage(this)


        fun Long.rt(delay: Long = 1, run: Runnable) = scheduler.runTaskTimer(instance, run, delay, this)
        fun Long.rtAsync(delay: Long = 1, run: Runnable) = scheduler
            .runTaskTimerAsynchronously(instance, run, delay, this)
        fun rAsync(run: Runnable) = scheduler.runTaskAsynchronously(instance, run)
        fun r(run: Runnable) = scheduler.runTask(instance, run)
        fun Long.rl(run: Runnable) = scheduler.runTaskLater(instance, run, this)
        fun Long.rlAsync(run: Runnable) = scheduler.runTaskLaterAsynchronously(instance, run, this)

        //인스턴스 필드
        lateinit var instance: Plugin
        lateinit var scheduler: BukkitScheduler
            private set
        lateinit var players: MutableCollection<out Player>
            private set
    }

    private fun memberSet() {
        players.forEach {
            MemberManager.set(it)
        }
    }

    private fun memberRemove() {
        players.forEach {
            MemberManager.remove(it)
        }
    }

    private fun World.setGameRule() {
        setGameRule(GameRule.RANDOM_TICK_SPEED, 0)
        setGameRule(GameRule.NATURAL_REGENERATION, false)
        setGameRule(GameRule.DO_MOB_SPAWNING, false)
        setGameRule(GameRule.KEEP_INVENTORY, true)
        setGameRule(GameRule.DO_WEATHER_CYCLE, false)
        setGameRule(GameRule.DO_TRADER_SPAWNING, false)
        setGameRule(GameRule.DO_PATROL_SPAWNING, false)
        setGameRule(GameRule.DO_MOB_LOOT, false)
        setGameRule(GameRule.DO_TILE_DROPS, false)
        setGameRule(GameRule.DO_LIMITED_CRAFTING, true)
        setGameRule(GameRule.DO_ENTITY_DROPS, false)
        setGameRule(GameRule.DO_IMMEDIATE_RESPAWN, true)
        setGameRule(GameRule.DISABLE_RAIDS, true)
        setGameRule(GameRule.ANNOUNCE_ADVANCEMENTS, true)
        setGameRule(GameRule.DROWNING_DAMAGE, false)
        setGameRule(GameRule.FALL_DAMAGE, false)
        setGameRule(GameRule.FIRE_DAMAGE, false)
        setGameRule(GameRule.FREEZE_DAMAGE, false)
    }

    //이벤트 목록
    private val events = arrayOf(
        BasicListener(), InteractListener(), JoinQuitListener(),
        DamageListener(), InventoryClickListener()
    )

    override fun onEnable() {
        //인스턴스 잡아주기
        players = server.onlinePlayers
        instance = this
        scheduler = server.scheduler
        val w = Bukkit.getWorld("world")!!

        //이벤트 등록
        server.pluginManager.apply { events.forEach { registerEvents(it, this@Lastscavanger) } }

        //명령어 등록

        //온라인 플레이어 멤버 등록
        memberSet()

        //게임룰
        w.setGameRule()
    }

    override fun onDisable() {
        //온라인 플레이어 멤버 정리
        memberRemove()
    }
}