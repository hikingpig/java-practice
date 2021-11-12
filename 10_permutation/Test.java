package practice.permutation;

import static practice.helper.MeasurePerformance.measurePerformance;

import java.util.Set;
import java.util.StringJoiner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

public class Test {
  private static final String TEXT = "ABCD";
  private static void printStreamResult(String s) {
    Stream<String> stream = Permutation.permuteAndReturnStream(TEXT);
    StringJoiner joiner = new StringJoiner(" ");
    stream.forEach(joiner::add);
    System.out.println(joiner.toString());
  }

  private static void printStreamResult1(String s) {
    Stream<String> stream = Permutation.permuteAndReturnStream1(TEXT);
    StringJoiner joiner = new StringJoiner(" ");
    stream.forEach(joiner::add);
    System.out.println(joiner.toString());
  }
  public static void main(String[] args) {
    System.out.println("Permute and Print with string concatenation:");
    measurePerformance(Permutation::permuteAndPrint, TEXT);

    System.out.println("\nPermute and Print with char[]");

    measurePerformance(Permutation::permuteAndPrint1, TEXT);

    System.out.println("\nPermute and Store with Set and char[]");
    
    // must explicitly assign return type to Function
    Function<String, Set<String>> func = Permutation::permuteAndStore;
    Set<String> set = measurePerformance(func, TEXT);
    System.out.println(set);

    System.out.println("\nPermute and Print with Stream and char[]");

    measurePerformance(Permutation::permuteAndPrintStream, TEXT);

    System.out.println("\nPermute and Return with Stream and String concatenation");

    measurePerformance(Test::printStreamResult, TEXT);

    System.out.println("\nPermute and Return with Stream and char[]");

    measurePerformance(Test::printStreamResult1, TEXT);

  }

}
