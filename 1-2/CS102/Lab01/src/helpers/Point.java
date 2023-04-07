package helpers;

/**
 * @(#)Point.java
 * Class that represents a point in a 2D space.
 *
 * @author Berke Gokmen
 * @date 2021/10/08
 */
public class Point {

  // Instance variables
  private double x;
  private double y;

  /**
   * Creates a {@link Point} object.
   * @param x double value for x coordinate
   * @param y double value for y coordinate
   */
  public Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Returns the x value of the point.
   * @return {@link Double} x
   */
  public double getX() {
    return x;
  }

  /**
   * Returns the y value of the point.
   * @return {@link Double} y
   */
  public double getY() {
    return y;
  }

  /**
   * Sets X value.
   * @param newValue new value to assign to X
   */
  public void setX(double newValue) {
    this.x = newValue;
  }

  /**
   * Sets Y value.
   * @param newValue new value to assign to Y
   */
  public void setY(double newValue) {
    this.y = newValue;
  }

  /**
   * Returns the string representation of the point.
   * @return {@link String}
   */
  public String toString() {
    return "X: " + getX() + " Y: " + getY();
  }
}
