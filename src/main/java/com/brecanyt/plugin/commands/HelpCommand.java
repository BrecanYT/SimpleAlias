package com.brecanyt.plugin.commands;

import com.brecanyt.plugin.SimpleAlias;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HelpCommand implements CommandExecutor {

    private SimpleAlias plugin;

    public HelpCommand(SimpleAlias plugin)
    {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
        if(!(player instanceof Player))
        {
            Bukkit.getConsoleSender().sendMessage("No puedes enviar un comando por consola");
            return false;
        }
        else
        {
            Player jugador = (Player) player;
            jugador.sendMessage(ChatColor.RED + " para contactar al creado escribele a su discord");
            jugador.sendMessage(ChatColor.RED + " Discord : " + ChatColor.AQUA + " RubRub07#4475");
            return false;
        }
    }

}
