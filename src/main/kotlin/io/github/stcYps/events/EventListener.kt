package io.github.stcYps.events

import io.github.stcYps.PluginStatus

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent

class EventListener: Listener {
    @EventHandler
    fun onBlockBreak(e: BlockBreakEvent) {
        // プラグインが有効化しているかどうか
        // 有効ならブロックを掘ったら死ぬ(´・ω・｀)
        if(PluginStatus.isActive) {
            e.player.damage(10000.0)
        }
    }
}
