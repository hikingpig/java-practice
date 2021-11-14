package practice.sort;

import static practice.helper.MeasurePerformance.*;
import java.util.Arrays;

public class Test {
  private static String[] strs = {"one", "two", "three", "four", "five",
  "six", "seven", "eight", "nine", "ten"};
  public static void main(String[] args) {
    String[] arr1 = Arrays.copyOf(strs, strs.length);
    measurePerformance(Sort::sortByLength, arr1, Sort.Direction.ASC);
    System.out.println(Arrays.toString(arr1));

    String[] arr2 = Arrays.copyOf(strs, strs.length);
    measurePerformance(Sort::sortByLength1, arr2, Sort.Direction.ASC);
    System.out.println(Arrays.toString(arr2));

    String[] result = measurePerformance(Sort::sortByLength2, strs, Sort.Direction.ASC);
    System.out.println(Arrays.toString(result));
  }
}
