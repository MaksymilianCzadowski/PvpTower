package incrafty.maks.startGame;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer extends BukkitRunnable {

    public int time = 20;
    public Player player;

    public Timer(Player player) {
        this.player = player;
    }
    @Override
    public void run() {
        this.time--;

        if (time == 0) {
            //Partie tp des teams
            cancel();
        }
        if (this.time == 15 || this.time == 10 || (this.time <= 5)) {
            Bukkit.getOnlinePlayers().forEach(p -> p.sendMessage("§eDébut la partie dans §6" + this.time + " §esecondes !"));
        }

    }


}

