package team.cloudly.storage;

import org.bukkit.plugin.Plugin;
import team.cloudly.storage.json.JsonStorage;

public class StorageFactoryImpl implements StorageFactory {

    private Plugin plugin;
    public StorageFactoryImpl(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public Storage getStorage(StorageMethod storageMethod) {
        return new JsonStorage(plugin);
    }
}
