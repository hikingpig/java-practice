package practice.countingUnicode;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class Test {

  // test performance of map
  private static void test1(Path samples) throws IOException {
    Map<String, Long> result = new HashMap<>();
    char[] buff = new char[2048];
    StringBuilder strBuilder = new StringBuilder(2048);
    // measure total time
    long total_start = System.nanoTime();
    try (DirectoryStream<Path> entries = Files.newDirectoryStream(samples, "*")) {
      for (Path p : entries) {
        // measure time for 1 file
        long start = System.nanoTime();
        try (FileInputStream inputStream = new FileInputStream(p.toFile());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            ) {
          while (reader.read(buff) != -1) {
            strBuilder.append(buff);
            Counter.countCharacters(strBuilder, result);
            strBuilder.setLength(0);
          }
          
          // measure time for 1 file
          System.out.format("time needed for %s is %d ms%n", p, (System.nanoTime() - start)/1000000);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    
    // measure total time
    System.out.format("Total time : %d ms%n", (System.nanoTime() - total_start)/1000000);

    System.out.println(result);
  }

  // test performance of array
  private static void test2(Path samples) throws IOException {
    int[] result = new int[Character.MAX_CODE_POINT];
    char[] buff = new char[2048];
    // measure total time
    long total_start = System.nanoTime();
    try (DirectoryStream<Path> entries = Files.newDirectoryStream(samples, "*")) {
      for (Path p : entries) {
        // measure time for 1 file
        long start = System.nanoTime();
        try (FileInputStream inputStream = new FileInputStream(p.toFile());
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
            ) {
          while (reader.read(buff) != -1) {
            Counter.countCharacters3(buff, result);
          }
          
          // measure time for 1 file
          System.out.format("time needed for %s is %d ms%n", p, (System.nanoTime() - start)/1000000);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
      System.exit(1);
    }
    
    // measure total time
    System.out.format("Total time : %d ms%n", (System.nanoTime() - total_start)/1000000);

    for (int i = 0; i < result.length; i++) {
      if (result[i] > 0) {
        System.out.format("%d: %s: %d%n", i, String.valueOf(Character.toChars(i)), result[i]);
      }
    }
  }


  public static void main(String[] args) throws IOException{
    Path samples = Paths.get(args[0]);
    test1(samples);
  }
}
