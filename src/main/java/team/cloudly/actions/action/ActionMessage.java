package team.cloudly.actions.action;

import org.bukkit.entity.Player;
import team.cloudly.actions.Action;
import team.cloudly.actions.ActionType;
import team.cloudly.utils.Utils;

public class ActionMessage implements Action {

    private final String message;
    public ActionMessage(String message){
        this.message = message;
    }

    @Override
    public void execute(Player player) {
        player.sendMessage(Utils.colorize(message));
    }

    @Override
    public ActionType getActionType() {
        return ActionType.MESSAGE;
    }

    @Override
    public String toString() {
        return message;
    }
}
