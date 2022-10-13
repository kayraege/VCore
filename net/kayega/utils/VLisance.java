package net.kayega.utils;

import net.kayega.VCore;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;

public class VLisance {
    public VLisance(String key) {
        try {
            VCore.getPlugin(VCore.class).getLogger().log(Level.INFO, InetAddress.getLocalHost().getHostAddress());
        } catch (UnknownHostException e) {
            VCore.getPlugin(VCore.class).getLogger().log(Level.INFO, e.getMessage());
        }
    }
}
