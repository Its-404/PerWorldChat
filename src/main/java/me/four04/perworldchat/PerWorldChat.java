package me.four04.perworldchat;

import me.four04.perworldchat.config.Config;
import me.four04.perworldchat.managers.EventManager;
import me.four04.perworldchat.util.WorldUtil;
import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

// Created by 404NotFound on 11/2/20
// Last updated on 11/3/20

public final class PerWorldChat extends JavaPlugin {

    public static JavaPlugin plugin = null;
    public static Server server = null;
    public static PluginManager pm = null;

    @Override
    public void onEnable() {
        plugin = this;
        server = Bukkit.getServer();

        pm = Bukkit.getPluginManager();
        eventManager().registerListeners();

        new Config(this);

        Bukkit.getLogger().info("Enabled PerWorldChat!");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabled PerWorldChat!");
    }

    public static EventManager eventManager() {
        return new EventManager();
    }
    public static WorldUtil worldUtil() {
        return new WorldUtil();
    }
}
