package net.kayega.utils;

import net.kayega.utils.configs.VPlayerBalancesConfig;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public class VBalance {

    FileConfiguration config;
    VPlayer player;

    public VBalance(VPlayer player, JavaPlugin plugin) {
        this.player = player;
        config = new VPlayerBalancesConfig(plugin).get();
    }

    public long getBalance() {
        if (!isContains(player)) {
            createPlayer();
            return getBalance();
        }

        return config.getLong("players." + player.getUUID() + ".balance");
    }

    public boolean isContains(VPlayer player) {
        return config.isString("players." + player.getUUID());
    }

    public void createPlayer() {
        if (isContains(player)) { return; }

        config.set("players." + player.getUUID() + ".balance", 0);
    }
}
