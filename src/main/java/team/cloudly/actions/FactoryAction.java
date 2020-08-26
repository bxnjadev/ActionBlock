package team.cloudly.actions;

import java.util.Map;

public interface FactoryAction {

    ActionCache.ActionExecutor getAction(ActionType actionType, Map<String,Object> actionSerialize);

}
