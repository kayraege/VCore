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
### Command Register
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
