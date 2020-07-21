package smitems.util;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import smitems.SMItems;

import java.util.Collections;

public class ChaosSwordUtil {
    public static final NamespacedKey CHAOS_SWORD = new NamespacedKey(SMItems.getInstance(), "chaossword");

    private ChaosSwordUtil() {
    }

    public static ItemStack createChaosSword() {
        ItemStack villager = new ItemStack(Material.DIAMOND_SWORD);

        ItemMeta meta = villager.getItemMeta();

        meta.setDisplayName("Miecz Chaosu");
        meta.setLore(Collections.singletonList("Miecz wykuty w czasach zielono-żółtej wojny"));
        meta.addEnchant(Enchantment.DAMAGE_ALL,6,true);
        villager.setItemMeta(meta);

        return villager;
    }

    public static boolean isSword(ItemStack stack) {
        if (stack == null || stack.getType() != Material.DIAMOND_SWORD || !stack.hasItemMeta() || !stack.getItemMeta().hasDisplayName())
            return false;

        else if (stack.getItemMeta().getDisplayName().equals("Miecz Chaosu")) return true;

        else return false;
    }

    public static boolean registerChaosSwordRecipe() {
        ItemStack chaossword = ChaosSwordUtil.createChaosSword();

        ShapedRecipe chaos = new ShapedRecipe(CHAOS_SWORD, chaossword);

        chaos.shape("DGD", "DCD", "DGD");

        chaos.setIngredient('G', Material.NETHERITE_SWORD);
        chaos.setIngredient('C', Material.CREEPER_HEAD);
        chaos.setIngredient('D', Material.DIAMOND_SWORD);

        boolean success = Bukkit.addRecipe(chaos);
        if (success)
            SMItems.getInstance().getLogger().fine("Dodany przepis na " + CHAOS_SWORD.getNamespace() + ":" + CHAOS_SWORD.getKey());
        else
            SMItems.getInstance().getLogger().fine("NIEPOMYSLNE dodanie przepisu na: " + CHAOS_SWORD.getNamespace() + ":" + CHAOS_SWORD.getKey());

        return success;
    }

    public static boolean unregisterChaosSwordRecipe() {
        boolean success = Bukkit.removeRecipe(CHAOS_SWORD);

        if (success)
            SMItems.getInstance().getLogger().fine("Usunieto przepis na:" + CHAOS_SWORD.getNamespace() + ":" + CHAOS_SWORD.getKey());

        else
            SMItems.getInstance().getLogger().fine("Nie udalo sie usunac przepisu na: " + CHAOS_SWORD.getNamespace() + ":" + CHAOS_SWORD.getKey());

        return success;
    }
}