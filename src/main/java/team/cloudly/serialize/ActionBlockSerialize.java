package team.cloudly.serialize;

import com.google.gson.*;
import org.bukkit.Location;
import org.bukkit.block.Block;
import team.cloudly.actions.Action;
import team.cloudly.actions.ActionBlock;
import team.cloudly.actions.ActionType;
import team.cloudly.actions.FactoryAction;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ActionBlockSerialize implements GsonAdapter<ActionBlock> {

    private final FactoryAction factoryAction;
    public ActionBlockSerialize(FactoryAction factoryAction){
        this.factoryAction = factoryAction;
    }

    @Override
    public ActionBlock deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject jsonObject = json.getAsJsonObject();

        String locationString = jsonObject.get("Location-Block").getAsString();
        Location location = LocationSerialize.stringToLocation(locationString);
        Block block = location.getBlock();

        List<Action> actions = new ArrayList<>();
        JsonArray jsonArray = jsonObject.get("Actions").getAsJsonArray();

        jsonArray.forEach(actionJson -> {
            JsonObject actionObject = actionJson.getAsJsonObject();

            ActionType actionType = ActionType.valueOf(actionObject.get("Type").getAsString());
            String identifier = actionObject.get("Identifier").getAsString();

            Action action = factoryAction.getAction(actionType,identifier);
            actions.add(action);
        });

        return new ActionBlock(block,actions);
    }

    @Override
    public JsonElement serialize(ActionBlock src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject jsonObject = new JsonObject();
        JsonArray actions = new JsonArray();

        jsonObject.addProperty("Location-Block",LocationSerialize.locationToString(src.getBlock().getLocation()));

        for(Action action : src.getActions()){

            JsonObject objectAction = new JsonObject();
            objectAction.addProperty("Type",action.getActionType().toString());
            objectAction.addProperty("Identifier",action.toString());

            actions.add(objectAction);
        }
        jsonObject.add("Actions",actions);

        return jsonObject;
    }
}
