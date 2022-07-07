package net.kayega.gamefeature.example;

import net.kayega.gamefeature.VFeature;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Random;

public class VRainbowLeatherSet extends VFeature {
    public VRainbowLeatherSet(JavaPlugin plugin, String featureName) {
        super(plugin, featureName);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        int s = Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this.getPlugin(), new Runnable(){
            private Random r = new Random();

            public void run(){
                Color c = Color.fromRGB(r.nextInt(255), r.nextInt(255), r.nextInt(255));

                for(Player p : Bukkit.getServer().getOnlinePlayers()){
                    if (p.isOp()) {
                        if (p.getInventory().getHelmet() != null && p.getInventory().getHelmet().getType() == Material.LEATHER_HELMET) {
                            p.getInventory().setHelmet(getColorArmor(Material.LEATHER_HELMET, c));
                        }

                        if (p.getInventory().getChestplate() != null && p.getInventory().getChestplate().getType() == Material.LEATHER_CHESTPLATE) {
                            p.getInventory().setChestplate(getColorArmor(Material.LEATHER_CHESTPLATE, c));
                        }

                        if (p.getInventory().getLeggings() != null && p.getInventory().getLeggings().getType() == Material.LEATHER_LEGGINGS) {
                            p.getInventory().setLeggings(getColorArmor(Material.LEATHER_LEGGINGS, c));
                        }

                        if (p.getInventory().getBoots() != null && p.getInventory().getBoots().getType() == Material.LEATHER_BOOTS) {
                            p.getInventory().setBoots(getColorArmor(Material.LEATHER_BOOTS, c));
                        }
                    }
                }
            }
        }, 0l, 10l);
        this.setScheduler(s);
    }

    @Override
    public void onDisable() {
        super.onDisable();

        Bukkit.getServer().getScheduler().cancelTask(this.getScheduler());
    }

    private ItemStack getColorArmor(Material m, Color c) {
        ItemStack i = new ItemStack(m, 1);
        LeatherArmorMeta meta = (LeatherArmorMeta) i.getItemMeta();
        meta.setColor(c);
        i.setItemMeta(meta);
        return i;
    }
}
