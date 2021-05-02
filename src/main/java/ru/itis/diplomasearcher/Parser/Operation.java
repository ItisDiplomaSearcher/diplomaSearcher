package Parser;

import lombok.Data;
import java.util.*;

@Data
public class Operation {
    private Name name;
    private String value;
    private Relation relation;

    private Operator operator;
    private ArrayList<Operation> operands;

    public ArrayList<String> getQueries() {
        return new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        if(name != null) {
            sb.append(" { " + name + ", " + value + ", " + relation + " }");
        }
        else {
            sb.append("operator: " + operator + ", operands: " + operands);
        }
        return sb.toString();
    }
}
