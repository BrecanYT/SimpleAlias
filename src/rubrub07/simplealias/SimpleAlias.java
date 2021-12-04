package rubrub07.simplealias;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import rubrub07.simplealias.commands.sahelp;
import rubrub07.simplealias.commands.sareload;
import rubrub07.simplealias.eventos.OnCommand;

public class SimpleAlias extends JavaPlugin {
	PluginDescriptionFile pdffile = getDescription();
	public String rutaconf;
	public String version = pdffile.getVersion();
	public String name = ChatColor.AQUA + "["+pdffile.getName()+"]";
	
	public void onEnable()
	{
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.BLUE + " Plugin encendido (version: " + version + " )");
		registrarCommandos();
		registrarEventos();
		registrarConfig();s
	}
	
	public void onDisable()
	{
		Bukkit.getConsoleSender().sendMessage(name + ChatColor.BLUE + " Plugin desactivado (version: " + version + " )");
	}
	
	public void registrarCommandos()
	{
		this.getCommand("sahelp").setExecutor(new sahelp(this));
		this.getCommand("sareload").setExecutor(new sareload(this));
	}
	
	public void registrarEventos()
	{
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new OnCommand(this), this);
	}
	
	public void registrarConfig()
	{
		File config = new File(this.getDataFolder(),"config.yml");
		rutaconf = config.getPath();
		if(!config.exists())
		{
			this.getConfig().options().copyDefaults(true);
			saveConfig();
		}
	}
	
}
