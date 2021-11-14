package practice.substring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SubstringOccurence {
  private static boolean checkInput(String str, String substr) {
    if (str == null || substr == null) {
      throw new IllegalArgumentException("The given strings can not be null");
    }
    if (str.isBlank() || substr.isBlank()) {
      return false;
    }
    return true;
  }

  // indexOf may create a pattern and can be a performance hit!
  public static int countSubstring(String str, String substr) {
    if (!checkInput(str, substr))
      return 0;
    int count = 0;
    int position = 0;
    int n = substr.length();
    while ((position = str.indexOf(substr, position)) != -1) {
      count++;
      position += n;
    }
    return count;
  }

  public static int countSubstring1(String str, String substr) {
    if (!checkInput(str, substr))
      return 0;

    return str.split(Pattern.quote(substr), -1).length - 1;
  }

  public static int countSubstring2(String str, String substr) {
    if (!checkInput(str, substr))
      return 0;
    Pattern pattern = Pattern.compile(Pattern.quote(substr));
    Matcher matcher = pattern.matcher(str);

    int count = 0;
    int position = 0;

    while (matcher.find()) {
      count++;
      position = matcher.end();
    }
    return count;
  }

  public static int countSubstring3(String str, String substr) {
    if (!checkInput(str, substr))
      return 0;
    int count = 0;
    int position = 0;
    int n = substr.length();
    while ((position = str.indexOf(substr, position)) != -1) {
      count++;
      position += 1;
    }
    return count;
  }

  public static int countSubstring4(String str, String substr) {
    if (!checkInput(str, substr))
      return 0;
    Pattern pattern = Pattern.compile(Pattern.quote(substr));
    Matcher matcher = pattern.matcher(str);

    int count = 0;
    int position = 0;

    while (matcher.find(position)) {
      count++;
      position = matcher.start() + 1;
    }
    return count;
  }
}
