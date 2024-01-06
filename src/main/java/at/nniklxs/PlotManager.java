package at.nniklxs;

import com.plotsquared.core.PlotAPI;
import com.plotsquared.core.player.PlotPlayer;
import com.plotsquared.core.plot.Plot;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Animals;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PlotManager {
    private File file;
    private FileConfiguration cfg;

    //https://github.com/IntellectualSites/PlotSquared

    public PlotManager() {
        this.file = new File("plugins/PlotGUI", "plottitles.yml");
        this.cfg = (FileConfiguration) YamlConfiguration.loadConfiguration(this.file);
    }

    public boolean hasTitle(final Plot plot) {
        return this.cfg.getString(plot.getId().toString() + ".title") != null;
    }

    public boolean hasSubTitle(final Plot plot) {
        return this.cfg.getString(plot.getId().toString() + ".subtitle") != null;
    }

    public String getTitle(final Plot plot) {
        if (this.cfg.getString(plot.getId().toString() + ".title") != null) {
            return this.cfg.getString(plot.getId().toString() + ".title");
        }
        return " ";
    }

    public String getSubTitle(final Plot plot) {
        if (this.cfg.getString(plot.getId().toString() + ".subtitle") != null) {
            return this.cfg.getString(plot.getId().toString() + ".subtitle");
        }
        return " ";
    }

    public void setTitle(final Plot plot, final String text) {
        this.cfg.set(plot.getId().toString() + ".title", (Object)text);
        try {
            this.cfg.save(this.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setSubTitle(final Plot plot, final String text) {
        this.cfg.set(plot.getId().toString() + ".subtitle", (Object)text);
        try {
            this.cfg.save(this.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void resetTitles(final Plot plot) {
        this.cfg.set(plot.getId().toString(), (Object)null);
        try {
            this.cfg.save(this.file);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setPlotRand(final Player player, final String materialToSet) {
        final PlotAPI plotAPI = new PlotAPI();
        final PlotPlayer plotPlayer = plotAPI.wrapPlayer(player.getUniqueId());
        final Plot plot = plotPlayer.getCurrentPlot();
        if (plot != null) {
            if (plot.getConnectedPlots().size() > 1) {
                for (final Plot plots : plot.getConnectedPlots()) {
                    if (!plots.getOwners().contains(player.getUniqueId()) && !player.hasPermission("citybuild.plotgui.admin")) {
                        player.sendMessage(Main.prefix + "§cDiese Aktion kann nur der Plot-Besitzer durchführen.");
                        player.closeInventory();
                        break;
                    }
                    plots.getPlotModificationManager().setComponent("border", materialToSet, null, null);
                    player.sendMessage(Main.prefix + "§aDer Plot-Rand wurde erfolgreich gesetzt.");
                }
            }
            else if (plot.getOwners().contains(player.getUniqueId()) || player.hasPermission("citybuild.plotgui.admin")) {
                plot.getPlotModificationManager().setComponent("border", materialToSet, null, null);
                player.sendMessage(Main.prefix + "§aDer Plot-Rand wurde erfolgreich gesetzt.");

            }
            else {
                player.sendMessage(Main.prefix + "§cDiese Aktion kann nur der Plot-Besitzer durchführen.");
                player.closeInventory();
            }
        }
        else {
            player.sendMessage(Main.prefix + "§cDu befindest dich nicht auf einem Plot.");
            player.closeInventory();
        }
    }

    public void setPlotWand(final Player player, final String materialToSet) {
        final PlotAPI plotAPI = new PlotAPI();
        final PlotPlayer plotPlayer = plotAPI.wrapPlayer(player.getUniqueId());
        final Plot plot = plotPlayer.getCurrentPlot();
        if (plot != null) {
            if (plot.getConnectedPlots().size() > 1) {
                for (final Plot plots : plot.getConnectedPlots()) {
                    if (!plots.getOwners().contains(player.getUniqueId()) && !player.hasPermission("plotgui.admin")) {
                        player.sendMessage(Main.prefix + "§cDiese Aktion kann nur der Plot-Besitzer durchführen.");
                        player.closeInventory();
                        break;
                    }

                    plots.getPlotModificationManager().setComponent("wall", materialToSet, null, null);
                }
            }
            else {
                if (!plot.getOwners().contains(player.getUniqueId()) && !player.hasPermission("citybuild.plotgui.admin")) {
                    player.sendMessage(Main.prefix + "§cDiese Aktion kann nur der Plot-Besitzer durchführen.");
                    player.closeInventory();
                    return;
                }

                plot.getPlotModificationManager().setComponent("wall", materialToSet, null, null);
            }
            player.sendMessage(Main.prefix + "§aDie Plot-Wand wurde erfolgreich gesetzt.");

        }
        else {
            player.sendMessage(Main.prefix + "§cDu befindest dich nicht auf einem Plot.");
            player.closeInventory();
        }
    }

    public List<Entity> getPlotEntities(final Plot plot) {
        final List<Entity> entities = new ArrayList<Entity>();
        for (final PlotPlayer player : plot.getPlayersInPlot()) {
            if (player instanceof Animals) {
                entities.add((Entity)player);
            }
        }
        return entities;
    }
}


