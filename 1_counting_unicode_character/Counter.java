package practice.countingUnicode;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class Counter {
  // user iteration to eliminate low-surrogate
  public static void countCharacters(StringBuilder buf, Map<String, Long> result) {
    for (int i = 0; i < buf.length(); i++) {
      int cp = buf.codePointAt(i);
      // skip the remaining surrogate due to buffering
      if (i == 0 && Character.isLowSurrogate(buf.charAt(i))) {
        continue;
      }
      String key = String.valueOf(Character.toChars(cp));
      if (Character.charCount(cp) == 2) {
        i++;
      }
      result.merge(key, 1L, Long::sum);
    }
  }

  // avoid generating a lot of objects by using primitive arrays
  // direct array manipulation can be unsafe and error-prone
  public static void countCharacters2(char[] chars, int[] result) {
    for (int i = 0; i < chars.length; i++) {
      int cp = Character.codePointAt(chars, i);
      // skip the low surrogate character
      if (Character.charCount(cp) == 2) {
        i++;
      }
      // skip remaining surrogate due to buffering
      if (i == 0 && Character.isLowSurrogate(chars[i])) {
        continue;
      }
      result[cp]++;
    }
  }
}
