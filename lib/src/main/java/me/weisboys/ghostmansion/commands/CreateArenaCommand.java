package me.weisboys.ghostmansion.commands;

import me.weisboys.ghostmansion.Arena;
import org.bukkit.command.CommandSender;

/**
 *
 * @author weisb
 */
public class CreateArenaCommand {
    
    public void createArena (CommandSender sender, String[] args){
        if (args.length == 1){
            sender.sendMessage("Invalid command. Usage: /ghostmansion createarena <name>");
            return;
        }
        String name = args[1]; 
        Arena arena = new Arena(name);
        sender.sendMessage("Succesfully added arena " + name);
        
    }
    
}
