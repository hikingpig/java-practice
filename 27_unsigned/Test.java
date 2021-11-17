package practice.unsigned;

public class Test {
  public static void main(String[] args) {
    String NRI = "255500";
    String NRL = "25550049303";
    System.out.format("Integer.parseUnsignedInteger(%s)=%d%n", NRI, Integer.parseUnsignedInt(NRI));

    // means how 255500 base 36 is represented in decimal
    System.out.format("Integer.parseUnsignedInteger(%s,%d)=%d%n", NRI, Character.MAX_RADIX, Integer.parseUnsignedInt(NRI, Character.MAX_RADIX));

    System.out.format("Integer.parseUnsignedInteger(%s, 1, 4, %d)=%d%n", NRI, Character.MAX_RADIX, Integer.parseUnsignedInt(NRI, 1, 4, Character.MAX_RADIX));

    System.out.format("Long.parseUnsignedLong(%s)=%d%n", NRI, Long.parseUnsignedLong(NRL));

    // means how 25550049303 base 36 is represented in decimal
    System.out.format("Integer.parseUnsignedLong(%s,%d)=%d%n", NRI, Character.MAX_RADIX, Long.parseUnsignedLong(NRI, Character.MAX_RADIX));
    
    System.out.format("Integer.parseUnsignedLong(%s, 1, 4, %d)=%d%n", NRI, Character.MAX_RADIX, Long.parseUnsignedLong(NRI, 1, 4, Character.MAX_RADIX));

  }
}
