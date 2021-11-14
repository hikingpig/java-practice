package practice.palindrome;

import static practice.helper.MeasurePerformance.*;

public class Test {
  private static final String TEXT = "ABCDEFEDCBA";
  public static void main(String[] args) {
    measureFunction(Palindrome::isPalindrome1, TEXT);
    measureFunction(Palindrome::isPalindrome2, TEXT);
    measureFunction(Palindrome::isPalindrome3, TEXT);
  }
}
