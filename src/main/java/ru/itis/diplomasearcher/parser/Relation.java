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
    NOTCONTAINS("!~") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().mustNot(QueryBuilders.termQuery(name, value));

            return boolQueryBuilder;
        }
    },

    @SerializedName(">")
    MORE(">") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery(name).from(value).includeLower(false));

            return boolQueryBuilder;
        }
    },

    @SerializedName("<")
    LESS("<") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery(name).to(value).includeLower(false));

            return boolQueryBuilder;
        }
    },

    @SerializedName(">=")
    MOREOREQUAL(">=") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery(name).from(value).includeLower(true));

            return boolQueryBuilder;
        }
    },

    @SerializedName("<=")
    LESSOREQUAL("<=") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(String name, String value) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery().must(QueryBuilders.rangeQuery(name).to(value).includeLower(true));

            return boolQueryBuilder;
        }
    };

    private String value;

    private Relation(String value) {
        this.value = value;
    }

    public String toString() {
        return this.value;
    }

    public BoolQueryBuilder getBoolQueryBuilder(String name, String value) { return null; }
}
