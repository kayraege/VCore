package net.kayega.utils;

import org.bukkit.entity.Player;

import java.util.UUID;

public class VPlayer {
    private UUID uuid;
    private long balance;

    public VPlayer(Player player) {
        setUUID(player.getUniqueId());
        setBalance(0);
    }

    public UUID getUUID() {
        return this.uuid;
    }
    public long getBalance() {
        return this.balance;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }
    public void setBalance(long balance) {
        this.balance = balance;
    }
    public void addBalance(long balance) {
        this.balance += balance;
    }
}
