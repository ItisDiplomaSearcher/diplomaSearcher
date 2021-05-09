package ru.itis.diplomasearcher.parser;

import com.google.gson.*;
import java.lang.reflect.Type;
import java.util.*;

public class Deserializer implements JsonDeserializer<FilterSet>
{
    @Override
    public FilterSet deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        JsonObject jsonObject = json.getAsJsonObject();

        Operation operation = new Operation();
        operation.setOperator(Operator.valueOf(jsonObject.get("operator").getAsString()));

        JsonArray jsonArray = jsonObject.get("operands").getAsJsonArray();
        ArrayList<FilterSet> operands = new ArrayList<>();

        for(JsonElement jsonElement : jsonArray) {
            JsonObject operandJson = jsonElement.getAsJsonObject();
            FilterSet operand;

            if(operandJson.has("name")) {
                Gson gs = new Gson();
                operand = gs.fromJson(operandJson, Filter.class);
            }
            else {
                operand = deserialize(operandJson, typeOfT, context);
            }

            operands.add(operand);
        }

        operation.setOperands(operands);

        return operation;
    }
}
