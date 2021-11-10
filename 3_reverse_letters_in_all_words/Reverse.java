package practice.reverseLetters;

public class Reverse {

    public static final String WHITESPACE = " ";

    public static String reverseWordsV1(String str) {

        if (str == null || str.isBlank()) {
            // or throw IllegalArgumentException
            return "";
        }

        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();
        StringBuilder reversedWord = new StringBuilder();

        for (String word : words) {
            for (int i = word.length() - 1; i >= 0; i--) {
                if (Character.isLowSurrogate(word.charAt(i))) {
                    continue;
                }
                int cp = word.codePointAt(i);
                reversedWord.append(Character.toChars(cp));
            }
            reversedString.append(reversedWord).append(WHITESPACE);
            reversedWord.setLength(0);
        }

        return reversedString.toString();
    }
}
