package Parser;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Data;

@Data
public class GsonParser {
    private static String json;

    public GsonParser(String json) {
        this.json = json;
    }

    public static FilterSet getFilterSet() {
        Gson gs = new GsonBuilder()
                .registerTypeAdapter(FilterSet.class, new Deserializer())
                .create();
        FilterSet filterSet = gs.fromJson(json, FilterSet.class);

        return filterSet;
    }
}
