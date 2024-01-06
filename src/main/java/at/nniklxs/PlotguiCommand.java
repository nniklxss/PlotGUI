package at.nniklxs;

import com.plotsquared.core.plot.PlotSettings;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;


public class PlotguiCommand implements CommandExecutor, Listener {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {

            return true;


        }
        Player player = (Player) sender;
        if (!player.hasPermission("plotgui.use")) {
            player.sendMessage(Main.prefix + "§cDazu hast du keine Rechte.");
            return true;
        }
        Inventory inv = InventoryManager.inv_9x3((InventoryHolder) player, "§a§lPlotGUI");
        inv.setItem(11, new ItemBuilder(Material.OAK_FENCE, 1).setDisplayName("§8» §aRand").create());
        inv.setItem(13, new ItemBuilder(Material.STONE_BRICK_WALL, 1).setDisplayName("§8» §aWand").create());
        inv.setItem(15, new ItemBuilder(Material.LEGACY_REDSTONE_COMPARATOR, 1).setDisplayName("§8» §aFlags").create());
        player.openInventory(inv);
        player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F, 1F);
        player.sendMessage("§8*§7Items werden geladen...");
        return true;

    }

    @EventHandler
    public void onInventoryClick(final InventoryClickEvent event) {
        if (event.getRawSlot() < 0) {
            return;
        }
        if (event.getSlot() < 0) {
            return;
        }
        if (event.getView().getType() == null) {
            return;
        }
        if (event.getView() == null) {
            return;
        }
        if (event.getClick() == null) {
            return;
        }
        if (event.getCurrentItem() == null) {
            return;
        }
        if (event.getCurrentItem().getItemMeta() == null) {
            return;
        }
        if (event.getView().getTitle().contains("§a§lPlotGUI")) {
            event.setCancelled(true);
        }
        if (event.getClickedInventory().getType() != InventoryType.PLAYER) {
            if (event.getView().getTitle().equalsIgnoreCase("§a§lPlotGUI")) {
                event.setCancelled(true);
                final Player player = (Player) event.getWhoClicked();
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aRand")) {
                    Inventory inv = InventoryManager.inv_9x6((InventoryHolder) player, "§8» §aRand-GUI");
                    inv.addItem(new ItemStack[]{new ItemStack(Material.STONE_SLAB)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.QUARTZ_SLAB)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.SANDSTONE_SLAB)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.OAK_SLAB)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.SMOOTH_STONE_SLAB)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.PRISMARINE_SLAB)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.SMOOTH_RED_SANDSTONE_SLAB)});
                    if (player.hasPermission("plotgui.premium.border")) {
                        inv.addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.NETHERITE_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.MUD_BRICK_SLAB)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.DEEPSLATE_BRICK_SLAB)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.DEEPSLATE_TILE_SLAB)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.POLISHED_DEEPSLATE_SLAB)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.RED_NETHER_BRICK_SLAB)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.WAXED_CUT_COPPER_SLAB)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.WAXED_OXIDIZED_CUT_COPPER_SLAB)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.BEDROCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK)});

                    }
                    final ItemStack back = new ItemBuilder(Material.ARROW).setDisplayName("§8» §7Zurück").create();
                    inv.setItem(45, back);
                    player.closeInventory();
                    player.openInventory(inv);
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aWand")) {
                    final Inventory inv = InventoryManager.inv_9x6((InventoryHolder) player, "§8» §aWand-GUI");
                    inv.addItem(new ItemStack[]{new ItemStack(Material.STONE)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.OAK_PLANKS)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.SANDSTONE)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.CUT_SANDSTONE)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.CUT_RED_SANDSTONE)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.BRICKS)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.COBBLESTONE)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.STONE_BRICKS)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.DEEPSLATE_TILES)});
                    inv.addItem(new ItemStack[]{new ItemStack(Material.ORANGE_CONCRETE)});
                    if (player.hasPermission("plotgui.premium.wall")) {
                        inv.addItem(new ItemStack[]{new ItemStack(Material.NETHERITE_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.DIAMOND_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.GOLD_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.EMERALD_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.AMETHYST_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.RAW_IRON_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.REINFORCED_DEEPSLATE)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.MUD_BRICKS)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.PACKED_MUD)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.RAW_GOLD_BLOCK)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.BOOKSHELF)});
                        inv.addItem(new ItemStack[]{new ItemStack(Material.CRYING_OBSIDIAN)});


                    }
                     ItemStack back = new ItemBuilder(Material.ARROW).setDisplayName("§8» §7Zurück").create();
                    inv.setItem(45, back);
                    player.closeInventory();
                    player.openInventory(inv);
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§8» §aFlags")) {
                   Inventory inv1 = InventoryManager.inv_9x6((InventoryHolder) player, "§8» §aFlags-GUI");
                    ItemStack slot = new ItemBuilder(Material.LIGHT_GRAY_STAINED_GLASS_PANE).setDisplayName(" ").create();
                    ItemStack Flag1 = new ItemBuilder(Material.OAK_DOOR).setDisplayName("§8» §7Plot-Spawn setzen").setLore("§8 ", "§7Setzt den Plot-Spawn, wo du dich gerade befindest.", "§8 ").create();
                    ItemStack Flag2 = new ItemBuilder(Material.BARRIER).setDisplayName("§8» §7Alle Spieler vom Plot verbannen").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag3 = new ItemBuilder(Material.NETHERITE_SWORD).setDisplayName("§8» §7Player vs. Entity").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag4 = new ItemBuilder(Material.HOPPER).setDisplayName("§8» §7Drop-Protection").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag5 = new ItemBuilder(Material.CLOCK).setDisplayName("§8» §7Plot-Uhrzeit").setLore("§8", "§4§LRECHTSKLICK:", "§9Nachts", "§4§LLINKSKLICK:", "§aTag", "§8 ").create();
                    ItemStack Flag6 = new ItemBuilder(Material.MUSIC_DISC_PIGSTEP).setDisplayName("§8» §7Plot-Musik").setLore("§8", "§4§LRECHTSKLICK:", "§aSpielt §6Cat §aab", "§4§LLINKSKLICK:", "§cStoppt das Lied", "§8 ").create();
                    ItemStack Flag7 = new ItemBuilder(Material.STRUCTURE_VOID).setDisplayName("§8» §7Forcefield").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag8 = new ItemBuilder(Material.IRON_DOOR).setDisplayName("§8» §7Notify-Enter").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag9 = new ItemBuilder(Material.STONE_PRESSURE_PLATE).setDisplayName("§8» §7Notify-Leave").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag10 = new ItemBuilder(Material.ICE).setDisplayName("§8» §7Ice-melt").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag11 = new ItemBuilder(Material.SNOW_BLOCK).setDisplayName("§8» §7Snow-melt").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    ItemStack Flag12 = new ItemBuilder(Material.SNOW).setDisplayName("§8» §7Snow-form").setLore("§8", "§4§LRECHTSKLICK:", "§aAktivieren", "§4§LLINKSKLICK:", "§cDeaktivieren", "§8 ").create();
                    inv1.setItem(11, Flag1);
                    inv1.setItem(13, Flag2);
                    inv1.setItem(15, Flag3);
                    inv1.setItem(19, Flag4);
                    inv1.setItem(21, Flag5);
                    inv1.setItem(23, Flag6);
                    inv1.setItem(25, Flag7);
                    inv1.setItem(29, Flag8);
                    inv1.setItem(31, Flag9);
                    inv1.setItem(33, Flag10);
                    inv1.setItem(39, Flag11);
                    inv1.setItem(41, Flag12);
                    inv1.setItem(10, slot);
                    inv1.setItem(12, slot);
                    inv1.setItem(14, slot);
                    inv1.setItem(16, slot);
                    inv1.setItem(20, slot);
                    inv1.setItem(22, slot);
                    inv1.setItem(24, slot);
                    inv1.setItem(28, slot);
                    inv1.setItem(30, slot);
                    inv1.setItem(32, slot);
                    inv1.setItem(34, slot);
                    inv1.setItem(40, slot);
                    inv1.setItem(42, slot);
                    inv1.setItem(43, slot);
                    inv1.setItem(37, slot);
                    inv1.setItem(38, slot);

                     ItemStack back = new ItemBuilder(Material.ARROW).setDisplayName("§8» §7Zurück").create();

                    player.openInventory(inv1);
                }
            }


            if (event.getView().getTitle().equalsIgnoreCase("§8» §aRand-GUI") || event.getView().getTitle().equalsIgnoreCase("§8» §aWand-GUI")) {
                Player player = (Player) event.getWhoClicked();
                event.setCancelled(true);
                if (event.getCurrentItem().getType().equals((Object) Material.ARROW)) {
                    Inventory inv = InventoryManager.inv_9x3((InventoryHolder) player, "§a§lPlotGUI");
                    inv.setItem(11, new ItemBuilder(Material.OAK_FENCE, 1).setDisplayName("§8» §aRand").create());
                    inv.setItem(13, new ItemBuilder(Material.STONE_BRICK_WALL, 1).setDisplayName("§8» §aWand").create());
                    inv.setItem(15, new ItemBuilder(Material.LEGACY_REDSTONE_COMPARATOR, 1).setDisplayName("§8» §aFlags").create());
                    player.openInventory(inv);
                    player.playSound(player.getLocation(), Sound.BLOCK_CHEST_OPEN, 1F, 1F);

                }
            }
            if (event.getView().getTitle().equalsIgnoreCase("§8» §aRand-GUI") && !event.getCurrentItem().getType().equals((Object) Material.ARROW) && !event.getCurrentItem().getType().equals((Object) Material.BLACK_STAINED_GLASS_PANE)) {
                new PlotManager().setPlotRand((Player) event.getWhoClicked(), event.getCurrentItem().getType().toString());
            }
            if (event.getView().getTitle().equalsIgnoreCase("§8» §aWand-GUI") && !event.getCurrentItem().getType().equals((Object) Material.ARROW) && !event.getCurrentItem().getType().equals((Object) Material.BLACK_STAINED_GLASS_PANE)) {
                new PlotManager().setPlotWand((Player) event.getWhoClicked(), event.getCurrentItem().getType().toString());


            }


            Player player = (Player) event.getWhoClicked();
            if (event.getView().getTitle().contains("§8» §aFlags")) {
                event.setCancelled(true);
                if (event.getClickedInventory().getType() == InventoryType.PLAYER) {
                    return;

                }
                // Rechtsklick = Aktivieren | Linksklick = Deaktivieren

                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Plot-Spawn setzen")) {
                    player.performCommand("plot sethome");

                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Alle Spieler vom Plot verbannen") && event.isRightClick()) {
                    player.performCommand("plot deny * ");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Alle Spieler vom Plot verbannen") && event.isLeftClick()) {
                    player.performCommand("plot undeny * ");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Player vs. Entity") && event.isRightClick()) {
                    player.performCommand("p flag set pve true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Player vs. Entity") && event.isLeftClick()) {
                    player.performCommand("p flag set pve false");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Drop-Protection") && event.isRightClick()) {
                    player.performCommand("p flag set drop-protection true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Drop-Protection") && event.isLeftClick()) {
                    player.performCommand("p flag set drop-protection false");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Plot-Uhrzeit") && event.isLeftClick()) {
                    player.performCommand("p flag set time 1000");

                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Plot-Uhrzeit") && event.isRightClick()) {
                    player.performCommand("p flag set time 18000");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Plot-Musik") && event.isLeftClick()) {
                    player.performCommand("p flag remove music");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Plot-Musik") && event.isRightClick()) {
                    player.performCommand("p flag set music music_disc_cat");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Forcefield") && event.isRightClick()) {
                    player.performCommand("p flag set forcefield true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Forcefield") && event.isLeftClick()) {
                    player.performCommand("p flag set forcefield false");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Notify-Enter") && event.isRightClick()) {
                    player.performCommand("p flag set notify-enter true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Notify-Enter") && event.isLeftClick()) {
                    player.performCommand("p flag set notify-enter false");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Notify-Leave") && event.isRightClick()) {
                    player.performCommand("p flag set notify-leave true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Notify-Leave") && event.isLeftClick()) {
                    player.performCommand("p flag set notify-leave false");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Ice-melt") && event.isRightClick()) {
                    player.performCommand("p flag set ice-melt true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Ice-melt") && event.isLeftClick()) {
                    player.performCommand("p flag set ice-melt false");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Snow-melt") && event.isRightClick()) {
                    player.performCommand("p flag set snow-melt true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Snow-melt") && event.isLeftClick()) {
                    player.performCommand("p flag set snow-melt false");
                }


                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Snow-form") && event.isRightClick()) {
                    player.performCommand("p flag set snow-form true");
                }
                if (event.getCurrentItem().getItemMeta().getDisplayName().equals("§8» §7Snow-form") && event.isLeftClick()) {
                    player.performCommand("p flag set snow-form false");
                }
                if (event.getCurrentItem().getType().equals((Object) Material.ARROW)){
                    player.closeInventory();

                }
            }
        }
    }
}













