package team.cloudly.actions;

import team.cloudly.ActionClass;

public interface FactoryAction {

    Action getAction(ActionType actionType, String identifier);

}
