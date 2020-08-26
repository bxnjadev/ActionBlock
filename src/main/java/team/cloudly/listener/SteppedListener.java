package team.cloudly.listener;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import team.cloudly.actions.ActionBlock;
import team.cloudly.actions.ActionBlockType;
import team.cloudly.actions.ActionCache;

public class SteppedListener implements Listener {

    private ActionCache actionCache;
    public SteppedListener(PlayerMoveEvent event){
        Location location = event.getTo();
        Block block = location.getBlock().getRelative(BlockFace.DOWN);
        Player player = event.getPlayer();

        if(actionCache.blockHasAction(block)){
            return;
        }

        ActionBlock actionBlock = actionCache.findActionBlock(block);

        if(!(actionBlock.getActionBlockType() == ActionBlockType.STEPPED)){
            return;
        }

        actionBlock.executeActions(player);
    }

}
