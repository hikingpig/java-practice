package practice.conversion;

public class Test {
  public static void main(String[] args) {
    int x = Integer.MIN_VALUE;
    System.out.format("Interger.MIN_VALUE %d; converted: %d%n", x, Integer.toUnsignedLong(x));

    short y = Short.MIN_VALUE;
    System.out.format("Short.MIN_VALUE %d; converted: %d%n", y, Short.toUnsignedInt(y));

    short z = Short.MAX_VALUE;
    System.out.format("Short.MAX_VALUE %d; converted: %d%n", z, Short.toUnsignedInt(z));
  }
  
}
