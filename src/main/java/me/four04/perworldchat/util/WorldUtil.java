package me.four04.perworldchat.util;

import me.four04.perworldchat.PerWorldChat;
import org.bukkit.World;

import java.util.ArrayList;
import java.util.List;

public class WorldUtil {
    public World getWorldByName(String name) {
        for (World world : PerWorldChat.server.getWorlds()) {
            if (world.getName().equalsIgnoreCase(name)) return world;
        }
        return null;
    }

    public List<World> getWorldsByName(List<String> names) {
        List<World> worlds = new ArrayList<>();
        for (String name : names) {

            World world = this.getWorldByName(name);
            if (world != null) {
                worlds.add(world);
            }
        }
        return worlds;
    }
}
