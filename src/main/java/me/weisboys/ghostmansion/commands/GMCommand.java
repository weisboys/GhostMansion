package me.weisboys.ghostmansion.commands;

import org.bukkit.command.CommandSender;

public interface GMCommand {
    public void handleCommand(CommandSender sender, String[] args);
}
