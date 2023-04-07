import helpers.*;
import java.util.Scanner;

public class PiCalculator {

  public static void main(String[] args) throws Exception {
    final Scanner sc = new Scanner(System.in);

    final Rectangle rectangle = new Rectangle(new Point(0, 0), 10, 10);
    final Circle circle = new Circle(new Point(5, 5), 5);

    Point p;
    int numOfTrials;
    int tries = 0;
    int hits = 0;

    System.out.print("Number of trials: ");
    numOfTrials = sc.nextInt();

    while (tries < numOfTrials) {
      p = rectangle.getRandomPoint();

      if (circle.contains(p)) {
        hits += 1;
      }

      tries += 1;
    }

    if (numOfTrials <= 0) {
      System.out.println("NumOfTrials cannot be less than or equal to 0");
    } else {
      final double piEstimation = 4.0 * hits / tries;

      System.out.println("Estimated value for π: " + piEstimation);
    }

    sc.close();
  }
}
