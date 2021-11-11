package practice.onlyDigit;

import java.util.function.Function;

import static helper.MeasurePerformance.measurePerformance;
import static practice.helper.GenerateSample.*;

public class Test {
  public static void main(String[] args) {
    String digits = generateDigits(100000);
    boolean result = measurePerformance(OnlyDigit::onlyDigit, digits);
    System.out.println(result);
    
    String digitAndText = generateDigits(50000) + generateSampleString(10) + generateDigits(50000);
    result = measurePerformance(OnlyDigit::onlyDigit, digitAndText);
    System.out.println(result);

    result = measurePerformance(OnlyDigit::onlyDigit2, digits);
    System.out.println(result);

    result = measurePerformance(OnlyDigit::onlyDigit2, digitAndText);
    System.out.println(result);

    result = measurePerformance(OnlyDigit::onlyDigit3, digits);
    System.out.println(result);

    result = measurePerformance(OnlyDigit::onlyDigit3, digitAndText);
    System.out.println(result);
    
  }
}
