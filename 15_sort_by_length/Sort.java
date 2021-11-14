package practice.sort;

import java.util.Arrays;
import java.util.Comparator;

public class Sort {
  public enum Direction {
    ASC, DESC
  }

  private static boolean checkInput(String[] arr) {
    if (arr == null || arr.length == 0)
      return false;
    return true;
  }

  public static void sortByLength(String[] arr, Direction direction) {
    if (!checkInput(arr)) return;
    if (direction == Direction.ASC) {
      Arrays.sort(arr, Comparator.comparing(String::length));
    } else {
      Arrays.sort(arr, Comparator.comparing(String::length).reversed());
    }
  }

  public static void sortByLength1(String[] arr, Direction direction) {
    if (!checkInput(arr)) return;
    if (direction == Direction.ASC) {
      Arrays.sort(arr, Comparator.comparingInt(String::length));
    } else {
      Arrays.sort(arr, Comparator.comparingInt(String::length).reversed());
    }
  }

  public static String[] sortByLength2(String[] arr, Direction direction) {
    if (!checkInput(arr)) return new String[0];

    Comparator<String> comparator = Comparator.comparingInt(String::length);
    if (direction == Direction.DESC) comparator = comparator.reversed();

    return Arrays.stream(arr).sorted(comparator).toArray(String[]::new);
  }
}
