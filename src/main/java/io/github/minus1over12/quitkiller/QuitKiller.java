package io.github.minus1over12.quitkiller;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

/**
 * A plugin that kills a player if they have a killer when they quit.
 *
 * @author War Pigeon
 */
public final class QuitKiller extends JavaPlugin {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new Listener() {
            /**
             * Kills a player if they have a killer when they quit.
             *
             * @param event The event that is triggered when a player quits.
             */
            @EventHandler
            public static void killQuitter(@NotNull PlayerQuitEvent event) {
                Player player = event.getPlayer();
                if (player.getKiller() != null) {
                    player.setHealth(0);
                }
            }
        }, this);
    }
}
