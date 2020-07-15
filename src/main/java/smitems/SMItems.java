package smitems;

import org.bukkit.plugin.java.JavaPlugin;
import smitems.util.GunpowderUtil;

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
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        GunpowderUtil.unregisterGunpowderRecipe();
    }

    public Logger getLogger(){
        return logger;
    }

    public static SMItems getInstance(){
        return plugin;
    }

}
