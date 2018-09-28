package com.example.tp_t550.calculator80085;

import java.util.HashMap;
import java.util.Map;

public enum Operator {

    ADD("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), NULL("null");

    private final String value;

    private static final Map<String, Operator> lookup = new HashMap<String, Operator>();

    static {
        for (Operator o : Operator.values()) {
            lookup.put(o.getValue(), o);
        }
    }

    public static Operator getBySymbol (String value){
        return lookup.get(value);
    }

    Operator(String value) {
            this.value = value;
    }



    public String getValue() {
            return value;
        }
}
