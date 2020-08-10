package team.cloudly.actions;

import org.bukkit.block.Block;

public interface ActionCache {

    void addActionBlock(Block block,ActionBlock actionBlock);

    void removeActionBlock(Block block);

    ActionBlock findActionBlock(Block block);

    boolean blockHasAction(Block block);

}
