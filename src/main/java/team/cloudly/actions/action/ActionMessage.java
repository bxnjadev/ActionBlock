package team.cloudly.actions.action;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import team.cloudly.actions.ActionExecutor;

import java.util.HashMap;
import java.util.Map;

public class ActionMessage implements ActionExecutor {

    private final String message;
    public ActionMessage(String message){
        this.message = message;
    }

    @Override
    public void execute(Player player) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',message));
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String,Object> serializeAction = new HashMap<>();
        serializeAction.put("message",message);

        return serializeAction;
    }
}
