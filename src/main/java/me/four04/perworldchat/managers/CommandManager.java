package me.four04.perworldchat.managers;

import me.four04.perworldchat.PerWorldChat;
import me.four04.perworldchat.commands.Global;
import org.bukkit.command.CommandExecutor;

import java.util.Objects;

public class CommandManager {
    public void registerCommands() {
        this.registerCommand("global", new Global());
    }

    private void registerCommand(String label, CommandExecutor command) {
        Objects.requireNonNull(PerWorldChat.plugin.getCommand(label)).setExecutor(command);
    }
}
