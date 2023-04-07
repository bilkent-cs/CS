package Operations.Unary;

import Operations.Operation;

/**
 * @(#)SquareRoot.java
 * Class that represents SquareRoot {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class SquareRoot extends Operation {

  /**
   * Initializes a {@link SquareRoot} operation object
   */
  public SquareRoot() {
    super(false, "Square Root");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();
    return Math.sqrt(a);
  }
}
