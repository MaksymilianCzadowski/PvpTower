package incrafty.maks;

import net.md_5.bungee.api.chat.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.*;
import org.bukkit.event.Listener;

import javax.swing.*;

public class PlayerJoinListener implements Listener {


    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        createScoreboard(e.getPlayer());
        updateScoreboard();
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e){
        updateScoreboard();
    }

    public void createScoreboard(Player player) {

        ScoreboardManager m = Bukkit.getScoreboardManager();
        Scoreboard b = m.getNewScoreboard();
        Objective o = b.registerNewObjective("minijeu", "");
        o.setDisplaySlot(DisplaySlot.SIDEBAR);
        o.setDisplayName(ChatColor.WHITE + "" + ChatColor.BOLD + "§b§l   INCRAFTY   §b");
        player.setScoreboard(b);

        Team yellow = b.registerNewTeam("yellow");
        Team red = b.registerNewTeam("red");
        Team blue = b.registerNewTeam("blue");
        Team green = b.registerNewTeam("green");

        yellow.setPrefix(ChatColor.YELLOW + "[YELLOW]" + ChatColor.WHITE);
        red.setPrefix(ChatColor.RED + "[RED]" + ChatColor.WHITE);
        blue.setPrefix(ChatColor.BLUE + "[BLUE]" + ChatColor.WHITE);
        green.setPrefix(ChatColor.GREEN+ "[GREEN]" + ChatColor.WHITE);

        yellow.setAllowFriendlyFire(true);

        if(Bukkit.getOnlinePlayers().size()  <= 4 ){
            yellow.addPlayer(player);
            Score equipe = o.getScore("§eTeam: §eYellow");
            equipe.setScore(3);
        } else if ((Bukkit.getOnlinePlayers().size()  > 4) && (Bukkit.getOnlinePlayers().size()<= 8)) {
            red.addPlayer(player);
            Score equipe = o.getScore("§eTeam: §cRed");
            equipe.setScore(3);
        } else if ((Bukkit.getOnlinePlayers().size()  > 8) && (Bukkit.getOnlinePlayers().size()<= 12)){
            blue.addPlayer(player);
            Score equipe = o.getScore("§eTeam: §9Blue");
            equipe.setScore(3);
        } else {
            green.addPlayer(player);
            Score equipe = o.getScore("§eTeam:"+ChatColor.GREEN +"Green");
        }
        Score marque = o.getScore(ChatColor.YELLOW + " ----------------  ");
        marque.setScore(9);

        Score name = o.getScore(ChatColor.YELLOW + "Name: " + ChatColor.GOLD + "" + player.getDisplayName());
        name.setScore(8);

        Score space2= o.getScore("§7 ");
        space2.setScore(7);

        Score kill = o.getScore(ChatColor.YELLOW + "Kills: " + ChatColor.GOLD + player.getStatistic(Statistic.PLAYER_KILLS));
        kill.setScore(5);

        Score death = o.getScore(ChatColor.YELLOW + "Deaths: " + ChatColor.GOLD + player.getStatistic(Statistic.DEATHS));
        death.setScore(4);

        Score space0 = o.getScore("§9 ");
        space0.setScore(2);

        Score ip = o.getScore("§6incrafty.fr ");
        ip.setScore(1);

        Score p2 = o.getScore(ChatColor.YELLOW + " ---------------- ");
        p2.setScore(0);

        player.setScoreboard(b);

    }
    public void updateScoreboard(){
        for(Player online: Bukkit.getOnlinePlayers()) {
            Score score = online.getScoreboard().getObjective(DisplaySlot.SIDEBAR).getScore(ChatColor.YELLOW + "Online: " + "§6 " + Bukkit.getOnlinePlayers().size() + "§6 /16");
            score.setScore(6);
        }
    }
}
//    @EventHandler
//    public void playerMoveEvent(PlayerMoveEvent e){
//        updateScoreboard(e.getPlayer());
//    }


