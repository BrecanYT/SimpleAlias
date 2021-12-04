package com.brecanyt.plugin;

import com.brecanyt.plugin.commands.HelpCommand;
import com.brecanyt.plugin.commands.ReloadCommand;
import com.brecanyt.plugin.events.CommandListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.File;

public class SimpleAlias extends JavaPlugin {
    public String rutaconf;

    public void onEnable() {
        getLogger().info("SimpleAlias by BrecanYT has been enabled");
        commandRegister();
        eventRegister();
        registerConfig();
    }

    public void onDisable() {
        getLogger().info("Disabled SimpleAlias");
    }

    public void commandRegister() {
        this.getCommand("sahelp").setExecutor(new HelpCommand(this));
        this.getCommand("sareload").setExecutor(new ReloadCommand(this));
    }

    public void eventRegister() {
        getServer().getPluginManager().registerEvents(new CommandListener(this),this);
    }

    public void registerConfig() {
        File config = new File(this.getDataFolder(), "config.yml");
        rutaconf = config.getPath();
        if (!config.exists()) {
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}
