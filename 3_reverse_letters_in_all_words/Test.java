package practice.reverseLetters;

import static practice.helper.MeasurePerformance.*;
import practice.helper.GenerateSample;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateWords(100000);
    // System.out.println(text1);

    String result = measureFunction(Reverse::reverseWordsV1, text);
    // System.out.println(result);
    result = measureFunction(Reverse::reverseWordsV2, text);
  }
}
