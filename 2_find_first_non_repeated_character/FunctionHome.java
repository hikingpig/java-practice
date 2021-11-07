package practice.FirstNonRepeatedChar;

import java.util.Arrays;
import java.util.Random;

public class FunctionHome {
  private static int[] ensureCapacity(int[] array, int pos) {
    if (pos >= array.length - 1) {
      return Arrays.copyOf(array, 2 * array.length + 1);
    }
    return array;
  }

  public static String findFirstNonRepeatedChar(String s) {
    String result = "";
    // add the codepoint if it appears first time in the string
    int[] firstTimeCps = new int[256];
    int firstPos = 0;

    // add the codepoint if it appears second time in the string
    int[] repeatedCps = new int[256];
    int repeatedPos = 0;

    traverseString:
    for (int i = 0; i < s.length(); i++) {
      int cp = s.codePointAt(i);
      // skip low surrogate character
      if (Character.charCount(cp) == 2) {
        i++;
      }
      for (int repeat: repeatedCps) {
        // continue on the outside loop if found in repeated characters
        if (cp == repeat) {
          continue traverseString;
        }
      }
      for (int firstTime: firstTimeCps) {
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
    findFirstNonRepeated:
    for (int firstTime : firstTimeCps) {
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

}
