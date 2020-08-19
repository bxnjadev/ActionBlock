package team.cloudly.actions.action;

import org.bukkit.entity.Player;
import team.cloudly.utils.Utils;

public class ActionMessage implements ActionExecutor {

    private final String message;
    public ActionMessage(String message){
        this.message = message;
    }

    @Override
    public void execute(Player player) {
        player.sendMessage(Utils.colorize(message));
    }

    @Override
    public String actionSerialize() {
        return null;
    }

}
