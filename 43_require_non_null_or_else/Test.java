package practice.nonnullElse;
import java.awt.Color;
public class Test {
  public static void main(String[] args) {
    System.out.println(new Car(null, Color.BLACK));
    System.out.println(new Car("Toyota", null));
    System.out.println(new Car(null, null));
  }
}
