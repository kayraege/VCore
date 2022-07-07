package net.kayega.gamefeature;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public abstract class VFeature {
    private String featureName;
    private JavaPlugin plugin;
    private boolean isEnable;
    private int scheduler;

    public VFeature(JavaPlugin plugin, String featureName) {
        setPlugin(plugin);
        setFeatureName(featureName);
    }

    public void onEnable() {
        if (plugin == null) { return; }

        System.out.println("[VermellClaim] " + getFeatureName() + " begin activated!");
        if (!isEnabled()) {
            isEnable = true;
            System.out.println("[VermellClaim] " + getFeatureName() + " activated!");
        } else {
            System.out.println("[VermellClaim] " + getFeatureName() + " already activated!");
        }
    }
    public void onDisable() {
        System.out.println("[VermellClaim] " + getFeatureName() + " shutting down!");
        if (!isEnabled()) {
            System.out.println("[VermellClaim] " + getFeatureName() + " is closed!");
        }
    }

    public static void RunAll(List<VFeature> featureList)
    {
        if (featureList.size() <= 0) { return; }
        for (VFeature feature : featureList) {
            feature.setEnabled(true);
        }
    }
    public static void StopAll(List<VFeature> featureList)
    {
        if (featureList.size() <= 0) { return; }
        for (VFeature feature : featureList) {
            feature.setEnabled(false);
        }
    }
    public final void setPlugin(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    public final JavaPlugin getPlugin() { return this.plugin; }
    public final void setFeatureName(String featureName) {
        this.featureName = featureName;
    }
    public final String getFeatureName() { return this.featureName; }
    public final void setScheduler(int scheduler) {
        this.scheduler = scheduler;
    }
    public final int getScheduler() { return this.scheduler; }
    public final void setEnabled(boolean isEnable) {
        this.isEnable = isEnable;
        if (isEnabled()) {
            onEnable();
        } else {
            onDisable();
        }
    }
    public final boolean isEnabled() { return this.isEnable; }
    public static boolean isContains(String featureName, List<VFeature> featureList) {
        for (VFeature feature : featureList) {
            if (feature.getFeatureName().equalsIgnoreCase(featureName)) {
                return true;
            }
        }
        return false;
    }
    public static VFeature getFeature(String featureName, List<VFeature> featureList) {
        for (VFeature feature : featureList) {
            if (feature.getFeatureName().equalsIgnoreCase(featureName)) {
                return feature;
            }
        }
        return null;
    }
}
