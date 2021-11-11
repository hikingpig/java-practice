package practice.countCharacter;
import java.util.Objects;


public class CountCharacter {
  private static void checkInput(String str, String ch) {
    Objects.requireNonNull(str);
    Objects.requireNonNull(ch);
    if (ch.codePointCount(0, ch.length()) > 1) {
      throw new IllegalArgumentException("ch has more than 1 Unicode character");
    }
  }
  public static int countCharacter(String str, String ch) {
    checkInput(str, ch);
    int cp = ch.codePointAt(0);
    int charCount = Character.charCount(cp);
    return (str.length() - str.replace(ch, "").length())/charCount;
  }

  public static int countCharacter2(String str, String ch) {
    checkInput(str, ch);
    int count = 0;
    int charCp = ch.codePointAt(0);
    for (int i = 0; i < str.length(); i++) {
      if (charCp == str.codePointAt(i)) {
        count++;
      }
    }
    return count;
  }

  public static long countCharacter3(String str, String ch) {
    checkInput(str, ch);
    
    int charCp = ch.codePointAt(0);        
        
    return str.codePoints()
            .filter(c -> c == charCp)
            .count();

  }
}
