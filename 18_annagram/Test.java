package practice.anagram;

import practice.helper.GenerateSample;
import static practice.helper.MeasurePerformance.*;

public class Test {
  public static void main(String[] args) {
    int charnum = 100_000;
    // generate sample
    String str1 = GenerateSample.generateAsciiString(charnum);
    String str2 = GenerateSample.scramble(str1 + "      ");

    // measure performance
    System.out.println(measurePerformance(Anagram::isAnagram, str1, str2));
    System.out.println(measurePerformance(Anagram::isAnagram1, str1, str2));
    System.out.println(measurePerformance(Anagram::isAnagram2, str1, str2));
  }
}
