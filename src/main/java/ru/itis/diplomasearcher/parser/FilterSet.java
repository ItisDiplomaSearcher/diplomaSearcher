package ru.itis.diplomasearcher.parser;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;

public abstract class FilterSet {
    abstract public SearchRequest getQuery();
    abstract BoolQueryBuilder getBoolQueryBuilder();
}
