package team.cloudly.actions;

import team.cloudly.actions.action.ActionExecutor;
import team.cloudly.actions.action.ActionMessage;

public class FactoryActionImpl implements FactoryAction {

    @Override
    public ActionExecutor getActionExecutor(ActionType actionType, String identifier) {
        switch (actionType){
            case TITLE:

            case ACTIONBAR:

            case LOCATION:

            default:
                new ActionMessage(identifier);
        }
        return null;
    }
}
