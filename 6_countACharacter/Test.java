package practice.countCharacter;

import practice.helper.GenerateSample;
import static practice.helper.MeasurePerformance.measurePerformance;

public class Test {
  public static void main(String[] args) {
    int CHAR_NUM = 300_000;
    String text = GenerateSample.generateSampleString(CHAR_NUM);
    StringBuilder strangeChars = new StringBuilder();
    String ch = GenerateSample.getRandomChar();
    int result = measurePerformance(CountCharacter::countCharacter, text, ch);
    System.out.format("%s appears %d times in %d characters%n", ch, result, CHAR_NUM);

    int result2 = measurePerformance(CountCharacter::countCharacter2, text, ch);
    System.out.format("%s appears %d times in %d characters%n", ch, result2, CHAR_NUM);

    long result3 = measurePerformance(CountCharacter::countCharacter3, text, ch);
    System.out.format("%s appears %d times in %d characters%n", ch, result3, CHAR_NUM);

  }
}
