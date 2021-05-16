package ru.itis.diplomasearcher.parser;

import lombok.Data;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;

import java.util.*;

@Data
public class Operation extends FilterSet {
    private Operator operator;
    private ArrayList<FilterSet> operands;

    @Override
    public SearchRequest getQuery() {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();

        BoolQueryBuilder boolQueryBuilder = operator.getBoolQueryBuilder(operands);
        searchSourceBuilder.query(boolQueryBuilder);

        searchRequest.source(searchSourceBuilder);
        return searchRequest;
    }

    @Override
    public BoolQueryBuilder getBoolQueryBuilder() {
        BoolQueryBuilder boolQueryBuilder = operator.getBoolQueryBuilder(operands);

        return boolQueryBuilder;
    }
}
