package practice.VowelConsonant;

import java.util.Objects;

public class VowelConsonantCounter {
  public static boolean isVowel(char c) {
    return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
  }
  public static boolean isConsonant(char c) {
    return (c >= 'a' && c <= 'z' && !isVowel(c));
  }

  public static int countVowels(String s) {
    Objects.requireNonNull(s);
    s = s.toLowerCase();
    int vowels = 0;
    for (int i = 0; i < s.length(); i++) {
      if (isVowel(s.charAt(i))) {
        vowels++;
      }
    }
    return vowels;
  }

  public static int countConsonants(String s) {
    Objects.requireNonNull(s);
    s = s.toLowerCase();
    int consonants = 0;
    for (int i = 0; i < s.length(); i++) {
      if (isConsonant(s.charAt(i))) {
        consonants++;
      }
    }
    return consonants;
  }

  public static long countConsonants2(String s) {
    Objects.requireNonNull(s);
    s = s.toLowerCase();

    return s.chars()
            .filter(c ->isConsonant((char) c))
            .count();
  }

  public static long countVowels2(String s) {
    Objects.requireNonNull(s);
    s = s.toLowerCase();

    return s.chars()
            .filter(c -> isVowel((char) c))
            .count();
  }
}
