package team.cloudly.actions.action;

import org.bukkit.entity.Player;

public interface ActionExecutor {

    void execute(Player player);

    String actionSerialize();

}
