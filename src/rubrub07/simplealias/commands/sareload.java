package rubrub07.simplealias.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import rubrub07.simplealias.SimpleAlias;

public class sareload implements CommandExecutor{
	
	private SimpleAlias plugin;
	
	public sareload(SimpleAlias plugin)
	{
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender player, Command cmd, String label, String[] args) {
	     if (!(player instanceof Player)) {
	         // If player is not an instanceof Player, then it's the console sending the command.
	         plugin.reloadConfig();;
	         plugin.saveConfig();
	         Bukkit.getLogger().info(plugin.name + ChatColor.AQUA + "Configuracion recargada");
	         // Returns true because the console can execute anything.
	         return true;
	         } else if (player.hasPermission("simplealias.reload")) {
	              // If it's not the console, then it's a player. Check their permission and execute if they have.
	              plugin.reloadConfig();
	              plugin.saveConfig();
	              player.sendMessage(plugin.name + ChatColor.AQUA + "Configuracion recargada");
	              System.out.println(plugin.name + "Configuracion recargada");
	              return true;
	              // Return true if this plugin executed this command.
	         } else {
	              return false;
	              // Returns false because the player didn't have permission, so it wasn't executed.
	         }
	}

}
