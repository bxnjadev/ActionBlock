package team.cloudly;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import team.cloudly.actions.*;
import team.cloudly.commands.ActionCommand;
import team.cloudly.files.Configuration;
import team.cloudly.listener.InteractBlockListener;
import team.cloudly.serialize.ActionBlockSerialize;
import team.cloudly.storage.Storage;
import team.cloudly.storage.StorageFactoryImpl;
import team.cloudly.storage.StorageMethod;

public final class ActionClass extends JavaPlugin {

    private ActionCache actionCache;
    private Storage storage;
    private FactoryAction factoryAction;

    private static Gson gson;

    @Override
    public void onEnable() {

        actionCache = new ActionCacheImpl();
        storage = new StorageFactoryImpl(this).getStorage(StorageMethod.JSON);
        registerListeners();
        registerCommands();

        factoryAction = new FactoryActionImpl();

        gson = new GsonBuilder()
                .registerTypeAdapter(ActionBlock.class,new ActionBlockSerialize(factoryAction))
                .setPrettyPrinting()
                .create();

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
        new Configuration(this,"config");
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
