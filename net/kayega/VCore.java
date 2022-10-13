package net.kayega;

import net.kayega.utils.VLisance;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class VCore extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        Bukkit.getServer().getConsoleSender().sendMessage("§6[§2VCore§6] §aVCore is activated!");

        new VLisance("asd");
    }
}
