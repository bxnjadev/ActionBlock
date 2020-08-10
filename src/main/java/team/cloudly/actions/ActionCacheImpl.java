package team.cloudly.actions;

import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ActionCacheImpl implements ActionCache {

    private final Map<Block,ActionBlock> actionBlocks = new HashMap<>();

    @Override
    public void addActionBlock(Block block, ActionBlock actionBlock) {
        actionBlocks.put(block,actionBlock);
    }

    @Override
    public void removeActionBlock(Block block) {
        actionBlocks.remove(block);
    }

    @Override
    public ActionBlock findActionBlock(Block block) {
        return actionBlocks.get(block);
    }

    @Override
    public boolean blockHasAction(Block block) {
        return actionBlocks.containsKey(block);
    }
}
