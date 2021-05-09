package Parser;

import com.google.gson.annotations.SerializedName;

public enum Relation {
    @SerializedName("=")
    EQUALITY("=") {
        @Override
        public String toQuery() {
            return "\"term\": {";
        }
    },

    @SerializedName("~")
    CONTAINS("~") {
        @Override
        public String toQuery() {
            return "\"match\": {";
        }
    },

    @SerializedName("!=")
    INEQUALITY("!=") {
        @Override
        public String toQuery() {
            return "\"must_not\": {";
        }
    },

    @SerializedName("!~")
    NOTCONTAINS("!~"),

    @SerializedName(">")
    MORE(">"),

    @SerializedName("<")
    LESS("<"),

    @SerializedName(">=")
    MOREOREQUAL(">="),

    @SerializedName("<=")
    LESSOREQUAL("<=");

    private String value;

    private Relation(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public String toQuery() { return null; }
}
