package Parser;

import com.google.gson.Gson;
import lombok.Data;

@Data
public class GsonParser {
    private static String json;

    public GsonParser(String json) {
        this.json = json;
    }

    public static Operation getOperation() {
        Gson gs = new Gson();
        Operation operation = gs.fromJson(json, Operation.class);
        
        return operation;
    }
}
