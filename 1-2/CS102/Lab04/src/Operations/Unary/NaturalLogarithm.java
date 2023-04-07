package Operations.Unary;

import Operations.Operation;

/**
 * @(#)NaturalLogarithm.java
 * Class that represents NaturalLogarithm {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class NaturalLogarithm extends Operation {

  /**
   * Initializes a {@link NaturalLogarithm} operation object
   */
  public NaturalLogarithm() {
    super(false, "Log");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();
    return Math.log(a);
  }
}
