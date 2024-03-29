package practice.helper;

import java.io.*;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class GenerateSample {
  private static final Random rnd = ThreadLocalRandom.current();
  // the file size is roughly 1 million characters
  public static final int MAX_CHARS_IN_FILE = 10_000_000;
  public static final int MAX_CHARS_IN_LINE = 36;
  public static final int MAX_CHARS_IN_WORD = 15;
  public static final int MAX_CHARS_IN_STRING = 45_000;
  public static final String WHITESPACE = " ";
  public static final int ASCII_CHAR_NUM = 256;
  // name patterns of unpopular codepoints
  private static String[] getBlackListedNames() {
    return new String[] { "SURROGATE", "PRIVATE", "EXTENSION", "NUSHU", "HIEROGLYPH", "TANGUT", "YI", "OLD HUNGARIAN",
        "CUNEIFORM", "SHARADA", "HENTAIGANA", "BACKSLANTED", "LEPCHA", "EPACT", "AHOM", "MIAO", "NABATAEAN",
        "SIGNWRITING", "MONGOLIAN", "SUNDANESE", "AEGEAN", "WARANG", "MARCHEN", "MEROITIC", "BALINESE", "MENDE",
        "TAI VIET", "PALMYRENE", "LINEAR", "ELBASAN", "CAUCASIAN", "MINY", "REJANG", "SURROGATE", "ZANABAZAR", "SORA",
        "GRANTHA", "SOYOMBO", "PAHAWH", "SIDDHAM", "KHUDAWADI", "BHAIKSUKI", "TIRHUTA", "TAGBANWA", "DUPLOYAN",
        "SAMARITAN", "TAKRI", "TAKRI", "KHOJKI", "MASARAM", "BASSA", "NEW TAI", "PARTHIAN", "JAVANESE", "KAITHI",
        "BATAK", "MEETEI", "HATRAN", "BRAHMI", "KHAROSHTHI", "PAU CIN HAU", "PHAISTOS", "MRO", "PHAGS-PA", "CHAM",
        "PERMIC", "TAI THAM", "PSALTER", "NEWA", "SYLOTI", "LIMBU", "LYDIAN", "MODI ", "RUMI", "MANICHAEAN", "EMOJI",
        "MAHAJANI", "PAHLAVI", "IMPERIAL", "MULTANI", "LYCIAN", "OLD COPTIC", "GREEK ACROPHONIC", "OLD NORTH",
        "GREEK VOCAL", "WIDE-HEADED", "COMBINING LATIN", "GREEK INSTRUMENTAL", "LOOPED" };
  }

  private static final String[] blackListedNames = getBlackListedNames();

  // unpopular codepoints will be filtered out
  public static boolean badName(String name) {
    for (String s : blackListedNames) {
      if (name.contains(s)) {
        return true;
      }
    }
    return false;
  }

  /*
   * write a line with randome length between 0-36 and return the number of
   * characters written characters are generated from random unicode points
   * unoccupied and unpopular codepoints are filtered out
   */
  private static int writeRandomLine(BufferedWriter writer) throws IOException {
    // writing a line with length from 0-36 characters
    int lineLength = rnd.nextInt(MAX_CHARS_IN_LINE);
    for (int i = 0; i < lineLength; i++) {
      // choose a random codepoint
      int cp = rnd.nextInt(Character.MAX_CODE_POINT);
      String name = Character.getName(cp);
      // filter out unoccupied or not popular codepoints
      if (name == null || badName(name)) {
        i--;
        continue;
      }
      // accepted codepoints will be write to file
      char[] chars = Character.toChars(cp);
      writer.write(chars);
    }
    return lineLength;
  }

  public static void generateSampleFile(String filename) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(
        new OutputStreamWriter(new FileOutputStream(filename), StandardCharsets.UTF_8))) {
      for (int i = 0; i < MAX_CHARS_IN_FILE;) {
        int n = writeRandomLine(writer);
        i += n;
        // write a newline at the end of each line
        if (i < MAX_CHARS_IN_FILE) {
          writer.write('\n');
        }
      }
    }
  }

  public static String generateSampleString() {
    return generateSampleString(MAX_CHARS_IN_STRING);
  }

  public static String getRandomChar() {
    while (true) {
      int cp = rnd.nextInt(Character.MAX_CODE_POINT);
      String name = Character.getName(cp);
      // filter out unoccupied or not popular codepoints
      if (name == null || badName(name)) {
        continue;
      }
      return new String(Character.toChars(cp));
    }
  }

  public static String generateSampleString(int charNum) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < charNum; i++) {
      int cp = rnd.nextInt(Character.MAX_CODE_POINT);
      String name = Character.getName(cp);
      // filter out unoccupied or not popular codepoints
      if (name == null || badName(name)) {
        i--;
        continue;
      }
      // accepted codepoints will be write to file
      char[] chars = Character.toChars(cp);
      builder.append(chars);
    }
    return builder.toString();
  }

  public static StringBuilder randomWord(StringBuilder word) {
    Objects.requireNonNull(word);
    word.setLength(0);
    int charNum = rnd.nextInt(MAX_CHARS_IN_WORD);
    for (int i = 0; i < charNum; i++) {
      int cp = rnd.nextInt(Character.MAX_CODE_POINT);
      String name = Character.getName(cp);
      // filter out unoccupied or not popular codepoints
      if (name == null || badName(name)) {
        i--;
        continue;
      }
      // accepted codepoints will be write to file
      char[] chars = Character.toChars(cp);
      word.append(chars);
    }
    return word;
  }
  public static String generateWords(int wordNum) {
    if (wordNum <= 0) {
      throw new IllegalArgumentException("wordNum <= 0");
    }
    StringBuilder builder = new StringBuilder();
    StringBuilder word = new StringBuilder();
    for (int i = 0; i < wordNum; i++) {
      word = randomWord(word);
      builder.append(word).append(WHITESPACE);
    }
    return builder.substring(0, builder.length() - 1);
  }

  public static String generateDigits(int digitNum) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < digitNum; i++) {
      builder.append(rnd.nextInt(10));
    }
    return builder.toString();
  }
  
  public static String generateAsciiString(int charNum) {
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < charNum; i++) {
      char c = (char) (rnd.nextInt(ASCII_CHAR_NUM));
      builder.append(c);
    }
    return builder.toString();
  }

  private static void swap(char[] arr, int pos1, int pos2) {
    char tmp = arr[pos1];
    arr[pos1] = arr[pos2];
    arr[pos2] = tmp;
  }
  // use for ascii string only
  public static String scramble (String str) {
    char[] arr = str.toCharArray();
    for (int i = 0; i < arr.length; i++) {
      int pos1 = rnd.nextInt(arr.length);
      int pos2 = rnd.nextInt(arr.length);
      swap(arr, pos1, pos2);
    }
    return new String(arr);
  }
  public static void main(String[] args) throws IOException {
    // create samples directory if not exists
    String dir_name = "samples";
    File directory = new File(dir_name);
    if (!directory.exists()) {
      directory.mkdirs();
    }

    // measure total time
    long startTimeLoop = System.nanoTime();

    for (int i = 0; i < 10; i++) {
      // measure time of 1 file
      long start = System.nanoTime();

      String filename = String.format("%s/sample_%d.txt", dir_name, i);
      generateSampleFile(filename);

      // measure time of one file
      System.out.format("generate sample %d took %d miliseconds%n", i, (System.nanoTime() - start) / 1000000);
    }

    // measure total time
    System.out.format("generate 10 files took: %d milliseconds%n", (System.nanoTime() - startTimeLoop) / 1000000);
  }
}