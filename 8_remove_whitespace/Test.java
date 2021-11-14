package practice.removeWhiteSpaces;

import practice.helper.GenerateSample;

import static practice.helper.MeasurePerformance.*;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateSampleString(300_000);
    String result = measureFunction(RemoveWhiteSpaces::removeWhiteSpaces, text);
    System.out.println("removed: " + (text.length() - result.length()));
  }
}
