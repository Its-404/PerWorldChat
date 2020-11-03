package me.four04.perworldchat.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.Set;

public class AsyncPlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        Player sender = event.getPlayer();

        Set<Player> recipients = event.getRecipients();
        recipients.removeIf(recipient -> !sender.getWorld().equals(recipient.getWorld()));
    }
}