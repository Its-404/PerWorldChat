package me.four04.perworldchat.listeners;

import me.four04.perworldchat.PerWorldChat;
import me.four04.perworldchat.config.Config;
import me.four04.perworldchat.config.LinkedWorld;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AsyncPlayerChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        World origin = event.getPlayer().getWorld();
        Set<Player> recipients = event.getRecipients();

        LinkedWorld link = null;
        for (LinkedWorld lw : Config.data.linkedWorlds) {
            List<World> worlds = PerWorldChat.worldUtil().getWorldsByName(lw.getLinkedWorldNames());

            if (worlds != null && worlds.contains(origin)) {
                link = lw; break;
            }
        }

        List<World> linkedWorlds = new ArrayList<>();
        if (link != null) {
            for (World world : PerWorldChat.worldUtil().getWorldsByName(link.getLinkedWorldNames())) {
                if (world != origin) {
                    linkedWorlds.add(world);
                }
            }
        }

        for (Player recipient : recipients) {
            World world = recipient.getWorld();
            if (this.altDimensionDetected(origin.getName(), world.getName())) continue;

            if (!world.equals(origin) && !linkedWorlds.contains(world)) {
                recipients.remove(recipient);
            }
        }
    }

    private boolean altDimensionDetected(String origin, String name) {
        if (Config.data.autoDetectEnabled) {
            if (origin.equalsIgnoreCase(name + "_nether") || origin.equalsIgnoreCase(name + "_the_end")) {
                return true;
            }
            else return name.toLowerCase().replace("_nether", "").replace("_the_end", "").equalsIgnoreCase(origin);
        }
        return false;
    }
}