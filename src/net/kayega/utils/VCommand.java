package net.kayega.utils;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class VCommand implements CommandExecutor {
    private String commandName;
    private boolean isPlayerCommand;
    private JavaPlugin plugin;

    public VCommand(String commandName, boolean isPlayerCommand, JavaPlugin plugin) {
        this.commandName = commandName;
        this.isPlayerCommand = isPlayerCommand;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (this.isPlayerCommand()) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (command.getName().equalsIgnoreCase(this.getCommandName())) {
                    run(player, this.getPlugin());
                }
            } else {
                commandSender.sendMessage("This command usable only player!");
            }
        } else {
            if (command.getName().equalsIgnoreCase(this.getCommandName())) {
                run((Player) commandSender, this.getPlugin());
            }
        }
        return true;
    }

    public String getCommandName() { return this.commandName; }
    public boolean isPlayerCommand() { return this.isPlayerCommand; }
    public JavaPlugin getPlugin() { return this.plugin; }

    public void run(Player player, JavaPlugin plugin) { }

    public static void registerCommand(JavaPlugin plugin, VCommand command) {
        plugin.getCommand(command.getCommandName()).setExecutor(command);
    }
}
