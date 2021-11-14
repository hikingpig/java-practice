package practice.remover;

import practice.helper.GenerateSample;
import static practice.helper.MeasurePerformance.*;

public class Test {
  private static final String TEXT = "oobotooorogshŜoootorgo";
  public static void main(String[] args) {
    // check for correctness
    System.out.println(CharRemover.removeChar(TEXT, "o"));
    System.out.println(CharRemover.removeChar1(TEXT, "o"));
    System.out.println(CharRemover.removeChar2(TEXT, "o"));

    // generate sample
    String sample = GenerateSample.generateSampleString();
    String ch = GenerateSample.getRandomChar();
    
    String result = measurePerformance(CharRemover::removeChar, sample, ch);
    System.out.format("remove: %d characters%n", sample.length() - result.length());

    result = measurePerformance(CharRemover::removeChar1, sample, ch);
    System.out.format("remove: %d characters%n", sample.length() - result.length());

    result = measurePerformance(CharRemover::removeChar2, sample, ch);
    System.out.format("remove: %d characters%n", sample.length() - result.length());

  }
}
