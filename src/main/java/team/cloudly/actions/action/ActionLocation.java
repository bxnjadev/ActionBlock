package team.cloudly.actions.action;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class ActionLocation implements ActionExecutor {

    private final Location location;
    public ActionLocation(Location location){
        this.location = location;
    }

    @Override
    public void execute(Player player) {
        player.teleport(location);
    }

    @Override
    public String actionSerialize() {
        return "";
    }

}
