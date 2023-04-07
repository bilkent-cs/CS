package Operations;

/**
 * @(#)Operation.java
 * Abstract Class that represents an {@link Operation}
 *
 * @author Berke Gokmen
 * @date 2021/11/13
 */
public abstract class Operation {

  private int timesCalled;
  private boolean isBinary;
  private String nameOfTheMethod;

  /**
   * Initializes a {@link Operation}
   * @param isBinary {@link Boolean} value that shows whether the operation is binary or unary
   * @param nameOfTheMethod {@link String} value that represents the name of the method
   */
  public Operation(boolean isBinary, String nameOfTheMethod) {
    this.timesCalled = 0;
    this.isBinary = isBinary;
    this.nameOfTheMethod = nameOfTheMethod;
  }

  /**
   * Method to calculate result according to specific operation
   *
   * @param a number 1
   * @param b numebr 2
   * @return {@link Boolean} result
   */
  public abstract double calculateResult(double a, double b);

  protected void incrementTimesCalled() {
    this.timesCalled += 1;
  }

  /**
   * Getter method for times called
   *
   * @return {@link Integer} timesCalled
   */
  public int getTimesCalled() {
    return this.timesCalled;
  }

  /**
   * Getter method for isBinary
   *
   * @return {@link Boolean} isBinary
   */
  public boolean isBinary() {
    return isBinary;
  }

  /**
   * Getter method for the name of the method
   *
   * @return {@link String} nameOfTheMethod
   */
  public String getNameOfTheMethod() {
    return nameOfTheMethod;
  }
}
