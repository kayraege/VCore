package net.kayega.utils.configs;

import net.kayega.utils.VConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class VPlayerBalancesConfig extends VConfig {
    public VPlayerBalancesConfig(JavaPlugin plugin) {
        super(plugin, "data/playerBalancesData");
    }
}
