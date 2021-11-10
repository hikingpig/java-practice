package practice.FirstNonRepeatedChar;

import java.util.*;
import static java.util.stream.Collectors.*;

public class FunctionHome {
  public static final int EXTENDED_ASCII_CODES = 256;

  private static int[] ensureCapacity(int[] array, int pos) {
    if (pos >= array.length - 1) {
      return Arrays.copyOf(array, 2 * array.length + 1);
    }
    return array;
  }

  // this method adds characters as they appear
  // save the size of array to store all codepoints
  // but will pay the cost of more iteration
  public static String firstNonRepeatedChar(String s) {

    if (s == null || s.isBlank()) {
      // or throw IllegalArgumentException
      return "";
    }

    String result = "";
    // add the codepoint if it appears first time in the string
    int[] firstTimeCps = new int[EXTENDED_ASCII_CODES];
    int firstPos = 0;

    // add the codepoint if it appears second time in the string
    int[] repeatedCps = new int[EXTENDED_ASCII_CODES];
    int repeatedPos = 0;

    traverseString: for (int i = 0; i < s.length(); i++) {
      int cp = s.codePointAt(i);
      // skip low surrogate character
      if (Character.charCount(cp) == 2) {
        i++;
      }
      for (int repeat : repeatedCps) {
        // continue on the outside loop if found in repeated characters
        if (cp == repeat) {
          continue traverseString;
        }
      }
      for (int firstTime : firstTimeCps) {
        // if appear 2nd time, add it to repeated characters
        if (cp == firstTime) {
          repeatedCps = ensureCapacity(repeatedCps, repeatedPos);
          repeatedCps[repeatedPos] = cp;
          repeatedPos++;
          continue traverseString;
        }
      }
      // appears first time, add it to first time characters
      firstTimeCps = ensureCapacity(firstTimeCps, firstPos);
      firstTimeCps[firstPos] = cp;
      firstPos++;
    }

    // search for first non-repeated characters based on recorded info
    findFirstNonRepeated: for (int firstTime : firstTimeCps) {
      for (int repeated : repeatedCps) {
        if (firstTime == repeated) {
          continue findFirstNonRepeated;
        }
      }
      char[] chars = Character.toChars(firstTime);
      result = String.valueOf(chars);
    }
    return result;
  }

  // this method creates an array to store all codepoints
  // the array size is about 4MB and reduce iteration time greatly
  public static String firstNonRepeatedChar2(String str) {
    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return "";
    }

    int[] flags = new int[Character.MAX_CODE_POINT];

    for (int i = 0; i < flags.length; i++) {
      flags[i] = -1;
    }

    for (int i = 0; i < str.length(); i++) {

      int cp = str.codePointAt(i);

      // first time encounter character, assign value -1
      if (flags[cp] == -1) {
        flags[cp] = i;
        // repeated character, assign value -2
      } else {
        flags[cp] = -2;
      }
      // skip the low surrogate
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }

    int position = Integer.MAX_VALUE;
    for (int i = 0; i < flags.length; i++) {
      if (flags[i] >= 0) {
        position = Math.min(position, flags[i]);
      }
    }

    return position == Integer.MAX_VALUE ? "" : new String(Character.toChars(str.codePointAt(position)));
  }

  public static String firstNonRepeatedChar3(String str) {
    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return "";
    }
    Map<Integer, Integer> codepoints = new LinkedHashMap<>();

    // or use for(char ch: str.toCharArray()) { ... }
    for (int i = 0; i < str.length(); i++) {
      int cp = str.codePointAt(i);

      codepoints.merge(cp, 1, Integer::sum);
      // skip the low surrogate
      if (Character.charCount(cp) == 2) {
        i++;
      }
    }

    for (Map.Entry<Integer, Integer> entry : codepoints.entrySet()) {
      if (entry.getValue() == 1) {
        return new String(Character.toChars(entry.getKey()));
      }
    }
    return "";
  }

  public static String firstNonRepeatedChar4(String str) {
    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return "";
    }

    Map<Integer, Long> chs = str.codePoints().mapToObj(cp -> cp)
        .collect(groupingBy(cp -> cp, LinkedHashMap::new, counting()));

    int firstNonRepeatedCp =
      chs.entrySet()
        .stream()
        .filter(e -> e.getValue() == 1L)
        .findFirst().map(Map.Entry::getKey)
        .orElse(Integer.valueOf(Character.MIN_CODE_POINT));
    return new String(Character.toChars(firstNonRepeatedCp));
  }
}
