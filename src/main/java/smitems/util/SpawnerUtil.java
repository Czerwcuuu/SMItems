package smitems.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import smitems.SMItems;

import java.util.Collections;

public class SpawnerUtil {
    public static final NamespacedKey SPAWNER = new NamespacedKey(SMItems.getInstance(), "spawner");

    private SpawnerUtil() {
    }

    public static ItemStack createSpawner() {
        ItemStack spawner = new ItemStack(Material.SPAWNER);

        ItemMeta meta = spawner.getItemMeta();

        meta.setDisplayName("Spawner Życia");
        meta.setLore(Collections.singletonList("Spawner ten pozwoli Ci przezyc!"));
        spawner.setItemMeta(meta);


        return spawner;
    }

    public static boolean registerSpawnerRecipe() {
        ItemStack spawner_ = SpawnerUtil.createSpawner();

        ShapedRecipe spwn = new ShapedRecipe(SPAWNER, spawner_);

        spwn.shape("DGD", "DCD", "DGD");

        spwn.setIngredient('G', Material.CRYING_OBSIDIAN);
        spwn.setIngredient('C', Material.BEACON);
        spwn.setIngredient('D', Material.NETHERITE_INGOT);

        boolean success = Bukkit.addRecipe(spwn);
        if (success)
            SMItems.getInstance().getLogger().fine("Dodany przepis na " + SPAWNER.getNamespace() + ":" + SPAWNER.getKey());
        else
            SMItems.getInstance().getLogger().fine("NIEPOMYSLNE dodanie przepisu na: " + SPAWNER.getNamespace() + ":" + SPAWNER.getKey());

        return success;
    }

    public static boolean unregisterSpawnerRecipe() {
        boolean success = Bukkit.removeRecipe(SPAWNER);

        if (success)
            SMItems.getInstance().getLogger().fine("Usunieto przepis na:" + SPAWNER.getNamespace() + ":" + SPAWNER.getKey());

        else
            SMItems.getInstance().getLogger().fine("Nie udalo sie usunac przepisu na: " + SPAWNER.getNamespace() + ":" + SPAWNER.getKey());

        return success;
    }
}
