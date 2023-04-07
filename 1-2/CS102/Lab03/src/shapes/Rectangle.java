package shapes;

import shapes.interfaces.Selectable;

public class Rectangle extends Shape implements Selectable {

  private int width;
  private int height;

  /**
   * Initializes a {@link Rectangle} object
   *
   * @param x int value for x coordinate
   * @param y int value for y coordinate
   * @param width int value for width of the rectangle
   * @param height int value for height of the rectangle
   */
  public Rectangle(int x, int y, int width, int height) {
    super(x, y);
    this.width = width;
    this.height = height;
  }

  /**
   * Method to calculate the area of a {@link Rectangle}
   *
   * @return {@link Double} area
   */
  public double getArea() {
    return width * height;
  }

  /**
   * Method to generate a string representation for the {@link Rectangle}
   *
   * @return {@link String} string
   */
  @Override
  public String toString() {
    return (
      "Rectangle" +
      ("[height=" + height) +
      (", width=" + width) +
      (", selected=" + isSelected) +
      "]"
    );
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
  public boolean contains(int x, int y) {
    double cornerX = this.x;
    double cornerY = this.y;

    return (
      (x > cornerX && x < cornerX + width) &&
      (y > cornerY && y < cornerY + height)
    );
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }
}
