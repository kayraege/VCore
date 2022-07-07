package net.kayega.gamefeature.example;

import net.kayega.gamefeature.VFeature;
import net.minecraft.server.v1_16_R3.PacketPlayOutWorldParticles;
import net.minecraft.server.v1_16_R3.ParticleParam;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftParticle;
import org.bukkit.craftbukkit.v1_16_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class VHeadTopHeart extends VFeature {
    public VHeadTopHeart(JavaPlugin plugin, String featureName) {
        super(plugin, featureName);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        int s = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this.getPlugin(), new Runnable(){
            private Random r = new Random();

            public void run(){
                Color c = Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255));

                for(Player player : Bukkit.getServer().getOnlinePlayers()){
                    Location location = player.getLocation();

                    ParticleParam particleParam = CraftParticle.toNMS(org.bukkit.Particle.valueOf("HEART"));
                    PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(particleParam, false,
                            location.getX(), location.getY() + 2, location.getZ(), 0, 0, 0, 25, 1);

                    ((CraftPlayer) player).getHandle().playerConnection.sendPacket(packet);
                }
            }
        }, 0l, 5l);
        this.setScheduler(s);
    }

    @Override
    public void onDisable() {
        super.onDisable();

        Bukkit.getServer().getScheduler().cancelTask(this.getScheduler());
    }
}
