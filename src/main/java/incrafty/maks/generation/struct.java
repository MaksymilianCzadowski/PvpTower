package incrafty.maks.generation;

import com.github.shynixn.structureblocklib.api.bukkit.StructureBlockLibApi;
import com.github.shynixn.structureblocklib.api.bukkit.block.StructureBlockLoad;
import incrafty.maks.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.Plugin;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Random;

public class struct {

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static Path random() {
        Path path = null;
        int random = getRandomNumberInRange(1, 5);
        if (random == 1) {
            path = FileSystems.getDefault()
                    .getPath("C:/Users/czado/Desktop/serveur/world/generated/minecraft/structures/1.nbt");
        }
        if (random == 2) {
            path = FileSystems.getDefault()
                    .getPath("C:/Users/czado/Desktop/serveur/world/generated/minecraft/structures/2.nbt");
        }
        if (random == 3) {
            path = FileSystems.getDefault()
                    .getPath("C:/Users/czado/Desktop/serveur/world/generated/minecraft/structures/3.nbt");
        }
        if (random == 4) {
            path = FileSystems.getDefault()
                    .getPath("C:/Users/czado/Desktop/serveur/world/generated/minecraft/structures/4.nbt");
        }
        if (random == 5) {
            path = FileSystems.getDefault()
                    .getPath("C:/Users/czado/Desktop/serveur/world/generated/minecraft/structures/5.nbt");
        }
        return path;

    }

    public static void loadStruct() {
        Plugin plugin = Main.getInstance();

        StructureBlockLibApi.INSTANCE
                .loadStructure(plugin)
                .at(new Location(Bukkit.getWorld("world"), 0, 10, 0))
                .loadFromPath(random());
    }
}
