package practice.substring;
import static practice.helper.MeasurePerformance.*;

import java.util.function.Function;
import java.util.regex.Pattern;

public class Test {
  private static final String TEXT = "My high school, the Illinois Mathematics and Science Academy, "
  + "showed me that anything is possible and that you're never too young to think big. "
  + "At 15, I worked as a computer programmer at the Fermi National Accelerator Laboratory, "
  + "or Fermilab. After graduating, I attended Stanford for a degree in economics and "
  + "computer science.";

  private static final String SUBTEXT = "programmer";

  public static void main(String[] args) {
    System.out.println(measureFunction(TEXT::contains, SUBTEXT));

    Function<String, Integer> indexOf = TEXT::indexOf;
    System.out.println(measureFunction(indexOf, SUBTEXT));

    // (?i): insensitive case matching
    //  .*: any character, 0 or more times
    System.out.println(measureFunction(TEXT::matches, "(?i).*" + Pattern.quote(SUBTEXT) + ".*"));

  }
}
