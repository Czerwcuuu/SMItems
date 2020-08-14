package smitems.events;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import smitems.util.LogToFile;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckCreativeEvent implements Listener {
    @EventHandler
    public void CheckEQ(InventoryCreativeEvent e){
        Material item = e.getCursor().getType();
        int ilosc = e.getCursor().getAmount();
        String itemname = item.toString();
        String name = e.getWhoClicked().getName();
        Date now = new Date();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        if(item != Material.AIR) {
            LogToFile log = new LogToFile();
            String sum =  "[" + format.format(now) + "]" + name + " ruszał przedmiot " + itemname + " w ilosci "+ilosc+" z CREATIVE";
            log.logToFile(sum);
        }
    }
}
