package practice.removeWhiteSpaces;

import java.util.Objects;

public class RemoveWhiteSpaces {
  public static String removeWhiteSpaces(String s) {
    Objects.requireNonNull(s);
    return s.replaceAll("\\s", "");
  }
}
