package shapes;

import shapes.interfaces.Selectable;

/**
 * @(#)Circle.java
 * Class that represents circles
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class Circle extends Shape implements Selectable {

  private int radius;

  /**
   * Initializes a {@link Circle} object
   *
   * @param x int value for x coordinate
   * @param y int value for y coordinate
   * @param radius int value for radius of the circle
   */
  public Circle(int x, int y, int radius) {
    super(x, y);
    this.radius = radius;
  }

  @Override
  public double getArea() {
    return Math.PI * radius * radius;
  }

  /**
   * Method to generate a string representation for the {@link Circle}
   *
   * @return {@link String} string
   */
  @Override
  public String toString() {
    return (
      "Circle" + ("[radius=" + radius) + (", selected=" + isSelected) + "]"
    );
  }

  @Override
  public boolean contains(int x, int y) {
    double centerX = this.x;
    double centerY = this.y;

    double a = Math.abs(x - centerX);
    double b = Math.abs(y - centerY);
    double c = Math.sqrt(a * a + b * b);

    return c < radius;
  }

  @Override
  public boolean getSelected() {
    return this.isSelected;
  }

  @Override
  public void setSelected(boolean selected) {
    this.isSelected = selected;
  }
}
