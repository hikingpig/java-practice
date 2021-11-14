package practice.joinStrings;

import static practice.helper.MeasurePerformance.measureVarargsFunction;

public class Test {

    private static final String TEXT_1 = "Illinois";
    private static final String TEXT_2 = "Mathematics";
    private static final String TEXT_3 = "and";
    private static final String TEXT_4 = "Science";
    private static final String TEXT_5 = "Academy";

    public static void main(String[] args) {

        String result1 = measureVarargsFunction(String::join, " ", TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
        System.out.println("Join by String.join result1: " + result1);

        System.out.println();

        String result2 = measureVarargsFunction(JoinStrings::joinByDelimiterV1, ' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
        System.out.println("Join by StringBuilder result: " + result2);

        System.out.println();

        String result3 = measureVarargsFunction(JoinStrings::joinByDelimiterV2, ' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
        System.out.println("Join by streams result: " + result3);

        System.out.println();
        
        String result4 = measureVarargsFunction(JoinStrings::joinByDelimiterV3, ' ', TEXT_1, TEXT_2, TEXT_3, TEXT_4, TEXT_5);
        System.out.println("Join by StringJoiner result: " + result4);
    }
}
