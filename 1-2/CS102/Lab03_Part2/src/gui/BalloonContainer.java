package gui;

import gui.shapes.Balloon;
import shapes.ShapeContainer;

/**
 * @(#)BalloonContainer.java
 * Class that represents a container for balloons
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class BalloonContainer extends ShapeContainer {

  /**
   * Method to call grow() method for each
   * {@link Balloon} and set their position appropriately
   */
  public void grow() {
    this.getShapes()
      .forEach(s -> {
        ((Balloon) s).grow();

        // To make the balloon grow from the center
        int x = s.getX() - Balloon.GROW_AMOUNT * 2;
        int y = s.getY() - Balloon.GROW_AMOUNT * 2;

        s.setLocation(x, y);
      });
  }
}
