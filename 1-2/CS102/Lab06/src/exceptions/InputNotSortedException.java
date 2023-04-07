package exceptions;

public class InputNotSortedException extends Exception {

  public InputNotSortedException() {
    super("Input array must be sorted");
  }
}
