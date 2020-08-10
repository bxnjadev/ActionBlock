package team.cloudly.serialize;

import com.google.gson.*;
import team.cloudly.ActionClass;
import team.cloudly.actions.Action;
import team.cloudly.actions.ActionBlock;

import java.lang.reflect.Type;

public class ActionBlockSerialize implements GsonAdapter<ActionBlock> {

    private ActionClass actionClass;
    public ActionBlockSerialize(ActionClass actionClass){
        this.actionClass = actionClass;
    }

    @Override
    public ActionBlock deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        ActionBlock actionBlock = new ActionBlock();
        JsonArray jsonArray = json.getAsJsonArray();
        
        return null;
    }

    @Override
    public JsonElement serialize(ActionBlock src, Type typeOfSrc, JsonSerializationContext context) {
        JsonArray jsonArray = new JsonArray();

        for(Action action : src.getActions()){
            JsonObject actionObject = new JsonObject();
            actionObject.addProperty(action.getActionType().toString(),action.toString());
            jsonArray.add(actionObject);
        }

        return jsonArray;
    }
}
