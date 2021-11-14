package practice.remover;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CharRemover {
  private static void checkInput(String str, String ch) {
    Objects.requireNonNull(str);
    Objects.requireNonNull(ch);
    if (ch.codePointCount(0, ch.length()) > 1) {
      throw new IllegalArgumentException("ch has more than 1 Unicode character");
    }
  }
  // use StringBuilder
  public static String removeChar(String str, String ch) {
    checkInput(str, ch);
    StringBuilder builder = new StringBuilder();
    int charCp = ch.codePointAt(0);
    for (int i = 0; i < str.length(); i++) {
      int cp = str.codePointAt(i);
      if (cp != charCp) {
        builder.append(Character.toChars(cp));
      }
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }
    return builder.toString();
  }

  // use regex pattern and replaceAll
  public static String removeChar1(String str, String ch) {
    checkInput(str, ch);
    return str.replaceAll(Pattern.quote(ch), "");
  }

  public static String removeChar2(String str, String ch) {
    checkInput(str, ch);
    int charCp = ch.codePointAt(0);
    return str.codePoints().filter(cp -> cp != charCp)
                    .mapToObj(cp -> new String(Character.toChars(cp)))
                    .collect(Collectors.joining());
  }
}