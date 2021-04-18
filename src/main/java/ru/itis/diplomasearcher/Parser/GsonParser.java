package Parser;

import com.google.gson.Gson;

public class GsonParser {
    private String json;

    public GsonParser(String json) {
        this.json = json;
    }

    public Filter getFilter() {
        Filter filter = new Filter();
        Gson gson = new Gson();

        filter = gson.fromJson(json, Filter.class);
        return filter;
    }
}
