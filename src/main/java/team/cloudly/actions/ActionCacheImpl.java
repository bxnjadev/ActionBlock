package team.cloudly.actions;

import org.bukkit.Location;
import org.bukkit.block.Block;

import java.util.HashMap;
import java.util.Map;

public class ActionCacheImpl implements ActionCache {

    private final Map<Location,ActionBlock> actionBlocks = new HashMap<>();

    @Override
    public void addActionBlock(Block block, ActionBlock actionBlock) {
        actionBlocks.put(block.getLocation(),actionBlock);
    }

    @Override
    public void removeActionBlock(Block block) {
        actionBlocks.remove(block.getLocation());
    }

    @Override
    public ActionBlock findActionBlock(Block block) {
        return actionBlocks.get(block.getLocation());
    }

    @Override
    public boolean blockHasAction(Block block) {
        return actionBlocks.containsKey(block.getLocation());
    }

    @Override
    public Map<Location, ActionBlock> getCache() {
        return actionBlocks;
    }
}
