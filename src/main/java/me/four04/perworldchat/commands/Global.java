package me.four04.perworldchat.commands;

import me.four04.perworldchat.PerWorldChat;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Global implements CommandExecutor {

    private final String prefix = ChatColor.DARK_GRAY + "[" + ChatColor.AQUA + "Global" + ChatColor.DARK_GRAY + "] " + ChatColor.RESET;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && label.equalsIgnoreCase("global")) {

            Player player = (Player) sender;

            String permission = "pwc.global";
            if (!sender.hasPermission(permission)) {
                player.sendMessage(PerWorldChat.prefix + ChatColor.RED + "missing permission: '" + permission + "'");
                return true;
            }

            if (args.length == 0) {
                player.sendMessage(PerWorldChat.prefix + ChatColor.RED + "You must enter a message!");
                return false;
            }

            String message = String.join(" ", args); //Made delimiter a space (for parsing global messages)
            String broadcast = this.prefix + ChatColor.DARK_AQUA + player.getName() + ": " + ChatColor.RESET + message;

            for (Player p : PerWorldChat.server.getOnlinePlayers()) {
                p.sendMessage(broadcast);
            }
            return true;
        }
        return false;
    }
}
