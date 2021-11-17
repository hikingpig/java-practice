package practice.nullcheck;

import java.util.Arrays;
import java.util.List;
import static practice.helper.MeasurePerformance.*;

public class Test {
  public static void main(String[] args) {
    List<Integer> integers = Arrays.asList(1, 2, null, 3, 4, null, 5, null);
    System.out.println(measureFunction(ListHandler::sumInteger, integers));
    System.out.println(measureFunction(ListHandler::containsNull, integers));
    System.out.println(measureFunction(ListHandler::evenIntegers, integers));
  }
}