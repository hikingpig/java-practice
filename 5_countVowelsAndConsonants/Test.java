package practice.VowelConsonant;

import practice.helper.GenerateSample;
import static practice.helper.MeasurePerformance.*;

public class Test {
  public static void main(String[] args) {
    String text = GenerateSample.generateAsciiString(100000);
    int consonants = measureFunction(VowelConsonantCounter::countConsonants, text);
    int vowels = measureFunction(VowelConsonantCounter::countVowels, text);
    System.out.format("Vowels: %d, Consonants: %d%n", consonants, vowels);

    long consonants2 = measureFunction(VowelConsonantCounter::countConsonants2, text);
    long vowels2 = measureFunction(VowelConsonantCounter::countVowels2, text);
    System.out.format("Vowels: %d, Consonants: %d%n", consonants2, vowels2);

  }
}
