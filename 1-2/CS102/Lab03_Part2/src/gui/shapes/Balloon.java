package gui.shapes;

import gui.BalloonsGamePanel;
import shapes.Circle;

/**
 * @(#)Balloon.java
 * Class that represents balloons
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class Balloon extends Circle {

  public static final int GROW_AMOUNT = 1;
  private static final int RADIUS = 100;
  private static final int MAX_RADIUS = 200;

  /**
   * Initializes a {@link Balloon} object
   *
   * @param x int value for x coordinate
   * @param y int value for y coordinate
   */
  public Balloon(int x, int y) {
    super(x, y, BalloonsGamePanel.R.nextInt(RADIUS));
  }

  /**
   * Method to increase the {@link Balloon}'s radius
   */
  public void grow() {
    int r = this.getRadius();

    if (r >= MAX_RADIUS) {
      this.setSelected(true);
      this.setRadius(0);
    } else {
      this.setRadius(r + GROW_AMOUNT);
    }
  }
}
