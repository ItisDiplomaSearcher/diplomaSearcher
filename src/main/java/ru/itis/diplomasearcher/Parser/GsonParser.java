package ru.itis.diplomasearcher.Parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class GsonParser {
    private String json;

    public GsonParser(String json) {
        this.json = json;
    }

    public Operation getOperation() {
        Gson gs = new GsonBuilder()
                .registerTypeAdapter(Operation.class, new OperationDeserializer())
                .create();

        Operation operation = gs.fromJson(json, Operation.class);
        return operation;
    }
}
