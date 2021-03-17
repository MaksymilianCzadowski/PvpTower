package incrafty.maks;

import incrafty.maks.position.GetHeight;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;
import org.bukkit.event.Listener;

public class PlayerJoinListener implements Listener {

    public void updateScoreboard(Player player){

        ScoreboardManager m = Bukkit.getScoreboardManager();
        assert m != null;
        Scoreboard b = m.getNewScoreboard();
        Objective o = b.registerNewObjective("minijeu","");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "§b§l INCRAFTY §b");
        player.setScoreboard(b);

        Team yellow = b.registerNewTeam("yellow");
        Team red = b.registerNewTeam("red");
        Team blue = b.registerNewTeam("blue");

        yellow.setPrefix(ChatColor.YELLOW + "[YELLOW]" + ChatColor.WHITE);
        red.setPrefix(ChatColor.RED + "[RED]" + ChatColor.WHITE);
        blue.setPrefix(ChatColor.BLUE + "[BLUE]" + ChatColor.WHITE);

        yellow.setAllowFriendlyFire(false);
        yellow.setNameTagVisibility(NameTagVisibility.HIDE_FOR_OTHER_TEAMS);
        yellow.setCanSeeFriendlyInvisibles(false);

        if(Bukkit.getOnlinePlayers().size() % 3 ==0){
            yellow.addPlayer(player);
        } else if (Bukkit.getOnlinePlayers().size()%3 ==1) {
            red.addPlayer(player);
        } else {
            blue.addPlayer(player);
        }
        Score marque = o.getScore(ChatColor.YELLOW + " ----------------  ");
        marque.setScore(9);

        Score name = o.getScore(ChatColor.YELLOW + "Name: " + ChatColor.GOLD + "" + player.getDisplayName());
        name.setScore(8);

        Score space2= o.getScore("§7 ");
        space2.setScore(7);

        Score online = o.getScore(ChatColor.YELLOW + "Online: " + "§6 " + Bukkit.getOnlinePlayers().size() + "§6 /16");
        online.setScore(6);

        Score kill = o.getScore(ChatColor.YELLOW + "Kills: " + ChatColor.GOLD + player.getStatistic(Statistic.PLAYER_KILLS));
        kill.setScore(5);

        Score death = o.getScore(ChatColor.YELLOW + "Deaths: " + ChatColor.GOLD + player.getStatistic(Statistic.DEATHS));
        death.setScore(4);

        Score equipe = o.getScore(ChatColor.YELLOW + "Floor : §6" + GetHeight.updateHeight(player));
        equipe.setScore(3);

        Score space0 = o.getScore("§9 ");
        space0.setScore(2);

        Score ip = o.getScore("§6incrafty.fr ");
        ip.setScore(1);

        Score p2 = o.getScore(ChatColor.YELLOW + " ---------------- ");
        p2.setScore(0);

        player.setScoreboard(b);

        for(Player current : Bukkit.getOnlinePlayers()) {
            current.setScoreboard(b);
        }
    }
    @EventHandler
    public void playerMoveEvent(PlayerMoveEvent e){
        updateScoreboard(e.getPlayer());
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){

        updateScoreboard(e.getPlayer());
    }
    @EventHandler
    public void onLeave(PlayerQuitEvent event){

        updateScoreboard(event.getPlayer());
    }
}
