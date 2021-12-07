package rubrub07.simplealias.eventos;

import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import de.tr7zw.nbtapi.NBTItem;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;
import rubrub07.simplealias.SimpleAlias;

public class OnUse implements Listener{

    private SimpleAlias plugin;

    public OnUse(SimpleAlias plugin)
    {
        this.plugin = plugin;
    }
    
    @SuppressWarnings("deprecation")
	public void useitem(PlayerInteractEvent event)
    {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        Player jugador = event.getPlayer();
        FileConfiguration conf = plugin.getConfig();
        ConfigurationSection sec = conf.getConfigurationSection("config.aliass.");
		org.bukkit.inventory.ItemStack item = jugador.getItemInHand();
		NBTItem nbt = new NBTItem(item);

        for(String key : sec.getKeys(false)){
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
           
            if(ChatColor.translateAlternateColorCodes('&', nbt.getName()).equals(ChatColor.translateAlternateColorCodes('&', conf.getString("config.aliass." + key + ".itemname"))))
            {
            	if(Objects.equals(conf.getString("config.aliass." + key + ".console"), "true"))
                {
                    if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
                        if(PlaceholderAPI.containsPlaceholders(alias))
                        {
                            String alias2 = PlaceholderAPI.setPlaceholders(jugador, alias);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".usealias"), "true"))
                            {
                                Bukkit.dispatchCommand(console, alias2);
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);
                            }


                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));

                                if(conf.getString("config.aliass." + key + ".sendmessagetoplayer") ==  "true")
                                {
                                    jugador.sendMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);
                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);

                                }
                            }

                        }
                        else
                        {
                            if(conf.getString("config.aliass." + key + ".usealias") ==  "true")
                            {
                                Bukkit.dispatchCommand(console, alias);
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);
                            }
                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {
                                String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));
                                if(conf.getString("config.aliass." + key + ".sendmessagetoplayer") ==  "true")
                                {

                                    jugador.sendMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);


                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);

                                }
                            }
                        }
                    }
                    else
                    {
                        if(conf.getString("config.aliass." + key + ".usealias") ==  "true")
                        {
                            Bukkit.dispatchCommand(console, alias);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                            	jugador.getItemInHand().setAmount(0);
                        }
                        for (String line : conf.getStringList("config.aliass." + key + ".message"))
                        {
                            String messagep = ChatColor.translateAlternateColorCodes('&', line);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                            {

                                jugador.sendMessage(messagep);
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);

                            }
                            if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                            {

                                Bukkit.broadcastMessage(messagep);
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);

                            }
                        }}
                    break;
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
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);
                            }
                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {
                                String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));
                                if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                                {

                                    jugador.sendMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);
                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);
                                }}
                        }
                        else
                        {
                            if(Objects.equals(conf.getString("config.aliass." + key + ".usealias"), "true"))
                            {
                                jugador.performCommand(alias);
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);
                            }
                            for (String line : conf.getStringList("config.aliass." + key + ".message"))
                            {String messagep = ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(jugador, line));
                                if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                                {

                                    jugador.sendMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);

                                }
                                if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                                {

                                    Bukkit.broadcastMessage(messagep);
                                    if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                    	jugador.getItemInHand().setAmount(0);

                                }
                            }
                        }
                    }
                    else
                    {
                        if(Objects.equals(conf.getString("config.aliass." + key + ".usealias"), "true"))
                        {
                            jugador.performCommand(alias);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                            	jugador.getItemInHand().setAmount(0);
                        }
                        for (String line : conf.getStringList("config.aliass." + key + ".message"))
                        {
                            String messagep = ChatColor.translateAlternateColorCodes('&', line);
                            if(Objects.equals(conf.getString("config.aliass." + key + ".sendmessagetoplayer"), "true"))
                            {

                                jugador.sendMessage(messagep);
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);
                            }
                            if(Objects.equals(conf.getString("config.aliass." + key + ".broadcast"), "true"))
                            {

                                Bukkit.broadcastMessage(messagep);
                                if(Objects.equals(conf.getString("config.aliass." + key + ".consume"), "true"))
                                	jugador.getItemInHand().setAmount(0);
                            }}
                    }
                    break;
                }
            }
            else
            {}
        }
    	
    }
	
}
