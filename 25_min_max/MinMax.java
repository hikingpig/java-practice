package practice.minmax;

import java.util.function.BinaryOperator;

public class MinMax {
  public static void main(String[] args) {
    System.out.format("min integer: %d, max integer: %d%n", Math.min(-45, -15), Math.max(-45, -15));

    double d1 = 0.023844D;
    double d2 = 0.35468856D;
    System.out.format("min double: %f, max double: %f%n", Double.min(d1, d2), Double.max(d1, d2));

    float f1 = 33.34F;
    final float f2 = 33.213F;

    System.out.format("min float: %f, max float: %f%n",
      BinaryOperator.minBy(Float::compare).apply(f1, f2),
      BinaryOperator.maxBy(Float::compare).apply(f1, f2)
    );
  }
}
