package Operations.Binary;

import Operations.Operation;

/**
 * @(#)Subtraction.java
 * Class that represents Subtraction {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class Subtraction extends Operation {

  /**
   * Initializes a {@link Subtraction} operation object
   */
  public Subtraction() {
    super(true, "Subtract");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();
    return a - b;
  }
}
