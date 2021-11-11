package practice.FirstNonRepeatedChar;

import static helper.MeasurePerformance.measurePerformance;
import practice.helper.GenerateSample;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateSampleString();
    String result = measurePerformance(FunctionHome::firstNonRepeatedChar, text);
    result = measurePerformance(FunctionHome::firstNonRepeatedChar2, text);
    result = measurePerformance(FunctionHome::firstNonRepeatedChar3, text);
    result = measurePerformance(FunctionHome::firstNonRepeatedChar4, text);
  }
}
