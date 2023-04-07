import exceptions.InputNotSortedException;
import exceptions.KIsLessThan2Exception;
import java.util.Arrays;

public class Part1 {

  public static void main(String args[]) throws Exception {
    int n = 10000;
    int k = 1000;
    // Each element of the array is between 0 and 4n
    int[] arr = generateRandomArray(n);

    // Sorting is pre-condition of the search algorithms in this lab
    Arrays.sort(arr);

    // Insert appropriate code segments to calculate execution time

    // Checking if the method can correctly find already existing elements
    long start = System.currentTimeMillis();
    for (int elem : arr) {
      int res = genericSearch(arr, elem, 0, arr.length - 1, k);

      // call the search function and assign it to ``res``
      // Generalize the code so that you can experiment with different k values in a single execution
      if (elem != arr[res]) {
        throw new RuntimeException(
          "Method works incorrectly (cannot properly locate elements)"
        );
      }
    }
    long end = System.currentTimeMillis();
    // Checking if the method can correctly report absence of elements
    int[] nonExistingElements = { -90, -54, 5 * n + 5, 6 * n };
    for (int elem : nonExistingElements) {
      int res = genericSearch(arr, elem, 0, arr.length - 1, k);
      // call the search function and assign it to ``res``
      // Generalize the code so that you can experiment with different k values in a single execution
      if (res != -1) {
        throw new RuntimeException(
          "Method works incorrectly (cannot report absence of elements)"
        );
      }
    }
    System.out.println("Total time: " + (long) (end - start));
  }

  public static int binarySearch(int[] arr, int target, int low, int high)
    throws Exception {
    if (!checkSorted(arr)) throw new InputNotSortedException();
    if (low > high) return -1;
    int mid = low + (high - low) / 2;

    if (arr[mid] == target) return mid;
    if (target < arr[mid]) return binarySearch(arr, target, low, mid - 1);

    return binarySearch(arr, target, mid + 1, high);
  }

  public static int ternarySearch(int[] arr, int target, int low, int high)
    throws Exception {
    if (!checkSorted(arr)) throw new InputNotSortedException();
    if (low > high) return -1;

    int mid1 = low + (high - low) / 3;
    if (arr[mid1] == target) return mid1;
    if (target < arr[mid1]) return ternarySearch(arr, target, low, mid1 - 1);

    int mid2 = low + 2 * (high - low) / 3;
    if (arr[mid2] == target) return mid2;
    if (target < arr[mid2]) return ternarySearch(
      arr,
      target,
      mid1 + 1,
      mid2 - 1
    );

    return ternarySearch(arr, target, mid2 + 1, high);
  }

  public static int genericSearch(
    int[] arr,
    int target,
    int low,
    int high,
    int k
  ) throws Exception {
    if (!checkSorted(arr)) throw new InputNotSortedException();
    if (k < 2) throw new KIsLessThan2Exception();
    if (k == 2) return binarySearch(arr, target, low, high);

    if (low > high) return -1;

    for (int i = 1; i < k; i += 1) {
      int mid = low + i * (high - low) / k;
      if (arr[mid] == target) return mid;

      int preMid = low + (i - 1) * (high - low) / k;

      if (i == 1) preMid = low - 1;

      if (target < arr[mid]) {
        return genericSearch(arr, target, preMid + 1, mid - 1, k);
      }
    }

    return genericSearch(
      arr,
      target,
      (low + (k - 1) * (high - low) / k) + 1,
      high,
      k
    );
    // int[] middles = new int[k - 1];

    // for (int i = 1; i < k; i += 1) {
    //   middles[i - 1] = low + i * (high - low) / k;
    // }

    // // Check middles
    // if (arr[low] == target) return low;

    // if (arr[high] == target) return high;

    // for (int mid : middles) {
    //   if (arr[mid] == target) return mid;
    // }

    // if (target < middles[0]) return genericSearch(
    //   arr,
    //   target,
    //   low,
    //   middles[0] - 1,
    //   k
    // );

    // if (target > middles[middles.length - 1]) return genericSearch(
    //   arr,
    //   target,
    //   middles[middles.length - 1] + 1,
    //   high,
    //   k
    // );

    // int smallerMid = middles[0];
    // int largerMid = middles[middles.length - 1];

    // for (int i = 0; i < middles.length; i++) {
    //   // if (target < arr[middles[0]]) {
    //   //   smallerMid = low;
    //   //   largerMid = middles[0];
    //   // } else if (target < arr[middles[i]]) {
    //   //   smallerMid = middles[i - 1];
    //   //   largerMid = middles[i];
    //   // }

    //   if (arr[middles[i]] > target) {
    //     smallerMid = middles[i];
    //     largerMid = middles[i + 1];
    //     break;
    //   }
    // }

    // return genericSearch(arr, target, smallerMid, largerMid, k);
  }

  /**
   * YOU SHOULD NOT TOUCH BELOW THIS POINT
   * YOU SHOULD NOT TOUCH BELOW THIS POINT
   * YOU SHOULD NOT TOUCH BELOW THIS POINT
   */

  public static int[] generateRandomArray(int length) {
    int[] array = new int[length];

    for (int i = 0; i < length; ++i) {
      array[i] = (int) (Math.random() * length * 4);
    }

    return array;
  }

  public static boolean checkSorted(int[] arr) {
    for (int i = 0; i < arr.length - 2; i += 1) {
      if (arr[i] > arr[i + 1]) return false;
    }

    return true;
  }
}
