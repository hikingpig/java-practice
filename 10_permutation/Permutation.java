package practice.permutation;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Permutation {
  public static void permuteAndPrint(String str) {

    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return;
    }

    permuteAndPrint("", str);
  }

  private static void permuteAndPrint(String prefix, String str) {
    int n = str.length();
    if (n == 0) {
      System.out.print(prefix + " ");
    } else {
      for (int i = 0; i < n; i++) {
        permuteAndPrint(prefix + str.charAt(i), str.substring(i + 1, n) + str.substring(0, i));
      }
    }
  }

  // use char[] for performance
  public static void permuteAndPrint1(String str) {

    if (str == null || str.length() == 0) {
      // or throw IllegalArgumentException
      return;
    }
    permuteAndPrint1(new char[0], str.toCharArray());
  }

  private static void permuteAndPrint1(char[] prefix, char[] str) {
    if (str.length == 0) {
      System.out.print(new String(prefix) + " ");
    } else {
      for (int i = 0; i < str.length; i++) {
        char[] newPrefix = Arrays.copyOf(prefix, prefix.length + 1);

        // append a new element to prefix from str
        newPrefix[newPrefix.length - 1] = str[i];

        char[] newstr = new char[str.length - 1];
        // copy everything from str, except for str[i]
        for (int k = 0; k < str.length; k++) {
          if (k == i) {
            continue;
          } else if (k > i) {
            newstr[k - 1] = str[k];
          } else {
            newstr[k] = str[k];
          }
        }
        permuteAndPrint1(newPrefix, newstr);
      }
    }
  }

  public static Set<String> permuteAndStore(String str) {
    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return Collections.emptySet();
    }
    Set<String> set = new HashSet<>();

    permuteAndStore(new char[0], str.toCharArray(), set);
    return set;
  }

  public static void permuteAndStore(char[] prefix, char[] str, Set<String> set) {
    if (str.length == 0) {
      set.add(new String(prefix));
    } else {
      for (int i = 0; i < str.length; i++) {
        char[] newPrefix = Arrays.copyOf(prefix, prefix.length + 1);

        // append a new element to prefix from str
        newPrefix[newPrefix.length - 1] = str[i];

        char[] newstr = new char[str.length - 1];
        // copy everything from str, except for str[i]
        for (int k = 0; k < str.length; k++) {
          if (k == i) {
            continue;
          } else if (k > i) {
            newstr[k - 1] = str[k];
          } else {
            newstr[k] = str[k];
          }
        }
        permuteAndStore(newPrefix, newstr, set);
      }
    }
  }

  public static void permuteAndPrintStream(String str) {

    if (str == null || str.isBlank()) {
      // or throw IllegalArgumentException
      return;
    }

    permuteAndPrintStream(new char[0], str.toCharArray());

  }

  private static void permuteAndPrintStream(char[] prefix, char[] str) {
    if (str.length == 0) {
      System.out.print(new String(prefix) + " ");
    } else {
      IntStream.range(0, str.length).parallel().forEach(i -> {
        char[] newPrefix = Arrays.copyOf(prefix, prefix.length + 1);

        // append a new element to prefix from str
        newPrefix[newPrefix.length - 1] = str[i];

        char[] newstr = new char[str.length - 1];
        // copy everything from str, except for str[i]
        for (int k = 0; k < str.length; k++) {
          if (k == i) {
            continue;
          } else if (k > i) {
            newstr[k - 1] = str[k];
          } else {
            newstr[k] = str[k];
          }
        }
        permuteAndPrintStream(newPrefix, newstr);
      });
    }
  }

  public static Stream<String> permuteAndReturnStream1(String str) {
    if (str == null) {
      return Stream.of("");
    }
    return permuteAndReturnStream1(str.toCharArray()).map(arr -> new String(arr));
  }

  private static Stream<char[]> permuteAndReturnStream1(char[] str) {
    if (str.length == 0) {
      return Stream.of(new char[0]);
    }
    return IntStream.range(0, str.length).boxed().flatMap(i -> {
      char[] newStr = new char[str.length - 1];
      // copy everything to newStr, except for str[i]
      for (int k = 0; k < str.length; k++) {
        if (k == i) {
          continue;
        } else if (k > i) {
          newStr[k - 1] = str[k];
        } else {
          newStr[k] = str[k];
        }
      }

      return permuteAndReturnStream1(newStr).map(arr -> {
        char[] newArr = new char[arr.length + 1];
        newArr[0] = str[i];
        for (int k = 0; k < arr.length; k++) {
          newArr[k+1] = arr[k];
        }
        return newArr;
      });
    });
  }

  public static Stream<String> permuteAndReturnStream(String str) {
    if (str == null || str.isBlank()) {
      return Stream.of("");
    }
    return IntStream.range(0, str.length()).boxed().flatMap(i -> {
      return permuteAndReturnStream(str.substring(0, i) + str.substring(i + 1)).map(c -> {
        return str.charAt(i) + c;
      });
    });
  }

}
