package practice.onlyDigit;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OnlyDigit {

  private static Pattern pattern = Pattern.compile("^[0-9]+$");

  public static boolean onlyDigit(String s) {
    Matcher matcher = pattern.matcher(s);
    if (matcher.find()) {
      return true;
    }
    return false;
  }

  public static boolean onlyDigit2(String str) {

    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return false;
    }

    for (int i = 0; i < str.length(); i++) {
      if (!Character.isDigit(str.charAt(i))) {
        return false;
      }
    }

    return true;
  }

  public static boolean onlyDigit3(String str) {

    if (str == null || str.isBlank()) {
        // or throw IllegalArgumentException
        return false;
    }

    return !str.chars()
            .anyMatch(n -> !Character.isDigit(n));
}
}
