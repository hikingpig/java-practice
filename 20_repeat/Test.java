package practice.repeat;
import static practice.helper.MeasurePerformance.*;

public class Test {
  private static final String TEXT = "hello ";
  private static final int NUM = 20_000;
  public static void main(String[] args) {
    System.out.println(Repeat.concatRepeatStream(TEXT, 5));
    System.out.println(Repeat.concatRepeatBuilder(TEXT, 5));
    System.out.println(Repeat.concatRepeatNcopies(TEXT, 5));
    System.out.println(Repeat.concatRepeatCharArr(TEXT, 5));
    System.out.println(Repeat.concatRepeatFormat(TEXT, 5));

    System.out.println(TEXT.repeat(5));

    measureBiFunction(Repeat::concatRepeatStream, TEXT, NUM);
    measureBiFunction(Repeat::concatRepeatBuilder, TEXT, NUM);
    measureBiFunction(Repeat::concatRepeatNcopies, TEXT, NUM);
    measureBiFunction(Repeat::concatRepeatCharArr, TEXT, NUM);
    measureBiFunction(Repeat::concatRepeatFormat, TEXT, NUM);
    String result = measureFunction(TEXT::repeat, NUM);
    System.out.println(Repeat.hasOnlySubstring(result));
  }
}
