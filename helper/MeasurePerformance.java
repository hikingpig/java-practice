package helper;

import java.util.function.Function;

public class MeasurePerformance {
  public static<T,R> R measurePerformance(Function<T, R> func, T input) {
    long start = System.nanoTime();
    R result = func.apply(input);
    System.out.format("took: %dms%n", (System.nanoTime() - start)/1000000);
    return result;
  }
}
