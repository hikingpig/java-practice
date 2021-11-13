package practice.palindrome;

import java.util.stream.IntStream;

public class Palindrome {
  public static boolean isPalindrome1(String str) {
    if (str == null || str.isBlank()) {
      return false;
    }
    for (int i = 0; i < str.length()/2; i++) {
      if (str.charAt(i) != str.charAt(str.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

  public static boolean isPalindrome2(String str) {
    if (str == null || str.isBlank()) {
      return false;
    }
    StringBuilder builder = new StringBuilder(str);
    return (str == builder.reverse().toString());
  }

  public static boolean isPalindrome3(String str) {
    if (str == null || str.isBlank()) {
      return false;
    }
    // noneMatch will reduce a stream to a boolean value
    return IntStream.range(0, str.length()/2).noneMatch(i -> str.charAt(i) != str.charAt(str.length() - 1 -i));
  }
}