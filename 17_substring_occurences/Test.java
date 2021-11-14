package practice.substring;
import static practice.helper.MeasurePerformance.*;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Test {
  private static final String STRING = "111111";
  private static final String SUBSTRING = "11";
  public static void main(String[] args) {
    char[] strChars = new char[200_000];
    Arrays.fill(strChars, '1');
    String str = new String(strChars);
    String substr = "11";

    System.out.println(measureBiFunction(SubstringOccurence::countSubstring, str, substr));

    System.out.println(measureBiFunction(SubstringOccurence::countSubstring1, str, substr));

    System.out.println(measureBiFunction(SubstringOccurence::countSubstring2, str, substr));

    System.out.println(measureBiFunction(SubstringOccurence::countSubstring3, str, substr));
    
    System.out.println(measureBiFunction(SubstringOccurence::countSubstring4, str, substr));
  }
}
