package rubrub07.simplealias.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rubrub07.simplealias.SimpleAlias;

public class sahelp implements CommandExecutor{
	
	private SimpleAlias plugin;
	
	public sahelp(SimpleAlias plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
		if(!(player instanceof Player))
		{
			Bukkit.getConsoleSender().sendMessage(plugin.name + ChatColor.BLUE + "No puedes enviar un comando por consola");
			return false;
		}
		else
		{
			Player jugador = (Player) player;
			jugador.sendMessage(plugin.name + ChatColor.RED + " para contactar al creado escribele a su discord");
			jugador.sendMessage(plugin.name + ChatColor.RED + " Discord : " + ChatColor.AQUA + " RubRub07#4475");
			return false;
		}
	}

}
