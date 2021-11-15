package practice.trimstrip;

public class Test {
  private static final char space = '\u2002';
  private static final String TEXT1 = "\n \n\n  hello  \t \n \r";
  private static final String TEXT2 = space + "\n \n\n  hello  \t \n \r" + space;
  public static void main(String[] args) {
    System.out.println("\\u2002 is whitespace? " + Character.isWhitespace(space));

    System.out.println(TEXT1.trim());
    System.out.println(TEXT2.trim());

    System.out.println(TEXT1.strip());
    System.out.println(TEXT2.strip());
  }
  
}
