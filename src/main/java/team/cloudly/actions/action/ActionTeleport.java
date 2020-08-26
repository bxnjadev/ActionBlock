package team.cloudly.actions.action;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import team.cloudly.actions.ActionExecutor;

import java.util.Map;

public class ActionTeleport implements ActionExecutor {

    private final Location location;
    public ActionTeleport(Location location){
        this.location = location;
    }

    @Override
    public void execute(Player player) {
        player.teleport(location);
    }

    @Override
    public Map<String, Object> serialize() {
        return location.serialize();
    }
}
