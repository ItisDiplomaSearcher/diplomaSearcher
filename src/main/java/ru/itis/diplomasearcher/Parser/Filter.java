package Parser;

public class Filter extends FilterSet {
    private Name name;
    private String value;
    private Relation relation;

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(" { " + name + ", " + value + ", " + relation + " }");

        return sb.toString();
    }
}
