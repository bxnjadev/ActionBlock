package team.cloudly.storage;

import org.bukkit.block.Block;
import team.cloudly.actions.ActionBlock;

import java.util.List;
import java.util.Map;

public interface Storage {

    void saveAll(List<ActionBlock> actionBlocks);

    Map<Block,ActionBlock> load();

}
