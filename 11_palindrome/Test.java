package practice.Palindrome;

import static practice.helper.MeasurePerformance.*;
import practice.palindrome.Palindrome;

public class Test {
  private static final String TEXT = "ABCDEFEDCBA";
  public static void main(String[] args) {
    measurePerformance(Palindrome::isPalindrome1, TEXT);
    measurePerformance(Palindrome::isPalindrome2, TEXT);
    measurePerformance(Palindrome::isPalindrome3, TEXT);
  }
}
