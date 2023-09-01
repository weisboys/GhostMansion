package me.weisboys.ghostmansion.commands;

import me.weisboys.ghostmansion.Arena;
import me.weisboys.ghostmansion.ArenaManager;
import me.weisboys.ghostmansion.GhostMansion;
import org.bukkit.command.CommandSender;

/**
 *
 * @author weisb
 */
public class CreateArenaCommand implements GMCommand {
    private final GhostMansion plugin;
    private final ArenaManager arenaManager;
    public CreateArenaCommand(GhostMansion plugin) {
        this.plugin = plugin;
        this.arenaManager = plugin.getArenaManager();
    }

    public void handleCommand(CommandSender sender, String[] args) {
        if (args.length == 1) {
            sender.sendMessage("Invalid command. Usage: /ghostmansion createarena <name>");
            return;
        }
        String name = args[1];
        if (arenaManager.hasArena(name)) {
            sender.sendMessage("An arena with that name already exists");
            return;
        }
        Arena arena = new Arena(name);
        arenaManager.addArena(arena);
        sender.sendMessage("Successfully added arena " + name);
    }

}
