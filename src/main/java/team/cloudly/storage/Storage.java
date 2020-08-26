package team.cloudly.storage;

import org.bukkit.Location;
import team.cloudly.actions.ActionBlock;

import java.util.Collection;
import java.util.Map;

public interface Storage {

    void saveAll(Collection<ActionBlock> actionBlocks);

    Map<Location,ActionBlock> load();

}
