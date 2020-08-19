package team.cloudly.actions;

import team.cloudly.actions.action.ActionExecutor;

public abstract class Action {

    private final ActionExecutor actionExecutor;
    private final String permission;
    private final ActionType actionType;

    public Action(String permission, ActionExecutor actionExecutor, ActionType actionType){
        this.permission = permission;
        this.actionExecutor = actionExecutor;
        this.actionType = actionType;
    }

    public Action(ActionExecutor actionExecutor, ActionType actionType){
        this.actionExecutor = actionExecutor;
        this.permission = "";
        this.actionType = actionType;
    }

    public boolean hasPermission(){
        return permission.isEmpty();
    }

    public ActionExecutor getExecutor(){
        return actionExecutor;
    }

    public String getPermission(){
        return permission;
    }

    public String actionSerialize(){
        return "";
    }

    public ActionType getActionType(){
        return actionType;
    }

}
