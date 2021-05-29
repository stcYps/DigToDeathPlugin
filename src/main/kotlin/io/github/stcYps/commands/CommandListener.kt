package io.github.stcYps.commands

import io.github.stcYps.PluginStatus

import org.bukkit.ChatColor
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

class CommandListener: CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        // (ChatColor.RED + "メッセージ") ← これKotlinでどうやんの
        val errColor: ChatColor = ChatColor.RED
        val helpColor: ChatColor = ChatColor.GREEN

        // 今回引数の数は一個だけなので、それ以外の場合はメッセージを送信して終了する
        if (args.size != 1) {
            sender.sendMessage("$errColor[DigToDeathPlugin]引数の数がおかしいよ")
            return true
        }

        when {
            args[0] == "start" -> {
                if(PluginStatus.isActive) {
                    sender.sendMessage("$errColor[DigToDeathPlugin]もう開始してるよ…")
                    return true
                }
                sender.sendMessage("[DigToDeathPlugin]ブロックを掘ったら死んじゃうモードSTART！！")
                PluginStatus.isActive = true
            }
            args[0] == "end" -> {
                if(!PluginStatus.isActive) {
                    sender.sendMessage("$errColor[DigToDeathPlugin]とっくに終了してるよ！")
                    return true
                }
                sender.sendMessage("[DigToDeathPlugin]ブロックを掘っても死ななくなったよ！！")
                PluginStatus.isActive = false
            }
            args[0] == "help" -> {
                sender.sendMessage(
                    "$helpColor[DigDeathPlugin]コマンド一覧！！\n"+
                    "$helpColor/dd start : ブロックを掘ったら死んじゃうモードが開始されるよ！\n"+
                    "$helpColor/dd end   : ブロックを掘ったら死んじゃうモードが停止するよ！\n"+
                    "$helpColor/dd help  : このプラグインのコマンド一覧を表示するよ！"
                )
            }
            else -> {
                sender.sendMessage("$errColor[DigToDeathPlugin]引数が不正な値だよ！ /dd help を見てみてね")
                return true
            }
        }
        return true
    }
}
