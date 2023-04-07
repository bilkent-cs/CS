package shapes;

import shapes.interfaces.Locatable;

public abstract class Shape implements Locatable {

  protected int x;
  protected int y;

  protected boolean isSelected;

  /**
   * Super implementation to initialize a {@link Shape}
   *
   * @param x int value for x coordinate
   * @param y int value for y coordinate
   * @param radius int value for radius of the circle
   */
  public Shape(int x, int y) {
    this.x = x;
    this.y = y;
    isSelected = false;
  }

  /**
   * Method to calculate the area of a {@link Shape}
   *
   * @return {@link Double} area
   */
  public abstract double getArea();

  /**
   * Method to check if the given point is inside the circle
   *
   * @param x coordinate of the point
   * @param y coordinate of the point
   * @return {@link Boolean} result
   */
  public abstract boolean contains(int x, int y);

  @Override
  public int getX() {
    return x;
  }

  @Override
  public int getY() {
    return y;
  }

  @Override
  public void setLocation(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
