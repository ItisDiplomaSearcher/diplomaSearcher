package Parser;

import lombok.Data;
import java.util.*;

@Data
public class Operation extends FilterSet {
    private Operator operator;
    private ArrayList<FilterSet> operands;

    public ArrayList<String> getQueries() {
        return new ArrayList<>();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("operator: " + operator + ", operands: " + operands);

        return sb.toString();
    }
}
