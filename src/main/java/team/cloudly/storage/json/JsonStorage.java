package team.cloudly.storage.json;

import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import team.cloudly.actions.ActionBlock;
import team.cloudly.storage.Storage;

import java.util.List;
import java.util.Map;

public class JsonStorage implements Storage {

    private Plugin plugin;
    public JsonStorage(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public void saveAll(List<ActionBlock> actionBlocks) {
        
    }

    @Override
    public Map<Block, ActionBlock> load() {
        return null;
    }
}
