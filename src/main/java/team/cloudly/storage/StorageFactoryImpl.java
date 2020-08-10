package team.cloudly.storage;

import org.bukkit.plugin.Plugin;

public class StorageFactoryImpl implements StorageFactory {

    private Plugin plugin;
    public StorageFactoryImpl(Plugin plugin){
        this.plugin = plugin;
    }

    @Override
    public Storage getStorage(StorageMethod storageMethod) {
        return null;
    }
}
