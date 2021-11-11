package practice.VowelConsonant;

import practice.helper.GenerateSample;
import static helper.MeasurePerformance.measurePerformance;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateAsciiString(100000);
    int consonants = measurePerformance(VowelConsonantCounter::countConsonants, text);
    int vowels = measurePerformance(VowelConsonantCounter::countVowels, text);
    System.out.format("Vowels: %d, Consonants: %d%n", consonants, vowels);

    long consonants2 = measurePerformance(VowelConsonantCounter::countConsonants2, text);
    long vowels2 = measurePerformance(VowelConsonantCounter::countVowels2, text);
    System.out.format("Vowels: %d, Consonants: %d%n", consonants2, vowels2);

  }
}
