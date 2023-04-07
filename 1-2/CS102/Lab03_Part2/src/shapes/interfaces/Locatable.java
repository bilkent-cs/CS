package shapes.interfaces;

/**
 * @(#)Locatable.java
 * Interface to make objects {@link Locatable}
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public interface Locatable {
  /**
   * Getter method for x property
   *
   * @return {@link Integer} x
   */
  public int getX();

  /**
   * Getter method for y property
   *
   * @return {@link Integer} y
   */
  public int getY();

  /**
   * Setter method for location property
   *
   * @param x int value to set to
   * @param y int value to set to
   */
  public void setLocation(int x, int y);
}
