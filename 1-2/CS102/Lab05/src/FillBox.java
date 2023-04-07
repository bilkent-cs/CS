import java.util.Scanner;

public class FillBox {

  static final Scanner INPUT = new Scanner(System.in);
  static int inSize;
  static char inCh;

  public static char[][] createArray(int row, int column) {
    final char[][] arr = new char[row][column];

    for (int i = 0; i < column; i += 1) {
      arr[0][i] = '#';
      arr[row - 1][i] = '#';
    }

    // fill sides
    for (int i = 0; i < row; i += 1) {
      arr[i][0] = '#';
      arr[i][column - 1] = '#';
    }

    fillBox(arr, 1, 1, ' ');

    return arr;
  }

  public static void printArray(char[][] arr) {
    for (int r = 0; r < arr.length; r += 1) {
      for (int c = 0; c < arr[0].length; c += 1) {
        System.out.print(arr[r][c]);
      }
      System.out.println("");
    }
  }

  private static void fillBox(char[][] arr, int row, int column, char ch) {
    if (arr[row][column] != '#') {
      arr[row][column] = ch;
      fillBox(arr, row + 1, column, ch);
      fillBox(arr, row, column + 1, ch);
    }
  }

  public static void drawFigure(char[][] square, int x, int y, int size) {
    int midX = x + size / 2;
    int midY = y + size / 2;

    if (size >= 3) {
      for (int i = 0; i < size; i += 1) {
        square[midY][i + x] = '#';
        square[i + y][midX] = '#';
      }
      drawFigure(square, x, y, size / 2);
      drawFigure(square, x, y + size / 2 + 1, size / 2);
      drawFigure(square, x + size / 2 + 1, y, size / 2);
      drawFigure(square, x + size / 2 + 1, y + size / 2 + 1, size / 2);
    } else {
      fillBox(square, x, y, inCh);
    }
  }

  public static void main(String[] args) throws Exception {
    System.out.print("Enter the size of the square: ");
    inSize = INPUT.nextInt();

    System.out.print("Enter the fill char: ");
    inCh = INPUT.next().charAt(0);

    System.out.println("");

    char[][] square = createArray(inSize, inSize);

    drawFigure(square, 1, 1, inSize - 2);

    printArray(square);
  }
}
