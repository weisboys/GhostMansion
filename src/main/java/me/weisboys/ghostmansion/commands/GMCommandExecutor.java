
package me.weisboys.ghostmansion.commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import me.weisboys.ghostmansion.GhostMansion;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.util.StringUtil;

/**
 *
 * @author weisb
 */
public class GMCommandExecutor implements TabExecutor{

    private final GhostMansion plugin;
    private final Map<String,GMCommand> commands = new HashMap<>();

    public GMCommandExecutor(GhostMansion plugin){
        this.plugin = plugin;
        commands.put("createArena", new CreateArenaCommand(plugin));
        commands.put("listArenas", new ListArenasCommand(plugin));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0) {
            return false;
        }

        for (Map.Entry<String,GMCommand> entry : commands.entrySet()) {
            if (entry.getKey().equalsIgnoreCase(args[0])) {
                entry.getValue().handleCommand(sender, args);
                return true;
            }
        }

        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            return StringUtil.copyPartialMatches(args[0], commands.keySet(), new ArrayList<>());
        }
        return List.of();
    }
}
