package net.kayega.gui;

import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

public abstract class VInventory extends InventoryView {

    Inventory inventory;
    HumanEntity player;
    InventoryType inventoryType;
    String inventoryTitle;

    public VInventory(String title, InventoryType type, VInventorySize size) {
        this.player = null;
        this.inventoryTitle = title;
        this.inventoryType = type;
        int iSize = 1;
        if (size == VInventorySize.Small) { iSize = 27; }
        else if (size == VInventorySize.Medium) { iSize = 45; }
        else if (size == VInventorySize.Big) { iSize = 54; }
        this.inventory = Bukkit.createInventory(null, iSize, this.inventoryTitle);
    }

    @Override
    public Inventory getTopInventory() {
        return this.inventory;
    }

    @Override
    public Inventory getBottomInventory() {
        return this.player.getInventory();
    }

    @Override
    public HumanEntity getPlayer() {
        return this.player;
    }

    @Override
    public InventoryType getType() {
        return this.inventoryType;
    }

    @Override
    public String getTitle() {
        return this.inventoryTitle;
    }

    public static void openInventory(Player player, VInventory inventory) {
        player.openInventory(inventory.getTopInventory());
    }
}
