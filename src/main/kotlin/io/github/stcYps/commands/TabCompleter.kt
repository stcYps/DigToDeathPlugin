package io.github.stcYps.commands

import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.command.TabCompleter

class TabCompleter: TabCompleter {
    override fun onTabComplete (sender: CommandSender, command: Command, alias: String, args: Array<out String>): MutableList<String> {
        val result: MutableList<String> = mutableListOf()
        if(args.size == 1) {
            result.addAll(listOf("start", "end", "help"))
        }
        else {
            result.clear()
        }
        return result
    }
}