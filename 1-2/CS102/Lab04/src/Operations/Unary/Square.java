package Operations.Unary;

import Operations.Operation;

/**
 * @(#)Square.java
 * Class that represents Square {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class Square extends Operation {

  /**
   * Initializes a {@link Square} operation object
   */
  public Square() {
    super(false, "Square");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();
    return a * a;
  }
}
