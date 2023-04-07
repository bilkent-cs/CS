package helpers;

/**
 * @(#)Circle.java
 * Class that represents a circle in a 2D space.
 *
 * @author Berke Gokmen
 * @date 2021/10/08
 */
public class Circle {

  private Point center;
  private double radius;

  /**
   * Creates a {@link Circle} object.
   * @param center point for the center of the circle
   * @param radius double value for radius
   */
  public Circle(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  /**
   * Returns the center of the circle.
   * @return {@link Point} center
   */
  public Point getCenter() {
    return center;
  }

  /**
   * Returns the radius of the circle.
   * @return {@link Double} radius
   */
  public double getRadius() {
    return radius;
  }

  /**
   * Sets center.
   * @param p new point to assign to center
   */
  public void setCenter(Point p) {
    this.center = p;
  }

  /**
   * Sets radius.
   * @param newValue new value to assign to radius
   */
  public void setRadius(double newValue) {
    this.radius = newValue;
  }

  /**
   * Returns if the circle contains the specified point.
   * @return {@link Boolean}
   */
  public boolean contains(Point p) {
    // Point x,y
    double px = p.getX();
    double py = p.getY();

    // Center x,y
    double cx = center.getX();
    double cy = center.getY();

    // Let a, b and c be sides of a right triangle where c is the hipotenus.
    // Then a^2 + b^2 = c^2 where a is |px - cx| and b is |py - cy|
    // Thus; if c is greater than or equal to radius, the point is not in the circle
    double a = Math.abs(px - cx);
    double b = Math.abs(py - cy);
    double c = Math.sqrt(a * a + b * b);

    return c < radius;
  }

  /**
   * Returns the string representation of the circle.
   * @return {@link String}
   */
  public String toString() {
    return (
      ("Center: (" + center.getX() + ", " + center.getY() + ")\n") +
      ("Radius: " + radius)
    );
  }
}
