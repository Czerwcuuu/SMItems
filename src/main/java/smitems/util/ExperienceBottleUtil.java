package smitems.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import smitems.SMItems;

public class ExperienceBottleUtil {
    public static final NamespacedKey EB_KEY = new NamespacedKey(SMItems.getInstance(), "experiencebottle");

    private ExperienceBottleUtil() {
    }

    public static ItemStack createEB() {
        ItemStack eb = new ItemStack(Material.EXPERIENCE_BOTTLE);

        ItemMeta meta = eb.getItemMeta();

        meta.setDisplayName("EXP");

        eb.setItemMeta(meta);

        return eb;
    }

    public static boolean registerEbRecipe() {
        ItemStack ebottle = ExperienceBottleUtil.createEB();

        ShapedRecipe t = new ShapedRecipe(EB_KEY, ebottle);

        t.shape("DDD", "DGD", "DDD");

        t.setIngredient('G', Material.GLOWSTONE);
        t.setIngredient('D', Material.GLASS);

        boolean success = Bukkit.addRecipe(t);
        if (success)
            SMItems.getInstance().getLogger().fine("Dodany przepis na " + EB_KEY.getNamespace() + ":" + EB_KEY.getKey());
        else
            SMItems.getInstance().getLogger().fine("NIEPOMYSLNE dodanie przepisu na: " + EB_KEY.getNamespace() + ":" + EB_KEY.getKey());

        return success;
    }

    public static boolean unregisterEbRecipe() {
        boolean success = Bukkit.removeRecipe(EB_KEY);

        if (success)
            SMItems.getInstance().getLogger().fine("Usunieto przepis na:" + EB_KEY.getNamespace() + ":" + EB_KEY.getKey());

        else
            SMItems.getInstance().getLogger().fine("Nie udalo sie usunac przepisu na: " + EB_KEY.getNamespace() + ":" + EB_KEY.getKey());

        return success;
    }


}
