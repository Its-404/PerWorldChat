package me.four04.perworldchat.managers;

import me.four04.perworldchat.PerWorldChat;
import me.four04.perworldchat.listeners.AsyncPlayerChat;
import org.bukkit.event.Listener;

public class EventManager {

    public void registerListeners() {
        registerListener(new AsyncPlayerChat());
    }

    private void registerListener(Listener listener) {
        PerWorldChat.pm.registerEvents(listener, PerWorldChat.plugin);
    }
}
