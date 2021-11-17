package practice.nonnull;

import java.awt.Color;
import java.awt.Point;

public class Test {
  public static void main(String[] args) {
    try {
      Car car = new Car("Mazda", null);
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("-".repeat(30));

    try {
      Car car2 = new Car(null, Color.WHITE);
    } catch (NullPointerException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("-".repeat(30));

    try {
      new Car("Mazda", Color.WHITE).assignDriver(null, new Point(0, 0));
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }

    System.out.println("-".repeat(30));

    try {
      new Car("Mazda", Color.WHITE).assignDriver("123", null);
    } catch (IllegalArgumentException e) {
      System.out.println(e.getMessage());
    }
  }
}
