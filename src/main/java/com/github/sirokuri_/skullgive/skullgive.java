package com.github.sirokuri_.skullgive;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class skullgive extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("skullgive").setExecutor(new skullgivecommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
