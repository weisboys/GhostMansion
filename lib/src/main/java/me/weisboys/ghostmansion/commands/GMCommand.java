
package me.weisboys.ghostmansion.commands;

import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

/**
 *
 * @author weisb
 */
public class GMCommand implements TabExecutor{

    private CreateArenaCommand createArena = new CreateArenaCommand();
    
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 0){
            return false;
        }
        
        if (args[0].equalsIgnoreCase("createArena") ){
            createArena.createArena(sender, args);
            return true;
        }
        
        return false;
    }
    
    @Override
    public List<String> onTabComplete(CommandSender cs, Command cmnd, String string, String[] strings) {
        
    }

    
    
}
