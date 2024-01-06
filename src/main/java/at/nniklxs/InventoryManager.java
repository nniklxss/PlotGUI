package at.nniklxs;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

public class InventoryManager {

    public static Inventory inv_9x6(InventoryHolder player, String name) {
        final Inventory inv = Bukkit.createInventory(player, 54, name);
        final ItemStack grau = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, (short)7).setDisplayName(" ").create();
        inv.setItem(0, grau);
        inv.setItem(1, grau);
        inv.setItem(2, grau);
        inv.setItem(3, grau);
        inv.setItem(4, grau);
        inv.setItem(5, grau);
        inv.setItem(6, grau);
        inv.setItem(7, grau);
        inv.setItem(8, grau);
        inv.setItem(9, grau);
        inv.setItem(17, grau);
        inv.setItem(18, grau);
        inv.setItem(26, grau);
        inv.setItem(27, grau);
        inv.setItem(35, grau);
        inv.setItem(36, grau);
        inv.setItem(44, grau);
        inv.setItem(45, grau);
        inv.setItem(46, grau);
        inv.setItem(47, grau);
        inv.setItem(48, grau);
        inv.setItem(49, grau);
        inv.setItem(50, grau);
        inv.setItem(51, grau);
        inv.setItem(52, grau);
        inv.setItem(53, grau);
        return inv;
    }

    public static Inventory inv_9x5(InventoryHolder player, String name) {
        final Inventory inv = Bukkit.createInventory(player, 45, name);
        final ItemStack grau = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, (short)7).setDisplayName(" ").create();
        inv.setItem(0, grau);
        inv.setItem(1, grau);
        inv.setItem(2, grau);
        inv.setItem(3, grau);
        inv.setItem(4, grau);
        inv.setItem(5, grau);
        inv.setItem(6, grau);
        inv.setItem(7, grau);
        inv.setItem(8, grau);
        inv.setItem(9, grau);
        inv.setItem(17, grau);
        inv.setItem(18, grau);
        inv.setItem(26, grau);
        inv.setItem(27, grau);
        inv.setItem(35, grau);
        inv.setItem(36, grau);
        inv.setItem(37, grau);
        inv.setItem(38, grau);
        inv.setItem(39, grau);
        inv.setItem(40, grau);
        inv.setItem(41, grau);
        inv.setItem(42, grau);
        inv.setItem(43, grau);
        inv.setItem(44, grau);
        return inv;
    }

    public static Inventory inv_9x3(InventoryHolder player, String name) {
        final Inventory inv = Bukkit.createInventory(player, 27, name);
        final ItemStack grau = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, (short)7).setDisplayName(" ").create();
        inv.setItem(0, grau);
        inv.setItem(1, grau);
        inv.setItem(2, grau);
        inv.setItem(3, grau);
        inv.setItem(4, grau);
        inv.setItem(5, grau);
        inv.setItem(6, grau);
        inv.setItem(7, grau);
        inv.setItem(8, grau);
        inv.setItem(9, grau);
        inv.setItem(17, grau);
        inv.setItem(18, grau);
        inv.setItem(19, grau);
        inv.setItem(20, grau);
        inv.setItem(21, grau);
        inv.setItem(22, grau);
        inv.setItem(23, grau);
        inv.setItem(24, grau);
        inv.setItem(25, grau);
        inv.setItem(26, grau);
        return inv;
    }

    public static Inventory inv_9x4(InventoryHolder player, final String name) {
        final Inventory inv = Bukkit.createInventory(player, 36, name);
        final ItemStack grau = new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE, 1, (short)7).setDisplayName(" ").create();
        inv.setItem(0, grau);
        inv.setItem(1, grau);
        inv.setItem(2, grau);
        inv.setItem(3, grau);
        inv.setItem(4, grau);
        inv.setItem(5, grau);
        inv.setItem(6, grau);
        inv.setItem(7, grau);
        inv.setItem(8, grau);
        inv.setItem(9, grau);
        inv.setItem(17, grau);
        inv.setItem(18, grau);
        inv.setItem(26, grau);
        inv.setItem(27, grau);
        inv.setItem(28, grau);
        inv.setItem(29, grau);
        inv.setItem(30, grau);
        inv.setItem(31, grau);
        inv.setItem(32, grau);
        inv.setItem(33, grau);
        inv.setItem(34, grau);
        inv.setItem(35, grau);
        return inv;
    }
}
