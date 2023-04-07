package Operations.Unary;

import Operations.Operation;

/**
 * @(#)Factorial.java
 * Class that represents Factorial {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class Factorial extends Operation {

  /**
   * Initializes a {@link Factorial} operation object
   */
  public Factorial() {
    super(false, "Factorial");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();

    int result = 1;
    int limit = (int) a;

    for (int i = 2; i <= limit; i += 1) {
      result *= i;
    }

    return result;
  }
}
