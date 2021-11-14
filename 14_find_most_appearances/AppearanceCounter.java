package practice.appearance;

import java.util.HashMap;
import java.util.Map;
import static java.util.Map.Entry.comparingByValue;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class AppearanceCounter {
  private static boolean checkInput(String str) {
    if (str == null || str.isBlank()) {
      return false;
    }
    return true;
  }

  // store counts of unicode points in an array
  public static String findMostAppearances(String str) {
    if (!checkInput(str)) return "";
    
    int[] counts = new int[Character.MAX_CODE_POINT];

    // count unicode point appearance
    for (int i = 0; i < str.length(); i++) {
      int cp = str.codePointAt(i);
      // ignore whitespaces
      if (!Character.isWhitespace(cp)) {
        counts[cp]++;
      }
      // skip low surrogate
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }
    int maxCount = 0;
    int resultCodePoint = Character.MIN_CODE_POINT;
    for (int i = 0; i < counts.length; i++) {
      if (maxCount < counts[i]) {
        resultCodePoint = i;
        maxCount = counts[i];
      }
    }
    return new String(Character.toChars(resultCodePoint));
  }

  public static String findMostAppearances1(String str) {
    if (!checkInput(str)) return "";
    Map<Integer, Integer> codepointCounts = new HashMap<>();
    for (int i = 0; i< str.length(); i++) {
      int cp = str.codePointAt(i);
      if (!Character.isWhitespace(cp)) {
        codepointCounts.merge(cp, 1, Integer::sum);
      }
      // skip low surrogate
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }
    int resultCodePoint = Character.MIN_CODE_POINT;
    int maxCount = 0;
    for (Map.Entry<Integer, Integer> entry : codepointCounts.entrySet()) {
      int value = entry.getValue();
      if (value > maxCount) {
        maxCount = value;
        resultCodePoint = entry.getKey();
      }
    }
    return new String(Character.toChars(resultCodePoint));
  }

  public static String findMostAppearances2(String str) {
    if (!checkInput(str)) return "";
    
    return str.codePoints()
              .filter(cp -> !Character.isWhitespace(cp))
              .boxed()
              .collect(groupingBy(cp -> cp, counting()))
              .entrySet().stream()
              .max(comparingByValue())
              .map(entry -> new String(Character.toChars(entry.getKey())))
              .orElse("");
  }
}
