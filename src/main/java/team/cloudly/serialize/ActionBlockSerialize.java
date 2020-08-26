package team.cloudly.serialize;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import team.cloudly.actions.ActionBlock;
import team.cloudly.actions.FactoryAction;

import java.lang.reflect.Type;

public class ActionBlockSerialize implements JsonSerializer<ActionBlock>, JsonDeserializer<ActionBlock> {

    private final FactoryAction factoryAction;
    public ActionBlockSerialize(FactoryAction factoryAction){
        this.factoryAction = factoryAction;
    }

    @Override
    public ActionBlock deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

    }

    @Override
    public JsonElement serialize(ActionBlock src, Type typeOfSrc, JsonSerializationContext context) {

    }
}
