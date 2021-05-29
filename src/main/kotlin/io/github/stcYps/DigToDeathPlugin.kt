package io.github.stcYps

import io.github.stcYps.commands.CommandListener
import io.github.stcYps.commands.TabCompleter
import io.github.stcYps.events.EventListener

import org.bukkit.plugin.java.JavaPlugin

class DigToDeathPlugin: JavaPlugin() {
    override fun onEnable() {
        getCommand("dd")?.setExecutor(CommandListener())
        getCommand("dd")?.setTabCompleter(TabCompleter())
        server.pluginManager.registerEvents(EventListener(), this)
    }
}