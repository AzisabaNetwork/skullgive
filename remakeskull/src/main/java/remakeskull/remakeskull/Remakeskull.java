package remakeskull.remakeskull;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public final class Remakeskull extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getCommand("skullgive").setExecutor(new Remakeskullcommand(this));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
