package practice.multiline;

public class Multiline {
  private static final String LS = System.lineSeparator();

  public static void main(String[] args) {
    String text1 = new StringBuilder()
                        .append("When").append(LS)
                        .append("I").append(LS)
                        .append("was").append(LS)
                        .append("young").append(LS)
                        .append("I listen to the radio.")
                        .toString();
    System.out.println(text1);

    String text2 = String.join(LS,
    "When",
    "I",
    "was",
    "young.",
    "I listen to the radio");
    System.out.println(text2);

    String text3 = "When" + LS
                  + "I" + LS
                  + "was" + LS
                  + "young" + LS
                  + "I listen to the radio";
    System.out.println(text3);

    String text4 = String.format("%s" + LS + "%s" + LS + "%s" + LS + "%s" + LS + "%s",
                                  "When",
                                  "I",
                                  "was",
                                  "young",
                                  "I listen to the radio");
    System.out.println(text4);
  }
}