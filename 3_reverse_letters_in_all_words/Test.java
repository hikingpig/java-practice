package practice.reverseLetters;

import static helper.MeasurePerformance.measurePerformance;
import practice.helper.GenerateSample;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateWords(100000);
    // System.out.println(text1);

    String result = measurePerformance(Reverse::reverseWordsV1, text);
    // System.out.println(result);
    result = measurePerformance(Reverse::reverseWordsV2, text);
  }
}
