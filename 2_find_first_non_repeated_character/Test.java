package practice.FirstNonRepeatedChar;

import practice.helper.GenerateSample;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateSampleString();
    long start = System.nanoTime();
    String result = FunctionHome.findFirstNonRepeatedChar(text);
    System.out.format("Total characters: %d, Total time: %d ms, result: %s%n", GenerateSample.MAX_CHARS_IN_STRING, (System.nanoTime() - start)/1000000, result);
  }
}
