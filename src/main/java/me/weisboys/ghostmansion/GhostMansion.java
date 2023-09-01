package me.weisboys.ghostmansion;

import me.weisboys.ghostmansion.commands.GMCommandExecutor;
import org.bukkit.configuration.serialization.ConfigurationSerialization;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author weisb
 */

public class GhostMansion extends JavaPlugin {
    private ArenaManager arenaManager;
    @Override
    public void onEnable() {
        ConfigurationSerialization.registerClass(Arena.class);
        saveDefaultConfig();
        this.arenaManager = new ArenaManager(this);
        getCommand("ghostmansion").setExecutor(new GMCommandExecutor(this));
    }

    public ArenaManager getArenaManager(){
        return arenaManager;
    }
}
