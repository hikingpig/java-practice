package practice.removeWhiteSpaces;

import practice.helper.GenerateSample;
import practice.helper.MeasurePerformance;

import static practice.helper.MeasurePerformance.measurePerformance;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateSampleString(300_000);
    String result = measurePerformance(RemoveWhiteSpaces::removeWhiteSpaces, text);
    System.out.println("removed: " + (text.length() - result.length()));
  }
}
