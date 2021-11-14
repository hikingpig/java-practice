package practice.helper;

import java.util.Collection;
import java.util.function.*;

import practice.helper.VargsFunction;

public class MeasurePerformance {
  private static final int NANO_IN_MILI = 1_000_000;
  private static final int NANO_IN_MICRO = 1_000;
  private static void printDurationFrom(long start) {
    long duration = System.nanoTime() - start;
    System.out.format("🦄 took: %dms(%dµs)%n", duration/NANO_IN_MILI, duration/NANO_IN_MICRO);
  }
  public static<T,R> R measureFunction(Function<T, R> func, T input) {
    long start = System.nanoTime();
    R result = func.apply(input);
    printDurationFrom(start);
    return result;
  }

  public static<T,U,R> R measureBiFunction(BiFunction<T,U,R> func, T arg1, U arg2) {
    long start = System.nanoTime();
    R result = func.apply(arg1, arg2);
    printDurationFrom(start);
    return result;
  }

  @SafeVarargs
  public static <T, U, V> V measureVarargsFunction(VargsFunction<T, U, V> func, T arg1, U... args) {
    long start = System.nanoTime();
    V result = func.apply(arg1, args);
    printDurationFrom(start);
    return result;
  }

  public static <T> void measureConsumer(Consumer<T> func, T arg) {
    long start = System.nanoTime();
    func.accept(arg);
    printDurationFrom(start);
  }

  public static <T, U> void measureBiConsumer(BiConsumer<T, U> func, T arg1, U arg2) {
    long start = System.nanoTime();
    func.accept(arg1, arg2);
    printDurationFrom(start);
  }
}
