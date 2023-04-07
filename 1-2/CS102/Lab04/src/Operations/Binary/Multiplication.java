package Operations.Binary;

import Operations.Operation;

/**
 * @(#)Multiplication.java
 * Class that represents Multiplication {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class Multiplication extends Operation {

  /**
   * Initializes a {@link Multiplication} operation object
   */
  public Multiplication() {
    super(true, "Multiply");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();
    return a * b;
  }
}
