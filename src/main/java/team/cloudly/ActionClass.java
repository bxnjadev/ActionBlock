package team.cloudly;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import team.cloudly.actions.ActionCache;
import team.cloudly.actions.ActionCacheImpl;
import team.cloudly.actions.FactoryAction;
import team.cloudly.actions.FactoryActionImpl;
import team.cloudly.commands.ActionCommand;
import team.cloudly.files.Configuration;
import team.cloudly.listener.InteractBlockListener;
import team.cloudly.storage.Storage;
import team.cloudly.storage.StorageFactoryImpl;
import team.cloudly.storage.StorageMethod;

public final class ActionClass extends JavaPlugin {

    private ActionCache actionCache;
    private Storage storage;
    private FactoryAction factoryAction;

    private static Gson gson;

    private Configuration configuration;

    @Override
    public void onEnable() {

        actionCache = new ActionCacheImpl();
        storage = new StorageFactoryImpl(this).getStorage(StorageMethod.JSON);
        registerListeners();
        registerCommands();

        gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();

        factoryAction = new FactoryActionImpl();
        loadFiles();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Storage getStorage(){
        return storage;
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
        this.getCommand("actionblock").setExecutor(new ActionCommand(this));
    }

    public static Gson getGson(){
        return gson;
    }

}
