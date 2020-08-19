package team.cloudly.actions;

import team.cloudly.actions.action.ActionExecutor;

public interface FactoryAction {

    ActionExecutor getActionExecutor(ActionType actionType, String identifier);

}
