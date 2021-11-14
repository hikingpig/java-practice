package practice.permutation;

import static practice.helper.MeasurePerformance.*;

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
    measureConsumer(Permutation::permuteAndPrint, TEXT);

    System.out.println("\nPermute and Print with char[]");

    measureConsumer(Permutation::permuteAndPrint1, TEXT);

    System.out.println("\nPermute and Store with Set and char[]");
    
    // must explicitly assign return type to Function
    Set<String> set = measureFunction(Permutation::permuteAndStore, TEXT);
    System.out.println(set);

    System.out.println("\nPermute and Print with Stream and char[]");

    measureConsumer(Permutation::permuteAndPrintStream, TEXT);

    System.out.println("\nPermute and Return with Stream and String concatenation");

    measureConsumer(Test::printStreamResult, TEXT);

    System.out.println("\nPermute and Return with Stream and char[]");

    measureConsumer(Test::printStreamResult1, TEXT);

  }

}
