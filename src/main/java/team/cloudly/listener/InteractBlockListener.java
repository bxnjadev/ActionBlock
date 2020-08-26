package team.cloudly.listener;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import team.cloudly.actions.ActionBlock;
import team.cloudly.actions.ActionBlockType;
import team.cloudly.actions.ActionCache;

public class InteractBlockListener implements Listener {

    private final ActionCache actionCache;
    public InteractBlockListener(ActionCache actionCache){
        this.actionCache = actionCache;
    }

    @EventHandler
    public void onInteractBlock(PlayerInteractEvent event){
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();

        if(!actionCache.blockHasAction(block)) {
            return;
        }

        ActionBlock actionBlock = actionCache.findActionBlock(block);

        if(!(actionBlock.getActionBlockType() == ActionBlockType.INTERACT)){
            return;
        }

        actionBlock.executeActions(player);
    }

}
