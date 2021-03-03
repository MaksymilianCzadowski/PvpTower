package incrafty.maks.startGame;

import incrafty.maks.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class Start implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = ((Player)sender).getPlayer();
            (new Timer(player)).runTaskTimer((Plugin)Main.getInstance(), 0L, 20L);
            Bukkit.getScheduler().runTaskLater(Main.getInstance(), () ->{

            },20*20);

        }
        return false;
    }
}
