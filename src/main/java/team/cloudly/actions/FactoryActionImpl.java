package team.cloudly.actions;

import team.cloudly.ActionClass;
import team.cloudly.actions.action.ActionMessage;

public class FactoryActionImpl implements FactoryAction {

    @Override
    public Action getAction(ActionType actionType, String identifier, ActionClass actionClass) {
        switch (actionType){
            case TITLE:

            break;
            case ACTIONBAR:

            break;
            case LOCATION:

            break;

            default:
                new ActionMessage(identifier);
        }
        return null;
    }
}
