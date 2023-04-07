import classes.Document;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @(#)DocumentAnalyzer.java
 * Main class to analyze {@link classes.Document}s
 *
 * @author Berke Gokmen
 * @date 2021/10/21
 */
public class DocumentAnalyzer {

  /**
   * Static method that calculates the Tf-idf
   *
   * @param word word to check for
   * @param document document to search
   * @param documents documents array to compare other documents
   * @return {@link Double} result
   */
  public static double calcTfidf(
    String word,
    Document document,
    Document[] documents
  ) {
    return tf(word, document) * idf(word, documents);
  }

  /**
   * Static helper method that calculates the term frequency
   *
   * @param word word to check for
   * @param document document to search
   * @return {@link Double} result
   */
  public static double tf(String word, Document document) {
    return document.getFrequency(word);
  }

  /**
   * Static method that calculates the idf
   *
   * @param word word to check for
   * @param documents documents array to compare other documents
   * @return {@link Double} result
   */
  public static double idf(String word, Document[] documents) {
    int numOfDocsContainingWord = 0;

    for (Document d : documents) {
      if (d.getCount(word) != 0) {
        numOfDocsContainingWord += 1;
      }
    }

    if (numOfDocsContainingWord == 0) {
      return 0;
    }

    return Math.log(documents.length * 1.0 / numOfDocsContainingWord);
  }

  public static void main(String[] args) throws Exception {
    final Scanner scanner = new Scanner(System.in);
    boolean run = true;

    int numOfDocuments;
    Document[] documents;

    int option;

    System.out.print("Enter the number of documents: ");
    numOfDocuments = scanner.nextInt();
    while (numOfDocuments <= 0) {
      System.out.print("Please enter a value more than or equal to 1: ");
      numOfDocuments = scanner.nextInt();
      System.out.println();
    }

    documents = new Document[numOfDocuments];

    String currentFileName;
    for (int i = 1; i <= numOfDocuments; i++) {
      try {
        System.out.print("Enter the name of the document " + i + ": ");
        currentFileName = scanner.next();
        documents[i - 1] = new Document(currentFileName);
      } catch (FileNotFoundException e) {
        i -= 1;
        System.out.println("File not found, please try a different file name.");
      }
    }

    do {
      System.out.println(
        "\n1- Display the frequency of a word\n" +
        "2- Find the most frequent terms\n" +
        "3- Calculate tf-idf for each document"
      );

      System.out.print("Enter an option (x to quit): ");
      while (run && !scanner.hasNextInt()) {
        String next = scanner.next();

        if (next.charAt(0) == 'x') {
          run = false;
        } else {
          System.out.print("Please enter an integer or 'x' to quit: ");
        }
      }

      if (run) {
        option = scanner.nextInt();
        System.out.println();
      } else {
        option = 0;
      }

      if (option == 1) {
        // Display the frequency of a user entered word
        System.out.print(
          "Enter the word for which you want to find the frequency: "
        );
        String wordToProcess = scanner.next();

        for (int i = 1; i <= documents.length; i++) {
          Document d = documents[i - 1];
          double tf = tf(wordToProcess, d);
          System.out.println(
            (("Document (" + i + ") ") + d.getFileName()) +
            ("\n\tWord: " + wordToProcess) +
            ("\n\tTermFrequency: " + tf)
          );
        }

        System.out.println("");
      } else if (option == 2) {
        // Find the most frequent terms in each document
        for (int i = 1; i <= documents.length; i++) {
          Document d = documents[i - 1];
          String mostFrequentWord = d.getMostFrequentWord();
          System.out.println(
            (("Document (" + i + ") ") + d.getFileName()) +
            ("\n\tWord: " + mostFrequentWord) +
            ("\n\tNumber of appearance: " + d.getCount(mostFrequentWord))
          );
        }

        System.out.println("");
      } else if (option == 3) {
        // Calculate the tf-idf of user entered word
        System.out.print(
          "Enter the word for which you want to calculate tf-idf: "
        );

        String wordToProcess = scanner.next();

        for (int i = 1; i <= documents.length; i++) {
          Document d = documents[i - 1];
          double tfidf = calcTfidf(wordToProcess, d, documents);

          System.out.println(
            (("Document (" + i + ") ") + d.getFileName()) +
            ("\n\tWord: " + wordToProcess) +
            ("\n\tf-idf: " + tfidf)
          );
        }

        System.out.println("");
      } else {
        if (run) {
          System.out.println("Invalid option.");
        }
      }
    } while (run);

    System.out.println("\nBye!");
    scanner.close();
  }
}
