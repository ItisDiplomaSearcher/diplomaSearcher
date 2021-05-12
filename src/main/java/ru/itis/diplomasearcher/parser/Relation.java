package ru.itis.diplomasearcher.parser;

import com.google.gson.annotations.SerializedName;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

public enum Relation {
    @SerializedName("=")
    EQUALITY("=") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery(name, value));

            return boolQueryBuilder;
        }
    },

    @SerializedName("~")
    CONTAINS("~") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.termQuery(name, value));

            return boolQueryBuilder;
        }
    },

    @SerializedName("!=")
    INEQUALITY("!=") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().mustNot(QueryBuilders.matchQuery(name, value));

            return boolQueryBuilder;
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

    public BoolQueryBuilder getBoolQueryBuilder(String name, String value) { return null; }
}
