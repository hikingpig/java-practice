package practice.overflow;

import java.util.function.BinaryOperator;

public class Test {
  public static void main(String[] args) {
    int x = Integer.MAX_VALUE;
    int y = Integer.MAX_VALUE;

    System.out.format("%d + %d = %d%n", x, y, x + y);
    System.out.format("Integer.sum(%d,%d) = %d%n", x, y, Integer.sum(x, y));
    try {
      System.out.format("Math.addExact(%d,%d) = %d%n", x, y, Math.addExact(x, y));
    } catch(ArithmeticException e) {
      System.out.format("Math.addExact(%d,%d) throw ArithmeticException: %s%n", x, y, e);
    }

    BinaryOperator<Integer> binOp = Math::addExact;
    try {
      System.out.format("binOp.apply(%d,%d) = %d%n", x, y, binOp.apply(x, y));
    } catch(ArithmeticException e) {
      System.out.format("binOp.apply(%d,%d) throw ArithmeticException: %s%n", x, y, e);
    }
  }
}
