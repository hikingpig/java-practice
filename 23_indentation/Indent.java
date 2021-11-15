package practice.indent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Indent {
  public static void main(String[] args) {
    List<String> abc = Arrays.asList("AB", "BCD", "C", "DESW", "EWEGGH");
    String tab = "  ";
    // cascade indentation
    for (int i = 0; i < abc.size(); i++) {
      System.out.println(tab.repeat(i) + abc.get(i));
    }

    System.out.println("\n--------------------------------------------\n");

    abc.stream().forEachOrdered(s -> System.out.println(tab.repeat(s.length()) + s));

    System.out.println("\n--------------------------------------------\n");

    String html = "<html>";
    String body = "<body>";
    String h2 = "<h2>";
    String text = "Hello world!";
    String closeH2 = "</h2>";
    String closeBody = "</body>";
    String closeHtml = "</html>";

    System.out.println(
        tab.repeat(0) + html + "\n" + tab.repeat(4) + body + "\n" + tab.repeat(8) + h2 + "\n" + tab.repeat(12) + text
            + "\n" + tab.repeat(8) + closeH2 + "\n" + tab.repeat(4) + closeBody + "\n" + tab.repeat(0) + closeHtml);
  }
}
