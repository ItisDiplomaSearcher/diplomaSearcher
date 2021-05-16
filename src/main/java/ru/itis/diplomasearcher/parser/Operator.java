package ru.itis.diplomasearcher.parser;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;

import java.util.*;

public enum Operator {
    AND("AND") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(ArrayList<FilterSet> operands) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

            for(FilterSet filterSet: operands) {
                boolQueryBuilder.must(filterSet.getBoolQueryBuilder());
            }

            return boolQueryBuilder;
        }
    },
    OR("OR") {
        @Override
        public BoolQueryBuilder getBoolQueryBuilder(ArrayList<FilterSet> operands) {
            BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

            for(FilterSet filterSet: operands) {
                boolQueryBuilder.should(filterSet.getBoolQueryBuilder());
            }

            return boolQueryBuilder;
        }
    };

    private String value;

    private Operator(String value) {
        this.value = value;
    }

    public BoolQueryBuilder getBoolQueryBuilder(ArrayList<FilterSet> operands) { return null; }
}
