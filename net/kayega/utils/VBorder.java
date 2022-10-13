package net.kayega.utils;

import com.github.yannicklamprecht.worldborder.api.BorderAPI;
import com.github.yannicklamprecht.worldborder.api.WorldBorderApi;
import net.kayega.VCore;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class VBorder extends VCore {
    static WorldBorderApi worldBorderApi = BorderAPI.getApi();

    public VBorder() {
        worldBorderApi = BorderAPI.getApi();
        Bukkit.getServer().getConsoleSender().sendMessage("§6[§2VCore§6] §aVCore World Border API is activated!");
    }

    public static void setWorldBorder(Player player, double size) {
        worldBorderApi = BorderAPI.getApi();
        worldBorderApi.setBorder(player, size);
    }

    public static void setWorldBorder(Player player, double size, Location loc) {
        worldBorderApi = BorderAPI.getApi();
        worldBorderApi.setBorder(player, size, loc);
    }

    public static void resetWorldBorderToGlobal(Player player) {
        worldBorderApi = BorderAPI.getApi();
        worldBorderApi.resetWorldBorderToGlobal(player);
    }
}
