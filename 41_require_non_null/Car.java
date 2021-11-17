package practice.nonnull;

import java.awt.Color;
import java.awt.Point;
import java.util.Objects;
public class Car {
  private final String name;
  private final Color color;
  // Objects.requireNonNull is encouraged in constructor
  public Car(String name, Color color) {
    this.name = Objects.requireNonNull(name, "Name can not be null");

    // use a suplier, the string is not generated unless it is null
    this.color = Objects.requireNonNull(color, () -> "The color is indispensible\n"
                                                + "Can't not be null");
  }

  // Objects.requireNonNull is controversal in method
  // use illegalArgumentException or return a null value instead
  public void assignDriver(String license, Point location) {
    if (license == null) {
      throw new IllegalArgumentException("License can not be null");
    }
    if (location == null) {
      throw new IllegalArgumentException("Location can not be null");
    }
  }
}
