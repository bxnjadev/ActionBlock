package team.cloudly.actions.action;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import team.cloudly.actions.ActionExecutor;

import java.util.HashMap;
import java.util.Map;

public class PlayerAction implements ActionExecutor {

    private final String command;
    public PlayerAction(String command){
        this.command = command;
    }

    @Override
    public void execute(Player player) {
        Bukkit.dispatchCommand(player,command);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String,Object> actionSerialize = new HashMap<>();
        actionSerialize.put("command",command);

        return actionSerialize;
    }
}
