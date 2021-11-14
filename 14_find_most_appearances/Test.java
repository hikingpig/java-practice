package practice.appearance;

import static practice.helper.MeasurePerformance.*;
import practice.helper.GenerateSample;

public class Test {
  private static final String TEXT = "ABCDEEEFGH🎎SSSUI🎎PQL🎎A🎎";
  private static final String TEXT1 = "My high school, the Illinois Mathematics and Science Academy, "
  + "showed me that anything is possible and that you're never too young to think big. "
  + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
  + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
  + "computer science.";
  public static void main(String[] args) {
    // check for correctness
    System.out.println(AppearanceCounter.findMostAppearances(TEXT));
    System.out.println(AppearanceCounter.findMostAppearances1(TEXT));
    System.out.println(AppearanceCounter.findMostAppearances2(TEXT));

    System.out.println(AppearanceCounter.findMostAppearances(TEXT1));
    System.out.println(AppearanceCounter.findMostAppearances1(TEXT1));
    System.out.println(AppearanceCounter.findMostAppearances2(TEXT1));

    // generate sample
    String sample = GenerateSample.generateSampleString(200_000);
    // measure performance
    System.out.println(measureFunction(AppearanceCounter::findMostAppearances, sample));
    System.out.println(measureFunction(AppearanceCounter::findMostAppearances1, sample));
    System.out.println(measureFunction(AppearanceCounter::findMostAppearances2, sample));
  }
}
