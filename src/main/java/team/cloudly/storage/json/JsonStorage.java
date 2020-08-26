package team.cloudly.storage.json;

import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import team.cloudly.ActionClass;
import team.cloudly.actions.ActionBlock;
import team.cloudly.files.JsonFile;
import team.cloudly.storage.Storage;

import java.util.Collection;
import java.util.Map;

public class JsonStorage implements Storage {

    private final Plugin plugin;
    public JsonStorage(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public void saveAll(Collection<ActionBlock> actionBlocks) {
        JsonFile jsonFile = new JsonFile(plugin.getDataFolder(),"blocks");
        jsonFile.writeFile(ActionClass.getGson().toJson(actionBlocks));
    }

    @Override
    public Map<Location, ActionBlock> load() {
        JsonFile jsonFile = new JsonFile(plugin.getDataFolder(),"blocks");
        return null;
    }
}
