package team.cloudly.actions.action;

import me.supremeproject.SupremeText;
import org.bukkit.entity.Player;

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
    public String actionSerialize() {
        return message;
    }

}
