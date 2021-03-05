package incrafty.maks.generation;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class structCMD implements CommandExecutor {


    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        final Player p = ((Player) sender).getPlayer();
        assert p != null;

        struct.loadStruct();
        p.sendMessage("Nouvelle structure générée !");

        return false;
    }
}
