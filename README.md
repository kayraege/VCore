# VCore

## Usage (Commands)
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

    }
}
```
