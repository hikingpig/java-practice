package practice.nonnullElse;
import java.awt.Color;
import java.awt.Point;
import java.util.Objects;
public class Car {
  private final String name;
  private final Color color;

  // requireNonNullElse and requireNonNullElseGet are from JDK 9
  public Car(String name, Color color) {
    this.name = Objects.requireNonNullElse(name, "No name");
    this.color = Objects.requireNonNullElseGet(color, () -> Color.WHITE);
  }
  public String toString() {
    return String.format("Car[name:%s, color:%s]", name, color);
  }
}
