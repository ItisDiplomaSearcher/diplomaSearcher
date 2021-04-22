package Parser;

import lombok.Data;

@Data
public class Filter extends Operation{

    private String name;
    private String value;
    private String relation;

    public String toString() {
        StringBuilder sb = new StringBuilder("");
        sb.append(" { filter: ");
        sb.append(name).append(", ").append(value).append(", ").append(relation);
        sb.append(" } ");
        return sb.toString();
    }
}
