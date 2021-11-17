package practice.nullcheck;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// all function is in functional style
public class ListHandler {
  private ListHandler() {
    // non-instantiable
  }

  public static int sumInteger(List<Integer> integers) {
    Objects.requireNonNull(integers);
    return integers.stream()
                  .filter(Objects::nonNull)
                  .mapToInt(Integer::intValue)
                  .sum();
  }

  public static boolean containsNull(List<Integer> integers) {
    Objects.requireNonNull(integers);
    return integers.stream().anyMatch(Objects::isNull);
  }

  public static List<Integer> evenIntegers(List<Integer> integers) {
    Objects.requireNonNull(integers);
    return integers.stream()
                .filter(Objects::nonNull)
                .filter(i -> (i.intValue() %2 == 0))
                .collect(Collectors.toList());
  }
}
