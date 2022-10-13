package net.kayega.utils;

import net.minecraft.server.v1_16_R3.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_16_R3.ParticleParam;
import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.craftbukkit.v1_16_R3.CraftParticle;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class VParticle {

    /***
     * 1.18.X Particle Effect
     * @param player Referance Player
     * @param location Particle Spawn Location
     * @param particle Particle
     * @param speed Particle Speed
     * @param count Particle Count
     */
    public static void sendParticle2(Player player, Location location, Particle particle, float speed, int count) {
        ParticleParam particleParam = CraftParticle.toNMS(particle);
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particleParam, false,
                location.getX(), location.getY(), location.getZ(), 0, 0, 0, speed, count);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    /***
     * 1.16.X Particle Effect
     * @param player Referance Player
     * @param location Particle Spawn Location
     * @param particle Particle
     * @param speed Particle Speed
     * @param count Particle Count
     */
    public static void sendParticle(Player player, Location location, Particle particle, float speed, int count) {
        ParticleParam particleParam = CraftParticle.toNMS(particle);
        PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particleParam, false,
                location.getX(), location.getY(), location.getZ(), 0, 0, 0, speed, count);
        ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
    }

    /***
     * 1.8.X Particle Effect
     * @param player Referance Player
     * @param location Particle Spawn Location
     * @param particle Particle
     * @param speed Particle Speed
     * @param count Particle Count
     */
    public static void sendParticle(Player player, Location location, EnumParticle particle, float speed, int count) {
        net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles packet = new net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles(particle, true,
                (float) location.getX(), (float) location.getY(), (float) location.getZ(), 0, 0, 0, speed, count);
    }
}
