package practice.FirstNonRepeatedChar;

import static practice.helper.MeasurePerformance.*;
import practice.helper.GenerateSample;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateSampleString();
    String result = measureFunction(FunctionHome::firstNonRepeatedChar, text);
    result = measureFunction(FunctionHome::firstNonRepeatedChar2, text);
    result = measureFunction(FunctionHome::firstNonRepeatedChar3, text);
    result = measureFunction(FunctionHome::firstNonRepeatedChar4, text);
  }
}
