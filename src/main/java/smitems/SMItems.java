package smitems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import smitems.events.SpawnerPlaceEvent;
import smitems.util.ChaosSwordUtil;
import smitems.util.GunpowderUtil;
import smitems.util.SpawnerUtil;
import smitems.util.VillagerEggUtil;

import java.util.logging.Logger;

public final class SMItems extends JavaPlugin {

    private final Logger logger = Logger.getLogger("SMItems");

    //private static Config config;

    private static SMItems plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        GunpowderUtil.registerGunpowderRecipe();
        ChaosSwordUtil.registerChaosSwordRecipe();
        SpawnerUtil.registerSpawnerRecipe();
        Bukkit.getPluginManager().registerEvents(new SpawnerPlaceEvent(),this);
        //VillagerEggUtil.registerVillagerEggRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        GunpowderUtil.unregisterGunpowderRecipe();
        ChaosSwordUtil.unregisterChaosSwordRecipe();
        SpawnerUtil.unregisterSpawnerRecipe();
        //VillagerEggUtil.unregisterVillagerEggRecipe();
    }

    public Logger getLogger(){
        return logger;
    }

    public static SMItems getInstance(){
        return plugin;
    }

}
