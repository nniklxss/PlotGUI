package at.nniklxs;

import com.plotsquared.core.PlotAPI;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public final class Main extends JavaPlugin {

    public static Main INSTANCE;
  //  private PlotAPI api;
    public static String prefix;

    @Override
    public void onEnable() {
        // Plugin startup logic
        prefix = "§a§lPlotGUI";

        INSTANCE = this;
      //  if (Bukkit.getPluginManager().getPlugin("PlotSquared") == null){
       //     Bukkit.getPluginManager().disablePlugin(this);
        Bukkit.getPluginManager().registerEvents((Listener) new PlotguiCommand(), this);
        this.getCommand("plotgui").setExecutor(new PlotguiCommand());
        //Bukkit.getPluginManager().registerEvents((Listener) new FlagsGUI(), this);




    }
     //   api = new PlotAPI();

     //   new PlotListener(api);

           /// this.getCommand("plotgui").setExecutor(new PlotguiCommand());


 //   }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
