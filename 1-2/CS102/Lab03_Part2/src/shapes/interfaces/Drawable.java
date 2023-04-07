package shapes.interfaces;

import java.awt.*;

/**
 * @(#)Drawable.java
 * Interface to make objects {@link Drawable}
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public interface Drawable {
  /**
   * Drawing method
   *
   * @param g Graphics value to draw using
   */
  void draw(Graphics g);
}
