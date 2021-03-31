package incrafty.maks.team;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class Game extends JavaPlugin {

    public void onEnable(){
        Team.clearTeams();
    }
    public void onDisable(){
        Team.clearTeams();
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (label.equalsIgnoreCase("assign")){
            int i = 0;
            for(Player player : Bukkit.getOnlinePlayers()){
                if ( i < Bukkit.getOnlinePlayers().size()/2){
                    Team.addToTeam(TeamType.RED, player);
                }else{
                    Team.addToTeam(TeamType.BLUE, player);
                }
                i++;
            }
        }
        if(label.equalsIgnoreCase("myteam")){
            sender.sendMessage(Team.getTeamType(((Player) sender)).name());
        }
        return true;
    }
}
