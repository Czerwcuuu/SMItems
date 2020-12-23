package smitems.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;
import smitems.SMItems;

import java.util.ArrayList;

public class ComposterBlockEvent implements Listener {

    //Composter placing block
    @EventHandler
    public void ComposterPlaceEvent(BlockPlaceEvent e){

        Player p = e.getPlayer();
        if(p.isOp()) return;
        if(!p.hasPermission("sm.composter")) return;
        if(e.getBlock().getType() == Material.COMPOSTER || e.getBlock().getType() == Material.CAULDRON){
            p.sendMessage(ChatColor.RED+"Stawianie tego bloku, jest tymczasowo zablokowane, zgłoś się do Adminsitratora!");
            e.setCancelled(true);
        }


    }



}
