package smitems;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import smitems.events.CheckCreativeEvent;
import smitems.events.SpawnerPlaceEvent;
import smitems.util.*;

import java.util.logging.Logger;

public final class SMItems extends JavaPlugin {

    private static SMItems plugin;

    //private static Config config;
    private final Logger logger = Logger.getLogger("SMItems");

    public static SMItems getInstance() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        GunpowderUtil.registerGunpowderRecipe();
        ExperienceBottleUtil.registerEbRecipe();
        SpawnerUtil.registerSpawnerRecipe();
        BeaconCraftingUtil.registerBeaconRecipe();
        Bukkit.getPluginManager().registerEvents(new SpawnerPlaceEvent(), this);
        Bukkit.getPluginManager().registerEvents(new CheckCreativeEvent(), this);

        //VillagerEggUtil.registerVillagerEggRecipe();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        GunpowderUtil.unregisterGunpowderRecipe();
        ExperienceBottleUtil.unregisterEbRecipe();
        ChaosSwordUtil.unregisterChaosSwordRecipe();
        SpawnerUtil.unregisterSpawnerRecipe();
        BeaconCraftingUtil.unregisterBeaconRecipe();
        //VillagerEggUtil.unregisterVillagerEggRecipe();
    }

    public Logger getLogger() {
        return logger;
    }

}
