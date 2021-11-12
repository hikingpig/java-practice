package practice.helper;

import java.util.function.BiFunction;
import java.util.function.Function;

import practice.helper.VargsFunction;

public class MeasurePerformance {
  private static final int NANO_IN_MILI = 1_000_000;
  private static final int NANO_IN_MICRO = 1_000;
  public static<T,R> R measurePerformance(Function<T, R> func, T input) {
    long start = System.nanoTime();
    R result = func.apply(input);
    System.out.format("took: %dms%n", (System.nanoTime() - start)/NANO_IN_MILI);
    return result;
  }

  public static<T,U,R> R measurePerformance(BiFunction<T,U,R> func, T arg1, U arg2) {
    long start = System.nanoTime();
    R result = func.apply(arg1, arg2);
    System.out.format("took: %dms%n", (System.nanoTime() - start)/NANO_IN_MILI);
    return result;
  }

  @SafeVarargs
  public static <T,R> R measurePerformance(VargsFunction<T,R> func, T arg1, T... args) {
    long start = System.nanoTime();
    R result = func.apply(arg1, args);
    System.out.format("took: %dµs%n", (System.nanoTime() - start)/NANO_IN_MICRO);
    return result;
  }
}
