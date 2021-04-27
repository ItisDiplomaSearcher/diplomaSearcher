package ru.itis.diplomasearcher.Parser;

import lombok.Data;
import java.util.*;

@Data
public class Operation {
    private String operator;
    private Operation[] operands;

    public String toString() {
        return " { Operation: " + "operator: " + operator + ", operands: " + Arrays.toString(operands) + " } ";
    }
}
