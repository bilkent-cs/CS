package helpers;

/**
 * @(#)Rectangle.java
 * Class that represents a rectangle in a 2D space.
 *
 * @author Berke Gokmen
 * @date 2021/10/08
 */
public class Rectangle {

  private Point corner; // Bottom left corner
  private double width;
  private double height;

  /**
   * Creates a {@link Rectangle} object.
   * @param corner {@link Point} for bottom left corner
   * @param width double value for width
   * @param height double value for height
   */
  public Rectangle(Point corner, double width, double height) {
    this.corner = corner;
    this.width = width;
    this.height = height;
  }

  /**
   * Returns the corner point of the rectangle.
   * @return {@link Point} the corner
   */
  public Point getBottomLeftCorner() {
    return corner;
  }

  /**
   * Returns the width of the rectangle.
   * @return {@link Double} width
   */
  public double getWidth() {
    return width;
  }

  /**
   * Returns the height of the rectangle.
   * @return {@link Double} height
   */
  public double getHeight() {
    return height;
  }

  /**
   * Sets the corner point.
   * @param p new point to assign to corner
   */
  public void setX(Point p) {
    this.corner = p;
  }

  /**
   * Sets width.
   * @param newValue new value to assign to width
   */
  public void setWidth(double newValue) {
    this.width = newValue;
  }

  /**
   * Sets height.
   * @param newValue new value to assign to height
   */
  public void setHeight(double newValue) {
    this.height = newValue;
  }

  /**
   * Returns if the rectangle contains the specified point.
   * @return {@link Boolean}
   */
  public boolean contains(Point p) {
    // Point x,y
    double px = p.getX();
    double py = p.getY();

    // Corner x,y
    double cx = corner.getX();
    double cy = corner.getY();

    return (px > cx && px < cx + width) && (py > cy && py < cy + height);
  }

  /**
   * - Helper method -
   * Generates a random value between 2 values given
   * @return {@link double} random value
   */
  private double getRandomValueBetween(double min, double max) {
    return Math.random() * (max - min) + min;
  }

  /**
   * Returns a random point inside the rectangle
   * @return {@link Boolean}
   */
  public Point getRandomPoint() {
    double cx = corner.getX();
    double cy = corner.getY();

    double x = getRandomValueBetween(cx, cx + width);
    double y = getRandomValueBetween(cy, cy + height);

    return new Point(x, y);
  }

  /**
   * Returns the string representation of the rectangle.
   * @return {@link String}
   */
  public String toString() {
    return (
      ("Bottom left corner: (" + corner.getX() + ", " + corner.getY() + ")\n") +
      ("Width: " + width) +
      "\n" +
      ("Height: " + height)
    );
  }
}
