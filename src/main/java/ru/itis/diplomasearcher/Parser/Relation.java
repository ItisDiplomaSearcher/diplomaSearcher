package Parser;

import com.google.gson.annotations.SerializedName;

public enum Relation {
    @SerializedName("=")
    equality("="),

    @SerializedName("~")
    contains("~"),

    @SerializedName("!=")
    inequality("!="),

    @SerializedName("!~")
    notcontains("!~"),

    @SerializedName(">")
    more(">"),

    @SerializedName("<")
    less("<"),

    @SerializedName(">=")
    moreorequal(">="),

    @SerializedName("<=")
    lessorequal("<=");

    private String value;

    private Relation(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }
}
