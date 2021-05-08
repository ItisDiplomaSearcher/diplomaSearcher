package Parser;

public enum Operator {
    AND("AND") {
        @Override
        public String toQuery() {
            return "\"must\": {";
        }
    },
    OR("OR") {
        @Override
        public String toQuery() {
            return "\"should\": {";
        }
    };

    private String value;

    private Operator(String value) {
        this.value = value;
    }

    public String toQuery() { return null; }
}
