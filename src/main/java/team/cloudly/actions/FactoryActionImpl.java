package team.cloudly.actions;

import me.supremeproject.SupremeText;
import me.supremeproject.objects.Title;
import org.bukkit.Location;
import team.cloudly.actions.action.*;

import java.util.Map;

public class FactoryActionImpl implements FactoryAction {

    private final SupremeText supremeText;
    public FactoryActionImpl(SupremeText supremeText){
        this.supremeText = supremeText;
    }

    @Override
    public ActionCache.ActionExecutor getAction(ActionType actionType, Map<String, Object> actionSerialize) {

        switch (actionType){

            case TITLE:
                String titleName = (String) actionSerialize.get("title");
                String subtitleName = (String) actionSerialize.get("subtitle");
                int fadeInTime = (Integer) actionSerialize.get("fadeInTime");
                int fadeShowTime = (Integer) actionSerialize.get("fadeShowTime");
                int fadeOutTime = (Integer) actionSerialize.get("fadeOutTime");

                Title title = new Title(titleName, subtitleName, fadeInTime, fadeShowTime , fadeOutTime);

                return new ActionTitle(title,supremeText);
            case TELEPORT:
                return new ActionTeleport(Location.deserialize(actionSerialize));

            case ACTIONBAR:
                String messageAction = (String) actionSerialize.get("message");
                return new ActionActionBar(messageAction,supremeText);

            default:
                String message = (String) actionSerialize.get("message");
                return new ActionMessage(message);

        }

    }
}
