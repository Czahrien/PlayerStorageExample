/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.czahrien.PlayerStorageExample;


import com.gmail.czahrien.PlayerStorage.PlayerStorageInstance;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author Czahrien
 */
public class PlayerStorageExample extends JavaPlugin implements Listener {
    
    private PlayerStorageInstance<Integer> ps;
    @Override
    public void onEnable() {
        ps = PlayerStorageInstance.getPlayerStorage("LoginCount");
        getServer().getPluginManager().registerEvents(this, this);
    }
    
    @EventHandler
    public void onPlayerConnect(PlayerJoinEvent e) {
        Integer i = ps.getPlayer(e.getPlayer());
        if(i == null) {
            getServer().broadcastMessage("Everybody welcome " + e.getPlayer().getDisplayName() + " to the server!");
            ps.setPlayer(e.getPlayer(), 1);
        } else {
            e.getPlayer().sendMessage("You have logged onto the server " + (i + 1) + " times!");
            ps.setPlayer(e.getPlayer(), i + 1);
        }
    }
}
