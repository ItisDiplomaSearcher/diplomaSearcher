package ru.itis.diplomasearcher.parser;

public class Filter extends FilterSet {
    private Name name;
    private String value;
    private Relation relation;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("\"bool\": {\"must\": {");
        sb.append(relation.toQuery());
        sb.append(" \"" + name + "\": \"" + value + "\"");
        sb.append(" } } }");

        return sb.toString();
    }

    @Override
    String getQuery() {
        return null;
    }
}
