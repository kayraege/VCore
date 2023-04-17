package net.kayega.core.util;

import com.github.yannicklamprecht.worldborder.api.WorldBorderApi;
import net.kayega.core.VCore;
import org.bukkit.plugin.RegisteredServiceProvider;

public class VBorder {
    RegisteredServiceProvider<WorldBorderApi> worldBorderApiRegisteredServiceProvider;
    WorldBorderApi worldBorderApi;

    public VBorder(VCore plugin) {
        if (!VCore.isWorldBorderApiEnabled()) { return; }
        worldBorderApiRegisteredServiceProvider = plugin.getServer().getServicesManager().getRegistration(WorldBorderApi.class);
        if (worldBorderApiRegisteredServiceProvider == null) {
            plugin.getLogger().warning("WorldBorderAPI Not Found!");
            plugin.getServer().getPluginManager().disablePlugin(plugin);
            return;
        }

        worldBorderApi = worldBorderApiRegisteredServiceProvider.getProvider();
    }

    public WorldBorderApi getApi() {
        if (!VCore.isWorldBorderApiEnabled()) { return null; }
        return this.worldBorderApi;
    }
}
