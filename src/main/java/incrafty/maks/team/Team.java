package incrafty.maks.team;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Team {


    private static List<String> redTeam = new ArrayList<String>();
    private static List<String> blueTeam = new ArrayList<String>();

    public static void addToTeam(TeamType type, Player player){
        if(isInTeam((player))){
            player.sendMessage("You are already in a team");
        }
        switch (type){
            case RED:
                redTeam.add(player.getName());
                break;
            case BLUE:
                blueTeam.add(player.getName());
                break;
        }
        player.sendMessage("Added to " + type.toString() + "team!");
    }

    public static boolean isInTeam(Player player){
       return redTeam.contains(player.getName()) || blueTeam.contains(player.getName());
    }
    public static void clearTeams(){
        redTeam.clear();
        blueTeam.clear();
    }
}
