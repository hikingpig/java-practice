package practice.duplicate;

import practice.helper.GenerateSample;
import static practice.helper.MeasurePerformance.*;

public class Test {
  private static final String TEXT = "!ABCBA;C D E-D🎎  D  DFA;🎎";
  public static void main(String[] args) {
    // check for correctness
    System.out.println(DuplicateRm.rmDuplicate(TEXT));
    System.out.println(DuplicateRm.rmDuplicate1(TEXT));
    System.out.println(DuplicateRm.rmDuplicate2(TEXT));
    System.out.println(DuplicateRm.rmDuplicate3(TEXT));
    // measure performance
    String sample = GenerateSample.generateSampleString();
    measurePerformance(DuplicateRm::rmDuplicate, sample);
    measurePerformance(DuplicateRm::rmDuplicate1, sample);
    measurePerformance(DuplicateRm::rmDuplicate2, sample);
    measurePerformance(DuplicateRm::rmDuplicate3, sample);
  }
}
