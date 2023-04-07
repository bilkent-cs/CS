package shapes;

import java.awt.Graphics;
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
      "Circle" +
      ("[radius=" + radius) +
      (", selected=" + isSelected) +
      (", hit=" + isHit) +
      "]"
    );
  }

  @Override
  public boolean contains(int x, int y) {
    int centerX = getX() + 2 * getRadius();
    int centerY = getY() + 2 * getRadius();

    double a = Math.abs(x - centerX);
    double b = Math.abs(y - centerY);
    double c = Math.sqrt(a * a + b * b);

    return c <= radius;
  }

  @Override
  public boolean getSelected() {
    return this.isSelected;
  }

  @Override
  public void setSelected(boolean selected) {
    this.isSelected = selected;
  }

  @Override
  public boolean getHit() {
    return this.isHit;
  }

  @Override
  public void setHit(boolean hit) {
    this.isHit = hit;
  }

  @Override
  public void draw(Graphics g) {
    g.drawOval(x + radius, y + radius, 2 * radius, 2 * radius);
  }

  /**
   * Getter method for radius property
   *
   * @return {@link int} radius
   */
  public int getRadius() {
    return radius;
  }

  /**
   * Setter method for radius property
   *
   * @param radius int value to set to
   */
  public void setRadius(int radius) {
    this.radius = radius;
  }
}
