package team.cloudly.actions;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class ActionBlock {

    private final List<Action> actions;
    private final Block block;

    public ActionBlock(Block block, List<Action> actions){
        this.actions = actions;
        this.block = block;
    }

    public ActionBlock(Block block) {
        this.actions = new ArrayList<>();
        this.block = block;
    }

    public void executeActions(Player player) {
        actions.forEach(action -> {
            action.execute(player);
        });
    }

    public void addAction(Action action){
        actions.add(action);
    }

    public List<Action> getActions(){
        return actions;
    }

    public Block getBlock(){
        return block;
    }

}
