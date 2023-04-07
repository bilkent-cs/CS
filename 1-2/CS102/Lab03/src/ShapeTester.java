import java.util.Scanner;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Shape;

/**
 * @(#)ShapeTester.java
 * Class with main method to test {@link Shape} classes
 *
 * @author Berke Gokmen
 * @date 2021/10/28
 */
public class ShapeTester {

  public static void main(String[] args) {
    final Scanner scanner = new Scanner(System.in);
    final ShapeContainer shapeContainer = new ShapeContainer();

    int choice;

    do {
      System.out.print(
        "\nMENU" +
        "\n1- Add Circle" +
        "\n2- Add Rectangle" +
        "\n3- Display Total Area" +
        "\n4- Display information about each shape" +
        "\n5- Find the first shape that contains x, y" +
        "\n0- Exit" +
        "\nEnter choice: "
      );

      choice = scanner.nextInt();

      if (choice == 1) {
        System.out.print("Enter radius: ");
        int r = scanner.nextInt();

        shapeContainer.add(new Circle(0, 0, r));
      } else if (choice == 2) {
        System.out.print(
          "Enter width and height in the following format" + "\nw h: "
        );
        int w = scanner.nextInt();
        int h = scanner.nextInt();

        shapeContainer.add(new Rectangle(0, 0, w, h));
      } else if (choice == 3) {
        System.out.println("Total area: " + shapeContainer.getArea());
      } else if (choice == 4) {
        System.out.println("\n" + shapeContainer);
      } else if (choice == 5) {
        System.out.print("Enter x and y in the following format" + "\nx y: ");
        int x = scanner.nextInt();
        int y = scanner.nextInt();

        Shape s = shapeContainer.findFirstContains(x, y);
        if (s != null) {
          System.out.println("\nFirst shape to contain " + x + ", " + y + ": ");
          System.out.println(s);
        } else {
          System.out.println("None of the shapes contains " + x + ", " + y);
        }
      } else if (choice != 0) {
        System.out.println("Invalid choice");
      }
    } while (choice != 0);

    scanner.close();
  }
}
