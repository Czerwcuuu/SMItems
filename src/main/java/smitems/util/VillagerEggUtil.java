package smitems.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import smitems.SMItems;

public class VillagerEggUtil {
    public static final NamespacedKey VILLAGEREGG_KEY = new NamespacedKey(SMItems.getInstance(), "villageregg");

    private VillagerEggUtil() {
    }

    public static ItemStack createVillagerEgg() {
        ItemStack villager = new ItemStack(Material.VILLAGER_SPAWN_EGG);

        ItemMeta meta = villager.getItemMeta();

        meta.setDisplayName("Stylowy Villager");

        villager.setItemMeta(meta);

        return villager;
    }

    public static boolean isVillager(ItemStack stack) {
        if (stack == null || stack.getType() != Material.CREEPER_HEAD || !stack.hasItemMeta() || !stack.getItemMeta().hasDisplayName())
            return false;

        else return stack.getItemMeta().getDisplayName().equals("Stylowy Villager");
    }

    public static boolean registerVillagerEggRecipe() {
        ItemStack villageregg = VillagerEggUtil.createVillagerEgg();

        ShapedRecipe vil1 = new ShapedRecipe(VILLAGEREGG_KEY, villageregg);

        vil1.shape("DGD", "DED", "DGD");

        vil1.setIngredient('G', Material.EMERALD);
        vil1.setIngredient('E', Material.ENCHANTING_TABLE);
        vil1.setIngredient('D', Material.DIAMOND_SWORD);

        boolean success = Bukkit.addRecipe(vil1);
        if (success)
            SMItems.getInstance().getLogger().fine("Dodany przepis na " + VILLAGEREGG_KEY.getNamespace() + ":" + VILLAGEREGG_KEY.getKey());
        else
            SMItems.getInstance().getLogger().fine("NIEPOMYSLNE dodanie przepisu na: " + VILLAGEREGG_KEY.getNamespace() + ":" + VILLAGEREGG_KEY.getKey());

        return success;
    }

    public static boolean unregisterVillagerEggRecipe() {
        boolean success = Bukkit.removeRecipe(VILLAGEREGG_KEY);

        if (success)
            SMItems.getInstance().getLogger().fine("Usunieto przepis na:" + VILLAGEREGG_KEY.getNamespace() + ":" + VILLAGEREGG_KEY.getKey());

        else
            SMItems.getInstance().getLogger().fine("Nie udalo sie usunac przepisu na: " + VILLAGEREGG_KEY.getNamespace() + ":" + VILLAGEREGG_KEY.getKey());

        return success;
    }
}