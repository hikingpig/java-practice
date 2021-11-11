package practice.onlyDigit;

import java.util.function.Function;

import helper.MeasurePerformance;
import static practice.helper.GenerateSample.*;

public class Test {
  public static void main(String[] args) {
    String digits = generateDigits(100000);
    boolean result = MeasurePerformance.measure(OnlyDigit::onlyDigit, digits);
    System.out.println(result);
    
    String digitAndText = generateDigits(50000) + generateSampleString(10) + generateDigits(50000);
    result = MeasurePerformance.measure(OnlyDigit::onlyDigit, digitAndText);
    System.out.println(result);

    result = MeasurePerformance.measure(OnlyDigit::onlyDigit2, digits);
    System.out.println(result);

    result = MeasurePerformance.measure(OnlyDigit::onlyDigit, digitAndText);
    System.out.println(result);
    
  }
}
