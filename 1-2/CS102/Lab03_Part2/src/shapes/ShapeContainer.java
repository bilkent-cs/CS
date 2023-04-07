package shapes;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import shapes.interfaces.Drawable;
import shapes.interfaces.Selectable;

/**
 * @(#)ShapeContainer.java
 * Class that represents a container for shapes
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class ShapeContainer implements Drawable {

  final List<Shape> shapes = new ArrayList<Shape>();

  /**
   * Getter method for shapes array
   *
   * @return {@link List} shapes list
   */
  protected List<Shape> getShapes() {
    return shapes;
  }

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
    removeSelected();

    Shape result = null;
    boolean found = false;

    for (int i = 0; i < shapes.size() && !found; i++) {
      Shape s = shapes.get(i);

      if (s.contains(x, y)) {
        result = s;
        found = true;
      }
    }

    return result;
  }

  /**
   * Getter method for size property
   *
   * @return {@link Integer} size of the shapes array
   */
  public int size() {
    return shapes.size();
  }

  /**
   * Method to remove all the shapes which has the given point inside
   *
   * @param x coordinate of the point
   * @param y coordinate of the point
   * @return {@link Integer} number of shapes that are hitted (not selected)
   */
  public int removeSelected() {
    int removedCount = 0;

    for (int i = 0; i < shapes.size(); i++) {
      Shape s = shapes.get(i);
      boolean checkSelected = ((Selectable) s).getSelected();

      if (checkSelected) {
        shapes.remove(s);
        boolean checkHit = ((Selectable) s).getHit();
        if (checkHit) {
          removedCount += 1;
        }
      }
    }

    return removedCount;
  }

  /**
   * Method to select all shapes which has the given point inside
   *
   * @param x coordinate of the point
   * @param y coordinate of the point
   * @return {@link Integer} number of shapes that contain the given point
   */
  public int selectAllAt(int x, int y) {
    int res = 0;
    for (int i = 0; i < shapes.size(); i++) {
      Selectable s = (Selectable) shapes.get(i);
      if (s.contains(x, y)) {
        s.setSelected(true);
        s.setHit(true);

        res += 1;
      }
    }

    return res;
  }

  @Override
  public void draw(Graphics g) {
    for (int i = 0; i < shapes.size(); i++) {
      ((Circle) shapes.get(i)).draw(g);
    }
  }
}
