package Parser;

import com.google.gson.*;

import java.util.*;
import java.lang.reflect.Type;

public class OperationDeserializer implements JsonDeserializer<Operation> {
    @Override
    public Operation deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Operation operation = new Operation();

        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray operands = jsonObject.get("operands").getAsJsonArray();

        operation.setOperator(jsonObject.get("operator").getAsString());

        List<Operation> operationList= new ArrayList<>();
        for(JsonElement j: operands) {
            JsonObject jsonObject1 = j.getAsJsonObject();

            if(jsonObject1.has("name")) {
                Filter f = new Filter();
                f.setName(jsonObject1.get("name").getAsString());
                f.setValue(jsonObject1.get("value").getAsString());
                f.setRelation(jsonObject1.get("relation").getAsString());
                operationList.add(f);
            }
            else {
                Operation operation1 = deserialize(jsonObject1, typeOfT, context);
                operationList.add(operation1);
            }
        }

        Operation[] operations = new Operation[operationList.size()];
        operationList.toArray(operations);

        operation.setOperands(operations);
        return operation;
    }
}
