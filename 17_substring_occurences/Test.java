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

    BiFunction<String, String, Integer> countSubstr = SubstringOccurence::countSubstring;
    System.out.println(measurePerformance(countSubstr, str, substr));

    BiFunction<String, String, Integer> countSubstr1 = SubstringOccurence::countSubstring1;
    System.out.println(measurePerformance(countSubstr1, str, substr));

    BiFunction<String, String, Integer> countSubstr2 = SubstringOccurence::countSubstring2;
    System.out.println(measurePerformance(countSubstr2, str, substr));

    BiFunction<String, String, Integer> countSubstr3 = SubstringOccurence::countSubstring3;
    System.out.println(measurePerformance(countSubstr3, str, substr));
    
    BiFunction<String, String, Integer> countSubstr4 = SubstringOccurence::countSubstring4;
    System.out.println(measurePerformance(countSubstr4, str, substr));
  }
}
