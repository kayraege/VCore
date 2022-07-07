# VCore

## Command Create
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
## Command Register
```java
@Override
public void onEnable() {
    Bukkit.getServer().getPluginManager().registerEvents(this, this);
    Bukkit.getServer().getConsoleSender().sendMessage("§6[§2VCore§6] §aVCore is activated!");

    VCommand.registerCommand(this, new TestCommand(this));
}
```
