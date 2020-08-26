package team.cloudly.actions;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

import java.util.Map;

public interface ActionCache {

    void addActionBlock(Block block,ActionBlock actionBlock);

    void removeActionBlock(Block block);

    ActionBlock findActionBlock(Block block);

    boolean blockHasAction(Block block);

     Map<Location,ActionBlock> getCache();

}
