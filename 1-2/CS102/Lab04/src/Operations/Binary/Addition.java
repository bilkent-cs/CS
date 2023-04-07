package Operations.Binary;

import Operations.Operation;

/**
 * @(#)Addition.java
 * Class that represents addition {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public class Addition extends Operation {

  /**
   * Initializes a {@link Addition} operation object
   */
  public Addition() {
    super(true, "Add");
  }

  @Override
  public double calculateResult(double a, double b) {
    this.incrementTimesCalled();
    return a + b;
  }
}
