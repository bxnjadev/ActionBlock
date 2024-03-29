package team.cloudly.actions.action;

import me.supremeproject.SupremeText;
import org.bukkit.entity.Player;
import team.cloudly.actions.ActionExecutor;

import java.util.HashMap;
import java.util.Map;

public class ActionActionBar implements ActionExecutor {

    private final String message;
    private final SupremeText supremeText;
    public ActionActionBar(String message, SupremeText supremeText){
        this.message = message;
        this.supremeText = supremeText;
    }

    @Override
    public void execute(Player player) {
        supremeText.sendActionBar(player,message);
    }

    @Override
    public Map<String, Object> serialize() {
        Map<String,Object> serializeAction = new HashMap<>();

        serializeAction.put("message",message);
        return serializeAction;
    }
}
