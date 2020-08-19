package team.cloudly.actions.action;

import me.supremeproject.SupremeText;
import me.supremeproject.objects.Title;
import org.bukkit.entity.Player;

public class ActionTitle implements ActionExecutor {

    private final Title title;
    private final SupremeText supremeText;
    public ActionTitle(Title title, SupremeText supremeText){
        this.title = title;
        this.supremeText = supremeText;
    }

    @Override
    public void execute(Player player) {
        supremeText.sendTitle(player,title);
    }

    @Override
    public String actionSerialize() {
        return null;
    }

}
