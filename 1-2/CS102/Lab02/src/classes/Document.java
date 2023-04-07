package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @(#)Document.java
 * Class that represents {@link Document}s
 *
 * @author Berke Gokmen
 * @date 2021/10/21
 */
public class Document {

  private static int MAX_TERMS = 10000;

  private String fileName;
  private Term[] terms;

  private int termIndex;
  private int totalWordCount;

  /**
   * Initializes a {@link Document} object
   *
   * @param fileName String value that represents file name
   */
  public Document(String fileName) throws Exception {
    setFileName(fileName);
    termIndex = 0;
    totalWordCount = 0;
    terms = new Term[MAX_TERMS];

    this.processDocument();
  }

  /**
   * Reads the given file and counts each word
   */
  private void processDocument() throws Exception {
    File file = new File("src/" + fileName);

    if (!file.exists()) {
      throw new FileNotFoundException("File not found");
    }

    Scanner reader = new Scanner(file);

    while (reader.hasNext()) {
      String data = reader.next();

      int controlIndex = findTermIndex(data);

      if (controlIndex != -1) {
        terms[controlIndex].incrementCount();
      } else {
        terms[termIndex] = new Term(data);
        terms[termIndex].incrementCount();
        termIndex += 1;
      }

      totalWordCount += 1;
    }

    reader.close();
  }

  /**
   * -Helper method- Find the index of a given {@link Term} in terms array
   *
   * @param term String value to search for
   * @return {@link Integer} index
   */
  private int findTermIndex(String term) {
    for (int i = 0; i < termIndex; i += 1) {
      String word = terms[i].getWord().replaceAll("[\\p{Punct}&&[^'-]]+", "");
      if (word.equalsIgnoreCase(term)) {
        return i;
      }
    }

    return -1;
  }

  /**
   * Method to find the occurrence count of a word
   *
   * @param word String value to search for
   * @return {@link Integer} count
   */
  public int getCount(String word) {
    int index = findTermIndex(word);
    if (index == -1) return 0;

    return terms[index].getCount();
  }

  /**
   * Method to find the most frequent word
   *
   * @param word String value to search for
   * @return {@link String} word
   */
  public String getMostFrequentWord() {
    double frequency = 0;
    String result = "";

    for (int i = 0; i < termIndex; i++) {
      String word = terms[i].getWord();
      double currentTermF = getFrequency(word);
      if (currentTermF > frequency) {
        frequency = currentTermF;
        result = word;
      }
    }

    return result;
  }

  /**
   * Calculates and returnes the frequency of given word
   *
   * @param word String value to search for
   * @return {@link Double} frequency
   */
  public double getFrequency(String word) {
    int count = getCount(word);

    return count * 1.0 / totalWordCount;
  }

  /**
   * Getter method for file name
   *
   * @return {@link String} fileName
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * Setter method for file name
   *
   * @param fileName String value to set to
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   * Getter method for total word count
   *
   * @return {@link Integer} word count
   */
  public int getTotalWordCount() {
    return totalWordCount;
  }
}
