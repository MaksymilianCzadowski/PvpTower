package incrafty.maks.position;

import org.bukkit.entity.Player;

public class GetHeight {

    public static String updateHeight(Player player){

        int location = player.getLocation().getBlockY();
            String floor = "";

        if(location >=0 && location< 5){
            floor = "0";
        } else if(location >=5 && location<10){
            floor = "1" ;
        }else if(location>=10 && location<15){
            floor = "2";
        }else if(location>=15 && location<20){
            floor = "3";
        }else if(location>=20 && location<25){
            floor = "4";
        }else if(location>=25 && location<30){
            floor = "5";
        }else if(location>=30 && location<35){
            floor = "6";
        }else if(location>=35 && location<40){
            floor = "7";
        }
        return floor;
    }
}
