# VCore
> VCore, sadece **Kayega** adlı kişilerin yaptığı pluginlerde kullanılmaktadır!
> VCore, plugini daha basitleştirerek kolay ve kısa sürede yapılmasınız sağlar.

### Command Create
```java
package net.kayega;

import net.kayega.utils.VCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class TestCommand extends VCommand {
    public TestCommand(JavaPlugin plugin) {
        super("test", true, plugin);
    }

    @Override
    public void run(Player player, JavaPlugin plugin) {
        // TODO: Command
    }
}
```
```java
...

// PLUGIN MAIN
@Override
public void onEnable() {
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Bukkit.getServer().getConsoleSender().sendMessage("§6[§2VCore§6] §aVCore is activated!");

    VCommand.registerCommand(this, new TestCommand(this));
}
...
```
### Custom Config
```java
package net.kayega;

import net.kayega.utils.VConfig;
import org.bukkit.plugin.java.JavaPlugin;

public class TestConfig extends VConfig {
    public TestConfig(JavaPlugin plugin) {
        super(plugin, "test");
    }
}
```
```java
...

// PLUGIN MAIN
TestConfig config;

@Override
public void onEnable() {
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Bukkit.getServer().getConsoleSender().sendMessage("§6[§2VCore§6] §aVCore is activated!");

    config = new TestConfig(this);
}
...
```
### Particle Effects
```java
...
VParticle.sendParticle(player, player.getLocation(), Particle.HEART, 25, 10);
...
```
### Title API
```java
VTitle.sendMessage(player, PacketPlayOutTitle.EnumTitleAction.TITLE, "§bVCore", 1, 2, 1);
VTitle.sendMessage(player, PacketPlayOutTitle.EnumTitleAction.ACTIONBAR, "§bVCore", 1, 2, 1);
```
### Inventory GUI
> Inventory Sizes: VInventorySize.Big, VInventorySize.Medium, VInventorySize.Small
```java
package net.kayega;

import net.kayega.gui.VInventory;
import net.kayega.gui.VInventorySize;
import org.bukkit.event.inventory.InventoryType;

public class TestInventory extends VInventory {
    public TestInventory() {
        super("§bVCore", InventoryType.PLAYER, VInventorySize.Big);
    }
}
```
