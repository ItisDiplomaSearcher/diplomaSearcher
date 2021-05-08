package Parser;

import lombok.Data;
import java.util.*;

@Data
public class Operation extends FilterSet {
    private Operator operator;
    private ArrayList<FilterSet> operands;

    @Override
    public String getQuery() {
        StringBuilder sb = new StringBuilder("");
        sb.append("{ \n \"query\": { ");

        sb.append(toString());

        sb.append(" } \n}");

        return sb.toString();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(" \"bool\": {" + operator.toQuery());

        Iterator<FilterSet> iterator = operands.iterator();
        while(iterator.hasNext()) {
            sb.append(iterator.next());
            if(iterator.hasNext()) sb.append(", ");
        }
        sb.append(" } } ");

        return sb.toString();
    }
}
