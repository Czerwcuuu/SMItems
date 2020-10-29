package smitems.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import smitems.SMItems;

public class GunpowderUtil {
    public static final NamespacedKey GUNPOWDER_KEY = new NamespacedKey(SMItems.getInstance(), "gunpowder");

    private GunpowderUtil() {
    }

    public static ItemStack createGunpowder() {
        ItemStack gunpowder = new ItemStack(Material.GUNPOWDER);

        ItemMeta meta = gunpowder.getItemMeta();

        meta.setDisplayName("Stylowy Gunpowder");

        gunpowder.setItemMeta(meta);

        return gunpowder;
    }

    public static boolean isGunpowder(ItemStack stack) {
        if (stack == null || stack.getType() != Material.GUNPOWDER || !stack.hasItemMeta() || !stack.getItemMeta().hasDisplayName())
            return false;

        else return stack.getItemMeta().getDisplayName().equals("Stylowy Gunpowder");
    }

    public static boolean registerGunpowderRecipe() {
        ItemStack gunpowder = GunpowderUtil.createGunpowder();

        ShapedRecipe gp = new ShapedRecipe(GUNPOWDER_KEY, gunpowder);

        gp.shape(" G ", " G ", " G ");

        gp.setIngredient('G', Material.IRON_INGOT);

        boolean success = Bukkit.addRecipe(gp);
        if (success)
            SMItems.getInstance().getLogger().fine("Dodany przepis na " + GUNPOWDER_KEY.getNamespace() + ":" + GUNPOWDER_KEY.getKey());
        else
            SMItems.getInstance().getLogger().fine("NIEPOMYSLNE dodanie przepisu na: " + GUNPOWDER_KEY.getNamespace() + ":" + GUNPOWDER_KEY.getKey());

        return success;
    }

    public static boolean unregisterGunpowderRecipe() {
        boolean success = Bukkit.removeRecipe(GUNPOWDER_KEY);

        if (success)
            SMItems.getInstance().getLogger().fine("Usunieto przepis na:" + GUNPOWDER_KEY.getNamespace() + ":" + GUNPOWDER_KEY.getKey());

        else
            SMItems.getInstance().getLogger().fine("Nie udalo sie usunac przepisu na: " + GUNPOWDER_KEY.getNamespace() + ":" + GUNPOWDER_KEY.getKey());

        return success;
    }


}
