package ru.itis.diplomasearcher.parser;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;


public class Filter extends FilterSet {
    private Name name;
    private String value;
    private Relation relation;

    @Override
    public SearchRequest getQuery() {
        return null;
    }

    @Override
    public BoolQueryBuilder getBoolQueryBuilder() {
        BoolQueryBuilder boolQueryBuilder = relation.getBoolQueryBuilder(name.name(), value);

        return boolQueryBuilder;
    }
}
