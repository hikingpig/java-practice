package practice.toNumber;

public class Main {

    private static final String TO_INT = "453";
    private static final String TO_LONG = "45234223233";
    private static final String TO_FLOAT = "45.823F";
    private static final String TO_DOUBLE = "13.83423D";

    private static final String TO_INT_NEGATIVE = "-453";
    private static final String TO_LONG_NEGATIVE = "-45234223233";
    private static final String TO_FLOAT_NEGATIVE = "-45.823F";
    private static final String TO_DOUBLE_NEGATIVE = "-13.83423D";

    private static final String WRONG_NUMBER = "452w";
    
    public static void main(String[] args) {

        // convert String to int/Integer
        Integer toInt1 = Integer.valueOf(TO_INT);                          // returns Integer
        int toInt2 = Integer.parseInt(TO_INT);                             // returns int
        Integer toIntNegative1 = Integer.valueOf(TO_INT_NEGATIVE);         // returns Integer
        int toIntNegative2 = Integer.parseInt(TO_INT_NEGATIVE);            // returns int

        // convert String to long/Long
        Long toLong1 = Long.valueOf(TO_LONG);                              // returns Long
        long toLong2 = Long.parseLong(TO_LONG);                            // returns long
        Long toLongNegative1 = Long.valueOf(TO_LONG_NEGATIVE);             // returns Long
        long toLongNegative2 = Long.parseLong(TO_LONG_NEGATIVE);           // returns long

        // convert String to float/Float
        Float toFloat1 = Float.valueOf(TO_FLOAT);                          // returns Float
        float toFloat2 = Float.parseFloat(TO_FLOAT);                       // returns float
        Float toFloatNegative1 = Float.valueOf(TO_FLOAT_NEGATIVE);         // returns Float
        float toFloatNegative2 = Float.parseFloat(TO_FLOAT_NEGATIVE);      // returns float

        // convert String to double/Double
        Double toDouble1 = Double.valueOf(TO_DOUBLE);                      // returns Double
        double toDouble2 = Double.parseDouble(TO_DOUBLE);                  // returns double
        Double toDoubleNegative1 = Double.valueOf(TO_DOUBLE_NEGATIVE);     // returns Double
        double toDoubleNegative2 = Double.parseDouble(TO_DOUBLE_NEGATIVE); // returns double

        System.out.format("\"%s\" as int is %d and as Integer is %d%n", TO_INT, toInt1, toInt2);
        System.out.format("\"%s\" as int is %d and as Integer is %d%n", TO_INT_NEGATIVE, toIntNegative1, toIntNegative2);

        System.out.format("\"%s\" as long is %d and as Long is %d%n", TO_LONG, toLong1, toLong2);
        System.out.format("\"%s\" as long is %d and as Long is %d%n", TO_LONG_NEGATIVE, toLongNegative1, toLongNegative2);

        System.out.format("\"%s\" as float is %f and as Float is %f%n", TO_FLOAT, toFloat1, toFloat2);
        System.out.format("\"%s\" as float is %f and as Float is %f%n", TO_FLOAT_NEGATIVE, toFloatNegative1, toFloatNegative2);

        System.out.format("\"%s\" as double is %f and as Double is %f%n", TO_DOUBLE, toDouble1, toDouble2);
        System.out.format("\"%s\" as double is %f and as Double is %f%n", TO_DOUBLE_NEGATIVE, toDoubleNegative1, toDoubleNegative2);

        try {
            Integer toIntWrong1 = Integer.valueOf(WRONG_NUMBER);
        } catch (NumberFormatException e) {
            System.err.println(e);
            // handle exception
        }

        try {
            int toIntWrong2 = Integer.parseInt(WRONG_NUMBER);
        } catch (NumberFormatException e) {
            System.err.println(e);
            // handle exception
        }
    }
}
