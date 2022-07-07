package net.kayega.utils;

import net.minecraft.server.v1_16_R3.IChatBaseComponent;
import net.minecraft.server.v1_16_R3.Packet;
import net.minecraft.server.v1_16_R3.PacketPlayOutTitle;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class VTitle {

    /***
     * 1.16.X Title
     * @param player
     * @param type
     * @param title
     * @param fadeIn
     * @param displayTime
     * @param fadeOut
     */
    public static void sendMessage(Player player, PacketPlayOutTitle.EnumTitleAction type, String title, int fadeIn, int displayTime, int fadeOut) {
        PacketPlayOutTitle packet = new PacketPlayOutTitle(type, IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ title +"\"}"), fadeIn * 20, displayTime * 20, fadeOut * 20);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    /***
     * 1.16.X Title with subtitle
     * @param player
     * @param title
     * @param subtitle
     * @param fadeIn
     * @param displayTime
     * @param fadeOut
     */
    public static void sendMessageWithSubTitle(Player player, String title, String subtitle, int fadeIn, int displayTime, int fadeOut) {
        PacketPlayOutTitle packet = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.TITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ title +"\"}"), fadeIn * 20, displayTime * 20, fadeOut * 20);
        PacketPlayOutTitle packet1 = new PacketPlayOutTitle(PacketPlayOutTitle.EnumTitleAction.SUBTITLE, IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ subtitle +"\"}"), fadeIn * 20, displayTime * 20, fadeOut * 20);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet1);
    }

    /***
     * 1.8.X Title
     * @param player
     * @param type
     * @param title
     * @param fadeIn
     * @param displayTime
     * @param fadeOut
     */
    public static void sendMessage(Player player, net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction type, String title, int fadeIn, int displayTime, int fadeOut) {
        net.minecraft.server.v1_8_R3.PacketPlayOutTitle packet = new net.minecraft.server.v1_8_R3.PacketPlayOutTitle(type, net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ title +"\"}"), fadeIn * 20, displayTime * 20, fadeOut * 20);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket((Packet<?>) packet);
    }

    /***
     * 1.8.X Title
     * @param player
     * @param title
     * @param subtitle
     * @param fadeIn
     * @param displayTime
     * @param fadeOut
     */
    public static void sendMessageWithSub(Player player, String title, String subtitle, int fadeIn, int displayTime, int fadeOut) {
        net.minecraft.server.v1_8_R3.PacketPlayOutTitle packet = new net.minecraft.server.v1_8_R3.PacketPlayOutTitle(net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction.TITLE, net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ title +"\"}"), fadeIn * 20, displayTime * 20, fadeOut * 20);
        net.minecraft.server.v1_8_R3.PacketPlayOutTitle packet1 = new net.minecraft.server.v1_8_R3.PacketPlayOutTitle(net.minecraft.server.v1_8_R3.PacketPlayOutTitle.EnumTitleAction.SUBTITLE, net.minecraft.server.v1_8_R3.IChatBaseComponent.ChatSerializer.a("{\"text\":\""+ subtitle +"\"}"), fadeIn * 20, displayTime * 20, fadeOut * 20);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket((Packet<?>) packet);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket((Packet<?>) packet1);
    }
}
