package classes;

/**
 * @(#)Term.java
 * Class to represent every single word in a {@link Document}
 *
 * @author Berke Gokmen
 * @date 2021/10/21
 */
public class Term {

  private String word;
  private int count;

  /**
   * Initializes a {@link Term} object
   *
   * @param term String value that represents term
   */
  public Term(String term) {
    this.word = term;
    count = 0;
  }

  /**
   * Method to increment a terms occurrence count
   */
  public void incrementCount() {
    count += 1;
  }

  /**
   * Getter method for word
   * @return {@link String} word
   */
  public String getWord() {
    return word;
  }

  /**
   * Setter method for word
   * @param word String value to set
   */
  public void setWord(String word) {
    this.word = word;
  }

  /**
   * Getter method for word count
   * @return {@link Integer} count
   */
  public int getCount() {
    return count;
  }

  /**
   * Setter method for count
   * @param count integer value to set
   */
  public void setCount(int count) {
    this.count = count;
  }
}
