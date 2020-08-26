package team.cloudly.actions.action;

import me.supremeproject.SupremeText;
import me.supremeproject.objects.Title;
import org.bukkit.entity.Player;
import team.cloudly.actions.ActionCache;
import team.cloudly.actions.ActionExecutor;

import java.util.HashMap;
import java.util.Map;

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
    public Map<String, Object> serialize() {
        Map<String,Object> serializeAction = new HashMap<>();

        serializeAction.put("title",title.getTitle());
        serializeAction.put("subtitle",title.getSubtitle());
        serializeAction.put("FadeInTime",title.getFadeInTime());
        serializeAction.put("FadeShowTime",title.getFadeShowTime());
        serializeAction.put("FadeOutTime",title.getFadeOutTime());

        return serializeAction;
    }

}
