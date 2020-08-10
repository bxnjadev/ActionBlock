package team.cloudly;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import team.cloudly.actions.ActionCache;
import team.cloudly.actions.ActionCacheImpl;
import team.cloudly.actions.FactoryAction;
import team.cloudly.actions.FactoryActionImpl;
import team.cloudly.files.Configuration;
import team.cloudly.listener.InteractBlockListener;
import team.cloudly.storage.Storage;
import team.cloudly.storage.StorageFactoryImpl;
import team.cloudly.storage.StorageMethod;

public final class ActionClass extends JavaPlugin {

    private ActionCache actionCache;
    private Storage storage;
    private FactoryAction factoryAction;

    private Configuration configuration;

    @Override
    public void onEnable() {

        actionCache = new ActionCacheImpl();
        storage = new StorageFactoryImpl(this).getStorage(StorageMethod.JSON);
        registerListeners();
        registerCommands();

        factoryAction = new FactoryActionImpl();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public ActionCache getActionCache(){
        return actionCache;
    }

    private void loadFiles(){
        configuration = new Configuration(this,"configuration");
    }

    private void registerListeners(){
        Bukkit.getPluginManager().registerEvents(new InteractBlockListener(actionCache),this);
    }

    public FactoryAction getFactoryAction(){
        return factoryAction;
    }

    private void registerCommands(){

    }

}
