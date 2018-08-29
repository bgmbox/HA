package com.braeh.HA;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class HideADMain extends JavaPlugin implements Listener {

    public void onEnable()
    {
        PluginDescriptionFile plugin = getDescription();
        Bukkit.getConsoleSender().sendMessage("\u00A7e-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getConsoleSender().sendMessage("\u00A7aHA has been enabled!");
        Bukkit.getConsoleSender().sendMessage("\u00A73Version: " + plugin.getVersion());
        Bukkit.getConsoleSender().sendMessage("\u00A7e-=-=-=-=-=-=-=-=-=-=-=-=-");

        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable()
    {
        PluginDescriptionFile plugin = getDescription();
        Bukkit.getConsoleSender().sendMessage("\u00A7e-=-=-=-=-=-=-=-=-=-=-=-=-");
        Bukkit.getConsoleSender().sendMessage("\u00A7aHA has been disabled!");
        Bukkit.getConsoleSender().sendMessage("\u00A73Version: " + plugin.getVersion());
        Bukkit.getConsoleSender().sendMessage("\u00A7e-=-=-=-=-=-=-=-=-=-=-=-=-");
    }
    private void hide(World world) { world.setGameRuleValue("announceAdvancements", "false"); }

    @EventHandler(priority=EventPriority.MONITOR)
    public void onWorldLoad(WorldLoadEvent event)
    {
        hide(event.getWorld());
    }
}
