package practice.transform;

import java.util.stream.Stream;

public class Test {
  public static void main(String[] args) {
    String result1 = Stream.of("hello").map(s -> s + "world").findFirst().get();
    System.out.println(result1);

    String result2 = Stream.of("gooool! ").map(String::toUpperCase).map(s -> s.repeat(2))
        .map(s -> s.replaceAll("O", "00000")).findFirst().get();
    System.out.println(result2);

  }
}
