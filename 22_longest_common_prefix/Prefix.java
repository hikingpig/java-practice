package practice.prefix;

public class Prefix {
  // ok, but not optimal
  public static String longestCommonPrefix(String[] args) {
    if (args == null || args.length == 0) {
      // or throw IllegalArgumentException
      return "";
    }

    if (args.length == 1) {
      return args[0];
    }

    String arg0 = args[0];
    StringBuilder buf = new StringBuilder();

    traverseInput: for (int i = 0; i < arg0.length(); i++) {
      for (String argk : args) {
        if (argk.length() - 1 < i || argk.charAt(i) != arg0.charAt(i))
          break traverseInput;
      }
      buf.append(arg0.charAt(i));
    }
    return buf.toString();
  }

  public static String longestCommonPrefix1(String[] args) {
    if (args == null || args.length == 0) {
      // or throw IllegalArgumentException
      return "";
    }

    if (args.length == 1) {
      return args[0];
    }

    String arg0 = args[0];
    for (int i = 0; i < arg0.length(); i++) {
      for (String argk : args) {
        if (argk.length() - 1 < i || argk.charAt(i) != arg0.charAt(i)) return arg0.substring(0, i);
      }
    }
    return arg0;
  }
}
