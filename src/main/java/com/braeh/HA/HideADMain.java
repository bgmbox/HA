package com.braeh.HA;

import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class HideADMain extends JavaPlugin implements Listener {

    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {}

    private void hide(World world) {
        world.setGameRuleValue("announceAdvancements", "false");
    }

    @EventHandler(priority=EventPriority.MONITOR)
    public void onWorldLoad(WorldLoadEvent event) {
        hide(event.getWorld());
    }
}
