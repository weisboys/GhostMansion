
package me.weisboys.ghostmansion;

import java.util.List;
import org.bukkit.Location;
import org.bukkit.util.BoundingBox;

/**
 *
 * @author weisb
 */
public class Arena {
    
    private String name;
    private BoundingBox border;
    private Location ghostSpawn;
    private List<Location> hunterSpawns;
    
    public Arena(String name){
        this.name = name;
    }
}
