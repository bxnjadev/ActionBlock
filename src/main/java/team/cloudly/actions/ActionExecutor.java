package team.cloudly.actions;

import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.entity.Player;

public interface ActionExecutor extends ConfigurationSerializable {

    void execute(Player player);

}