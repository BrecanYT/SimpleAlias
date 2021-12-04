package com.brecanyt.plugin.events;

import com.brecanyt.plugin.SimpleAlias;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.Objects;

public class CommandListener implements Listener {

    private SimpleAlias plugin;

    public CommandListener(SimpleAlias plugin)
    {
        this.plugin = plugin;
    }

    @EventHandler
    public void command (PlayerCommandPreprocessEvent event)
    {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Player jugador = event.getPlayer();
        FileConfiguration conf = plugin.getConfig();
        String commandmessage = event.getMessage().toString().toLowerCase();
        ConfigurationSection sec = conf.getConfigurationSection("config.aliass.");

        for(String key : sec.getKeys(false)){
            String name = conf.getString("config.aliass." + key + ".command");
            if(Objects.equals(conf.getString("config.aliass." + key + ".permission"), "none"))
            { }
            else
            {
                if(jugador.hasPermission(conf.getString("config.aliass." + key + ".permission")))
                {}
                else
                {
                    return;
                }
            }
            String alias = conf.getString("config.aliass." + key + ".alias");
            if(commandmessage.contains(name))
            {
                event.setCancelled(true);
                if(Objects.equals(conf.getString("config.aliass." + key + ".console"), "true"))
                {
                    if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                        if(PlaceholderAPI.containsPlaceholders(alias))
                        {
                            String alias2 = PlaceholderAPI.setPlaceholders(jugador, alias);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".usealias"), "true"))
                            {
                                Bukkit.dispatchCommand(console, alias2);
                            }


                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));

                                if(conf.getString("config.aliass." + key + ".sendmessagetoplayer") ==  "true")
                                {

                                    jugador.sendMessage(messagep);
                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);

                                }
                            }

                        }
                        else
                        {
                            if(conf.getString("config.aliass." + key + ".usealias") ==  "true")
                            {
                                Bukkit.dispatchCommand(console, alias);
                            }
                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {
                                String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));
                                if(conf.getString("config.aliass." + key + ".sendmessagetoplayer") ==  "true")
                                {

                                    jugador.sendMessage(messagep);


                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);

                                }
                            }
                        }
                    }
                    else
                    {
                        if(conf.getString("config.aliass." + key + ".usealias") ==  "true")
                        {
                            Bukkit.dispatchCommand(console, alias);
                        }
                        for (String line : conf.getStringList("config.aliass." + key + ".message"))
                        {
                            String messagep = ChatColor.translateAlternateColorCodes('&', line);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                            {

                                jugador.sendMessage(messagep);

                            }
                            if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                            {

                                Bukkit.broadcastMessage(messagep);

                            }
                        }}
                }
                else if(Objects.equals(conf.getString("config.aliass." + key + ".console"), "false"))
                {
                    if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                        if(PlaceholderAPI.containsPlaceholders(alias))
                        {
                            String alias3 = PlaceholderAPI.setPlaceholders(jugador, alias);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".usealias"), "true"))
                            {
                                jugador.performCommand(alias3);
                            }
                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {
                                String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));
                                if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                                {

                                    jugador.sendMessage(messagep);
                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);
                                }}
                        }
                        else
                        {
                            if(Objects.equals(conf.getString("config.aliass." + key + ".usealias"), "true"))
                            {
                                jugador.performCommand(alias);
                            }
                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));
                                if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                                {

                                    jugador.sendMessage(messagep);

                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);

                                }
                            }
                        }
                    }
                    else
                    {
                        if(Objects.equals(conf.getString("config.aliass." + key + ".usealias"), "true"))
                        {
                            jugador.performCommand(alias);
                        }
                        for (String line : conf.getStringList("config.aliass." + key + ".message"))
                        {
                            String messagep = ChatColor.translateAlternateColorCodes('&', line);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                            {

                                jugador.sendMessage(messagep);
                            }
                            if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                            {

                                Bukkit.broadcastMessage(messagep);
                            }}
                    }
                }
            }
        }
    }
}

