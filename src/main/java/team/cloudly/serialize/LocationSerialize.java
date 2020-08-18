package team.cloudly.serialize;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationSerialize {

    public static String locationToString(Location location){
        return location.getWorld().getName()+":"+
                location.getX()+":"+location.getY()+":"+location.getZ()+":"+location.getYaw()+":"+location.getPitch();
    }

    public static Location stringToLocation(String locationString){
        String[] parts = locationString.split(":");

        World world = Bukkit.getWorld(parts[0]);
        double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);
        double z = Double.parseDouble(parts[3]);
        float yaw = Float.parseFloat(parts[4]);
        float pitch = Float.parseFloat(parts[5]);

        return new Location(world,x,y,z,yaw,pitch);
    }

}
