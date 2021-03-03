package incrafty.maks;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import incrafty.maks.startGame.Start;

public final class Main extends JavaPlugin {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        instance = this;
        getCommand("start").setExecutor((CommandExecutor)new Start());
        PluginManager pm = Bukkit.getPluginManager();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void createTeam(Player player){

    }
}
