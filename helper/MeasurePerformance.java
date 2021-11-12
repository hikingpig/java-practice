package practice.helper;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;

import practice.helper.VargsFunction;

public class MeasurePerformance {
  private static final int NANO_IN_MILI = 1_000_000;
  private static final int NANO_IN_MICRO = 1_000;
  public static<T,R> R measurePerformance(Function<T, R> func, T input) {
    long start = System.nanoTime();
    R result = func.apply(input);
    System.out.format("🦄 took: %dms%n", (System.nanoTime() - start)/NANO_IN_MILI);
    return result;
  }

  public static<T,U,R> R measurePerformance(BiFunction<T,U,R> func, T arg1, U arg2) {
    long start = System.nanoTime();
    R result = func.apply(arg1, arg2);
    System.out.format("🦄 took: %dms%n", (System.nanoTime() - start)/NANO_IN_MILI);
    return result;
  }

  @SafeVarargs
  public static <T, U, V> V measurePerformance(VargsFunction<T, U, V> func, T arg1, U... args) {
    long start = System.nanoTime();
    V result = func.apply(arg1, args);
    System.out.format("🦄 took: %dµs%n", (System.nanoTime() - start)/NANO_IN_MICRO);
    return result;
  }

  public static <T> void measurePerformance(Consumer<T> func, T arg) {
    long start = System.nanoTime();
    func.accept(arg);
    System.out.format("🦄 took: %dms%n", (System.nanoTime() - start)/NANO_IN_MILI);
  }
}
