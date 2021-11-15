package practice.repeat;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Repeat {

  public static String concatRepeatStream(String str, int n) {
    if (str == null || str.isBlank())
      return "";
    if (n <= 0)
      return str;
    if (Integer.MAX_VALUE / n < str.length()) {
      throw new OutOfMemoryError("Maximum size of a String will be exceeded");
    }
    return Stream.generate(() -> str).limit(n).collect(Collectors.joining());
  }

  public static String concatRepeatBuilder(String str, int n) {
    if (str == null || str.isBlank())
      return "";
    if (n <= 0)
      return str;
    if (Integer.MAX_VALUE / n < str.length()) {
      throw new OutOfMemoryError("Maximum size of a String will be exceeded");
    }
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < n; i++) {
      builder.append(str);
    }
    return builder.toString();
  }

  public static String concatRepeatNcopies(String str, int n) {
    if (str == null || str.isBlank())
      return "";
    if (n <= 0)
      return str;
    if (Integer.MAX_VALUE / n < str.length()) {
      throw new OutOfMemoryError("Maximum size of a String will be exceeded");
    }
    return String.join("", Collections.nCopies(n, str));
  }

  public static String concatRepeatCharArr(String str, int n) {
    if (str == null || str.isBlank())
      return "";
    if (n <= 0)
      return str;
    if (Integer.MAX_VALUE / n < str.length()) {
      throw new OutOfMemoryError("Maximum size of a String will be exceeded");
    }
    char[] arr = new char[n];

    return new String(arr).replaceAll("\0", str);
  }

  public static String concatRepeatFormat(String str, int n) {
    if (str == null || str.isBlank())
      return "";
    if (n <= 0)
      return str;
    if (Integer.MAX_VALUE / n < str.length()) {
      throw new OutOfMemoryError("Maximum size of a String will be exceeded");
    }
    return String.format("%0" + n + "d", 0).replaceAll("\0", str);
  }

  // check if the string is made of 2 or more substrings
  public static boolean hasOnlySubstring(String str) {
    if (str == null || str.length() < 2)
      return false;
    StringBuilder buf = new StringBuilder();
    for (int i = 0; i < str.length() / 2; i++) {
      buf.append(str.charAt(i));
      String resultString = str.replaceAll(buf.toString(), "");
      if (resultString.length() == 0)
        return true;
    }
    return false;
  }
}
