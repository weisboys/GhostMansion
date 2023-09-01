/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.weisboys.ghostmansion;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author weisb
 */
public class ArenaManager {
    private final YamlConfiguration arenasConfig = new YamlConfiguration();
    private final File arenasFile;
    public ArenaManager(GhostMansion plugin) {
        this.arenasFile = new File(plugin.getDataFolder(), "arenas.yml");
        if (arenasFile.exists()) {
            try {
                this.arenasConfig.load(arenasFile);
            } catch (IOException | InvalidConfigurationException e) {
                throw new RuntimeException(e);
            }
            for (String key : arenasConfig.getConfigurationSection("arenas").getKeys(false)) {
                Arena arena = (Arena) arenasConfig.get("arenas." + key);
                arenas.put(arena.getName(), arena);
            }
        }
    }

    private Map<String,Arena> arenas = new HashMap<>();

    public Map<String, Arena> getArenas() {
        return arenas;
    }

    public void addArena(Arena arena) {
        arenas.put(arena.getName(), arena);
        arenasConfig.set("arenas", arenas);
        save();
    }

    public boolean hasArena(String name) {
        return arenas.get(name) != null;
    }

    public void removeArena(String name) {
        arenas.remove(name);
        arenasConfig.set("arenas", arenas);
        save();
    }

    private void save() {
        try {
            arenasConfig.save(arenasFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
