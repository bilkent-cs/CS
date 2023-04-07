package shapes;

/**
 * @(#)Square.java
 * Class that represents squares
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class Square extends Rectangle {

  /**
   * Initializes a {@link Square} object
   *
   * @param x int value for x coordinate
   * @param y int value for y coordinate
   * @param length int value for the width and the height of the rectangle
   */
  public Square(int x, int y, int length) {
    super(x, y, length, length);
  }

  /**
   * Method to generate a string representation for the {@link Square}
   *
   * @return {@link String} string
   */
  @Override
  public String toString() {
    return (
      "Square" +
      ("[length=" + this.getWidth()) +
      (", selected=" + isSelected) +
      "]"
    );
  }
}
