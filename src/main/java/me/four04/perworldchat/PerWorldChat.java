package me.four04.perworldchat;

import me.four04.perworldchat.listeners.AsyncPlayerChat;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

// Created by 404NotFound on 11/2/20

public final class PerWorldChat extends JavaPlugin {

    public PluginManager pm = null;

    @Override
    public void onEnable() {
        pm = Bukkit.getPluginManager();
        registerListener(new AsyncPlayerChat());

        Bukkit.getLogger().info("Enabled PerWorldChat.");
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabled PerWorldChat.");
    }

    private void registerListener(Listener listener) {
        pm.registerEvents(listener, this);
    }
}
