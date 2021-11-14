package practice.anagram;

import java.util.Arrays;

public class Anagram {
  private static int EXTENDED_ASCII_CODES = 256;

  private static boolean checkInput(String str1, String str2) {
    return !(str1 == null || str2 == null || str1.isBlank() || str2.isBlank());
  }

  private static char[] processInput(String str) {
    return str.toLowerCase().replaceAll("\\s", "").toCharArray();
  }

  public static boolean isAnagram(String str1, String str2) {
    if (!checkInput(str1, str2))
      return false;
    char[] strChars1 = processInput(str1);
    char[] strChars2 = processInput(str2);
    if (strChars1.length != strChars2.length)
      return false;
    Arrays.sort(strChars1);
    Arrays.sort(strChars2);

    return Arrays.equals(strChars1, strChars2);
  }

  public static boolean isAnagram1(String str1, String str2) {
    if (!checkInput(str1, str2))
      return false;
    char[] strChars1 = processInput(str1);
    char[] strChars2 = processInput(str2);
    if (strChars1.length != strChars2.length)
      return false;

    int[] counts = new int[EXTENDED_ASCII_CODES];

    for (int i = 0; i < strChars1.length; i++) {
      counts[strChars1[i]]++;
      counts[strChars2[i]]--;
    }

    for (int i = 0; i < counts.length; i++) {
      if (counts[i] != 0)
        return false;
    }
    return true;
  }

  public static boolean isAnagram2(String str1, String str2) {
    if (!checkInput(str1, str2))
      return false;
    str1 = str1.toLowerCase().replaceAll("\\s", "");
    str2 = str2.toLowerCase().replaceAll("\\s", "");
    if (str1.length() != str2.length()) return false;
    return Arrays.equals(
      str1.chars().sorted().toArray(),
      str2.chars().sorted().toArray()
    );
  }
}
