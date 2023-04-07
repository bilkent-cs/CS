import java.util.ArrayList;
import java.util.List;
import shapes.Shape;
import shapes.interfaces.Selectable;

/**
 * @(#)ShapeContainer.java
 * Class that represents a container for shapes
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class ShapeContainer {

  final List<Shape> shapes = new ArrayList<Shape>();

  /**
   * Method for adding a shape to the container
   */
  public void add(Shape s) {
    shapes.add(s);
  }

  /**
   * Method for calculating total area of all the shapes
   *
   * @return {@link Double} total area
   */
  public double getArea() {
    double total = 0;

    for (Shape s : shapes) {
      total += s.getArea();
    }

    return total;
  }

  /**
   * Method to generate a string representation for the {@link ShapeContainer}
   *
   * @return {@link String} string
   */
  @Override
  public String toString() {
    String result = "";

    for (Shape s : shapes) {
      result += s + "\n";
    }

    return result;
  }

  /**
   * Method to find the first shape to contain the given point
   *
   * @param x coordinate of the point
   * @param y coordinate of the point
   * @return {@link Shape} first shape
   */
  public Shape findFirstContains(int x, int y) {
    Shape result = null;

    for (int i = 0; i < shapes.size(); i++) {
      Shape s = shapes.get(i);
      ((Selectable) s).setSelected(false);

      if (s.contains(x, y)) {
        if (result == null) {
          ((Selectable) s).setSelected(true);
          result = s;
        }
      }
    }

    return result;
  }
}
