package practice.prefix;
import static practice.helper.MeasurePerformance.*;

public class Test {
  private static String[] texts = {"abc", "abcd", "abcde", "ab", "abcd", "abcdef"};
  public static void main(String[] args) {
    System.out.println(measureFunction(Prefix::longestCommonPrefix, texts));
    System.out.println(measureFunction(Prefix::longestCommonPrefix1, texts));

  }
  
}
