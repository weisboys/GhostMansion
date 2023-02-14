/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package me.weisboys.ghostmansion;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author weisb
 */
public class ArenaManager {
    
    private List<Arena> arenaList = new ArrayList<>();
    
    public List<Arena> getList(){
        return arenaList;
    }
    
    public void addArena(Arena arena){
        arenaList.add(arena);
    }
}
