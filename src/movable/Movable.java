package movable;

public interface Movable {

  void move();

  int getPrice();

  String getName();

  boolean equals(Object o );

  int hashCode();

  default void brake() {
    System.out.println("Braking...");
  }

}
