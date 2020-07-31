package smitems.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;

import javax.swing.text.html.parser.Entity;

public class SpawnerPlaceEvent implements Listener {

    @EventHandler
    public void onSpawnerPlace(BlockPlaceEvent e){
        Block b = e.getBlockPlaced();
        ItemStack inh = e.getPlayer().getItemInHand();
            if (b!=null && inh !=null){
                if(b.getType()== Material.SPAWNER && inh.getType() == Material.SPAWNER){
                    if(inh.getItemMeta().getDisplayName().equals("Spawner Życia")){
                        setSpawner(b, EntityType.COW);
                    }
                }
            }
        }


    public void setSpawner(Block block, EntityType ent) {
        BlockState blockState = block.getState();
        CreatureSpawner spawner = ((CreatureSpawner) blockState);
        spawner.setSpawnedType(ent);
        blockState.update();
    }
}

