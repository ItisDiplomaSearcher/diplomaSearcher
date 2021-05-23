package ru.itis.diplomasearcher.parser;

import com.google.gson.annotations.SerializedName;

public enum Name {
    @SerializedName(value = "TITLE", alternate = "title")
    TITLE,
    @SerializedName(value = "ADVISOR", alternate = "advisor")
    ADVISOR,
    @SerializedName(value = "YEAR", alternate = "year")
    YEAR,
    @SerializedName(value = "AUTHOR", alternate = "author")
    AUTHOR,
    @SerializedName(value = "LEVEL", alternate = "level")
    LEVEL,
    @SerializedName(value = "TEXT", alternate = "text")
    TEXT;

    public String value() {
        return name().toLowerCase();
    }
}
