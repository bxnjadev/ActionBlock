package team.cloudly.storage.json;

import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import team.cloudly.ActionClass;
import team.cloudly.actions.ActionBlock;
import team.cloudly.files.JsonFile;
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
        JsonFile jsonFile = new JsonFile(plugin.getDataFolder(),"blocks");
        jsonFile.writeFile(ActionClass.getGson().toJson(actionBlocks));
    }

    @Override
    public Map<Block, ActionBlock> load() {
        JsonFile jsonFile = new JsonFile(plugin.getDataFolder(),"blocks");
        return null;
    }
}
