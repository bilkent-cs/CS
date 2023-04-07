public class Test {

  public static void main(String[] args) throws Exception {
    int[] arr = {
      2,
      3,
      3,
      4,
      5,
      6,
      77,
      88,
      999,
      1000,
      1100,
      1222,
      1335,
      15555,
      15556,
      15557,
      15558,
      17556,
    };

    for (int i : arr) {
      System.out.println(Part1.genericSearch(arr, i, 0, arr.length - 1, 9));
    }
  }
}
