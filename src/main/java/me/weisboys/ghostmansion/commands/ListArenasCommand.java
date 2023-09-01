package me.weisboys.ghostmansion.commands;

import me.weisboys.ghostmansion.Arena;
import me.weisboys.ghostmansion.ArenaManager;
import me.weisboys.ghostmansion.GhostMansion;
import org.bukkit.command.CommandSender;

import java.util.List;
import java.util.Map;

public class ListArenasCommand implements GMCommand {
    private final GhostMansion plugin;
    private final ArenaManager arenaManager;
    public ListArenasCommand(GhostMansion plugin) {
        this.plugin = plugin;
        this.arenaManager = plugin.getArenaManager();
    }
    @Override
    public void handleCommand(CommandSender sender, String[] args) {
        Map<String, Arena> arenas = arenaManager.getArenas();
        if (arenas.isEmpty()) {
            sender.sendMessage("There are no arenas");
            return;
        }
        sender.sendMessage("Arenas:");
        for (String arena : arenas.keySet()) {
            sender.sendMessage("- " + arena);
        }
    }
}
