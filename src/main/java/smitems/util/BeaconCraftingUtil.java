package smitems.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;
import org.bukkit.inventory.meta.EnchantmentStorageMeta;
import org.bukkit.inventory.meta.ItemMeta;
import smitems.SMItems;

public class BeaconCraftingUtil {
    public static final NamespacedKey BEACON_KEY = new NamespacedKey(SMItems.getInstance(), "beaconkey");

    private BeaconCraftingUtil() {
    }

    public static ItemStack createBeacon() {
        ItemStack beacon = new ItemStack(Material.BEACON);

        ItemMeta meta = beacon.getItemMeta();
        meta.setDisplayName("Beaconik");
        beacon.setItemMeta(meta);

        return beacon;
    }

    public static boolean registerBeaconRecipe() {
        ItemStack beacon = BeaconCraftingUtil.createBeacon();
        ItemStack A = new ItemStack(Material.ENCHANTED_BOOK);
        EnchantmentStorageMeta AMeta = (EnchantmentStorageMeta) A.getItemMeta();
        AMeta.addStoredEnchant(Enchantment.MENDING, 1, true);
        RecipeChoice.ExactChoice mendingBook = new RecipeChoice.ExactChoice(A);

        ShapedRecipe rec = new ShapedRecipe(BEACON_KEY,beacon);
        rec.shape("AAA","AAA","AAA");
        rec.setIngredient('A',mendingBook);




        boolean success = Bukkit.addRecipe(rec);
        if (success)
            SMItems.getInstance().getLogger().fine("Dodany przepis na " + BEACON_KEY.getNamespace() + ":" + BEACON_KEY.getKey());
        else
            SMItems.getInstance().getLogger().fine("NIEPOMYSLNE dodanie przepisu na: " + BEACON_KEY.getNamespace() + ":" + BEACON_KEY.getKey());

        return success;
    }

    public static boolean unregisterBeaconRecipe() {
        boolean success = Bukkit.removeRecipe(BEACON_KEY);

        if (success)
            SMItems.getInstance().getLogger().fine("Usunieto przepis na:" + BEACON_KEY.getNamespace() + ":" + BEACON_KEY.getKey());

        else
            SMItems.getInstance().getLogger().fine("Nie udalo sie usunac przepisu na: " + BEACON_KEY.getNamespace() + ":" + BEACON_KEY.getKey());

        return success;
    }
}
