package practice.duplicate;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateRm {
  private static boolean checkInput(String str) {
    if (str == null || str.isBlank()) {
      return false;
    }
    return true;
  }
  // quadratic complexity solution
  public static String rmDuplicate(String str) {
    if (!checkInput(str)) return "";

    StringBuilder builder = new StringBuilder(str);
    StringBuilder newBuilder = new StringBuilder();

    int pos = 0;
    while (pos < builder.length()) {
      int cp = builder.codePointAt(pos);
      int charCount = Character.charCount(cp);
      newBuilder.append(builder, pos, pos + charCount);
      for (int i = pos + charCount; i < builder.length(); i++) {
        int newcp = builder.codePointAt(i);
        int newCharCount = Character.charCount(newcp);
        if (newcp != cp) {
          newBuilder.append(builder, i, i + newCharCount);
        }
        if (newCharCount == 2) {
          i++;
        }
      }
      builder.setLength(0);
      builder.append(newBuilder);
      if (charCount == 2) {
        pos += 2;
      } else {
        pos++;
      }
      newBuilder.setLength(pos);
    }
    return builder.toString();
  }

  // Set solution
  public static String rmDuplicate1(String str) {
    if (!checkInput(str)) return "";

    Set<String> set = new LinkedHashSet<>();
    for (int i = 0; i < str.length(); i++) {
      int cp = str.codePointAt(i);
      set.add(new String(Character.toChars(cp)));
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }
    StringBuilder builder = new StringBuilder();
    for (String s: set) {
      builder.append(s);
    }
    return builder.toString();
  }

  public static String rmDuplicate2(String str) {
    if (!checkInput(str)) return "";

    int[] firstPositions = new int[Character.MAX_CODE_POINT];
    Arrays.fill(firstPositions, -1);

    for (int i = 0; i < str.length(); i++) {
      int cp = str.codePointAt(i);
      if (firstPositions[cp] < 0) {
        firstPositions[cp] = i;
      }
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }

    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      int cp = str.codePointAt(i);
      if (firstPositions[cp] == i) {
        builder.append(Character.toChars(cp));
      }
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }
    return builder.toString();
  }

  public static String rmDuplicate3(String str) {
    if (!checkInput(str)) return "";

    return str.codePoints().distinct().mapToObj(cp -> new String(Character.toChars(cp))).collect(Collectors.joining());

  }
}
