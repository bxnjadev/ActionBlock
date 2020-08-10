package team.cloudly.actions;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ActionBlock {

    private final List<Action> actions;

    public ActionBlock(List<Action> actions){
        this.actions = actions;
    }

    public ActionBlock(){
        this.actions = new ArrayList<>();
    }

    public void executeActions(Player player) {
        actions.forEach(action -> {
            action.execute(player);
        });
    }

    public void addAction(Action action){
        actions.add(action);
    }

}
