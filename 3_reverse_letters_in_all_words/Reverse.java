package practice.reverseLetters;

import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Reverse {
    public static final String WHITESPACE = " ";
    private static final Pattern PATTERN = Pattern.compile("\\s+");

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

    public static String reverseWordsV2(String str) {

        // or throw IllegalArgumentException
        if (str == null || str.isBlank()) {
            return "";
        }

        return PATTERN.splitAsStream(str).map(w -> new StringBuilder(w).reverse())
                .collect(Collectors.joining(WHITESPACE));
    }
}
