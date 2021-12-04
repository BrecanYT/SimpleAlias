package com.brecanyt.plugin.commands;

import com.brecanyt.plugin.SimpleAlias;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    private SimpleAlias plugin;

    public ReloadCommand(SimpleAlias plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
        if (!(player instanceof Player)) {
            plugin.reloadConfig();;
            plugin.saveConfig();
            Bukkit.getLogger().info(ChatColor.AQUA + "Configuracion recargada");
            // Returns true because the console can execute anything.
            return true;

        } else if (player.hasPermission("simplealias.reload")) {
            plugin.reloadConfig();
            plugin.saveConfig();
            player.sendMessage(ChatColor.AQUA + "Configuracion recargada");
            System.out.println("Configuracion recargada");
            return true;

        } else {
            return false;
        }
    }
}
