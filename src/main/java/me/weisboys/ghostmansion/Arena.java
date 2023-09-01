
package me.weisboys.ghostmansion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.util.BoundingBox;

/**
 *
 * @author weisb
 */
public class Arena implements ConfigurationSerializable {

    private String name;
    private BoundingBox border;
    private Location ghostSpawn;
    private List<Location> hunterSpawns;

    public Arena(String name){
        this.name = name;
    }

    // Deserialization constructor
    public Arena(Map<String,Object> serialized) {
        this.name = (String) serialized.get("name");
        this.border = (BoundingBox) serialized.get("border");
        this.ghostSpawn = (Location) serialized.get("ghostSpawn");
        this.hunterSpawns = (List<Location>) serialized.get("hunterSpawns");
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String,Object> map = new HashMap<>();
        map.put("name", name);
        map.put("border", border);
        map.put("ghostSpawn", ghostSpawn);
        map.put("hunterSpawns", hunterSpawns);
        return map;
    }

    public String getName() {
        return name;
    }

    public BoundingBox getBorder() {
        return border;
    }

    public Location getGhostSpawn() {
        return ghostSpawn;
    }

    public List<Location> getHunterSpawns() {
        return hunterSpawns;
    }
}
