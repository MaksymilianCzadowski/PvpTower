//package incrafty.maks.startGame;
//
//import org.bukkit.Bukkit;
//import org.bukkit.DyeColor;
//import org.bukkit.entity.Player;
//import org.bukkit.event.EventHandler;
//import org.bukkit.event.Listener;
//import org.bukkit.event.inventory.InventoryClickEvent;
//import org.bukkit.inventory.Inventory;
//import org.bukkit.inventory.ItemStack;
//import org.bukkit.inventory.meta.ItemMeta;
//import org.bukkit.material.Wool;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//public class Team implements Listener {
//
//    private static List<String> redTeam = new ArrayList<String>();
//    private static List<String> blueTeam = new ArrayList<String>();
//    private static List<String> yellowTeam = new ArrayList<String>();
//    private static List<String> greenTeam = new ArrayList<String>();
//
//    public static void addToTeam(TeamType type,Player player){
//        switch (type){
//            case RED:
//                redTeam.add(player.getName());
//                break;
//            case BLUE:
//                blueTeam.add(player.getName());
//                break;
//            case YELLOW:
//                yellowTeam.add(player.getName());
//                break;
//            case GREEN:
//                greenTeam.add(player.getName());
//                break;
//        }
//    }
//
//
//
//
//
//
//
//
//
//
//
//    private Inventory inv;
//    private ItemStack g,b,y,r;
//
//    public Team(){
//        inv = Bukkit.getServer().createInventory(null,4,"Team chooser");
//
//        g = createItem(DyeColor.GREEN, "Green Team");
//        b = createItem(DyeColor.BLUE, "Blue Team");
//        y = createItem(DyeColor.YELLOW, "Yellow Team");
//        r = createItem(DyeColor.RED, "Red Team");
//
//        inv.setItem(1,g);
//        inv.setItem(2,b);
//        inv.setItem(3,y);
//        inv.setItem(4,r);
//    }
//
//    private ItemStack createItem(DyeColor dc,String name){
//        ItemStack i = new Wool(dc).toItemStack(1);
//        ItemMeta im = i.getItemMeta();
//        im.setDisplayName(name);
//        im.setLore(Arrays.asList("Set your team", "to " + name.toLowerCase() + " team"));
//        i.setItemMeta(im);
//        return i;
//    }
//
//    public void show(Player p){
//        p.openInventory(inv);
//    }
//
//    @EventHandler
//    public void onInventoryClick(InventoryClickEvent e){
//        if (!e.getInventory().equals(inv)){
//            return;
//        }
//        if(e.getCurrentItem().getItemMeta().getDisplayName().contains("Green Team")){
//            e.getWhoClicked().getName().
//        }
//
//    }
//}
