package team.cloudly.actions;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ActionBlock {

    private final List<ActionExecutor> actions;
    private final ActionBlockType actionBlockType;
    private final String permission = "";

    public ActionBlock(ActionBlockType actionBlockType, List<ActionExecutor> actions){
        this.actions = actions;
        this.actionBlockType = actionBlockType;
    }

        public ActionBlock(ActionBlockType actionBlockType) {
        this.actions = new ArrayList<>();
        this.actionBlockType = actionBlockType;
    }

    public void executeActions(Player player) {
        actions.forEach(action -> {
            action.execute(player);
        });
    }

    public void addAction(ActionExecutor actionExecutor){
        actions.add(actionExecutor);
    }

    public List<ActionExecutor> getActions(){
        return actions;
    }

    public ActionBlockType getActionBlockType(){
        return actionBlockType;
    }

}
