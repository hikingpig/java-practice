package practice.reverseLetters;

import practice.helper.GenerateSample;

public class Test {
  public static final String text = "The tabloid newspaper actually means to the typical American what the Bible is popularly supposed to have meant to the typical Pilgrim Father: a very present help in time of trouble, plus a means of keeping out of trouble via harmless, since vicarious, indulgence in the pomps and vanities of this wicked world.";

  public static void main(String[] args) {
    String text1 = GenerateSample.generateWords(100000);
    // System.out.println(text1);
    System.out.println("================ ");
    long start = System.nanoTime();
    String result = Reverse.reverseWordsV1(text1);
    // System.out.println(result);
    System.out.format("Total time: %d ms%n", (System.nanoTime() - start)/1000000);
  }
}
