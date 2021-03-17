package incrafty.maks;

import incrafty.maks.generation.struct;
import incrafty.maks.generation.structCMD;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import incrafty.maks.startGame.Start;



public final class Main extends JavaPlugin implements Listener {
    private static Main instance;

    public static Main getInstance() {
        return instance;
    }
    @Override
    public void onEnable() {
        PluginManager pm  = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoinListener(),this);
        getServer().getPluginManager().registerEvents(new PlayerJoinListener(),this);
        Bukkit.getServer().getPluginManager().registerEvents(this,this);

        instance = this;
        getCommand("start").setExecutor((CommandExecutor)new Start());
        getCommand("struct").setExecutor(new structCMD());
        struct.loadStruct();

    }

    @Override
    public void onDisable() {
        getLogger().info( "[Plugin Test] has been disable");
        super.onDisable();
    }

}
