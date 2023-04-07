package Operations.Binary;

import Operations.Operation;

/**
 * @(#)Division.java
 * Class that represents Division {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class Division extends Operation {

  /**
   * Initializes a {@link Division} operation object
   */
  public Division() {
    super(true, "Divide");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();
    return a / b;
  }
}
