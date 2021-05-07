package Parser;

import com.google.gson.annotations.SerializedName;

public enum Relation {
    @SerializedName("=")
    EQUALITY("="),

    @SerializedName("~")
    CONTAINS("~"),

    @SerializedName("!=")
    INEQUALITY("!="),

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
}
