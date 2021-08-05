/** Given an array of integers, return a new array such that each element at index i of the new array is the product of all the numbers in the original array except the one at i.

For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the expected output would be [2, 3, 6].

Follow-up: what if you can't use division? */

public class Day2 {
  /** Returns the product of all the elements in the array */
  public static int product(int nums[]) {
    int prod = 1;
    for (int i = 0; i < nums.length; i++) {
      prod *= nums[i];
    }
    return prod;
  }

  /** Uses the product function to calculate the value at each index by dividing the total product by the value at that index */
  public static void changeArray(int nums[]) {
    int prod = product(nums);
    for (int i = 0; i < nums.length; i++) {
      nums[i] = prod/nums[i];
      System.out.print(nums[i] + " ");
    }
  }

  /** Prints the new array after replacing the value at each index with the appropriate value */
  public static void withoutDivision(int nums[]) {
    int n = nums.length;

    /** If the length of the array is 1, the product of all other elements in the array is 0 */
    if (n == 1) {
      System.out.println("0");
      return;
    }

    int i, temp = 1;
    /** Allocates memory for the product array */
    int prod[] = new int[n];

    /** Initializes the product array as 1 */
    for (int j = 0; j < n; j++) {
      prod[j] = 1;
    }

    /** The temp variable contains the product of the elements on the left side, excluding nums[i] */
    /** For nums = [1, 2, 3, 4, 5], prod = [1, 1, 2, 6, 24] */
    for (i = 0; i < n; i++) {
      prod[i] = temp;
      temp *= nums[i];
    }
    
    temp = 1;
    /** The temp variable contains the product of the elements on the right side, excluding nums[i] */
    /** For nums = [1, 2, 3, 4, 5], prod = [120, 60, 40, 30, 24] */
    for (i = n - 1; i >= 0; i--) {
      prod[i] *= temp;
      temp *= nums[i];
    }

    for (i = 0; i < n; i++) {
      System.out.print(prod[i] + " ");
    }
  }

  public static void main(String[] args) {

    /** Using division */
    int arr1[] = {1, 2, 3, 4, 5};
    changeArray(arr1);
    System.out.println();
    int arr2[] = {3, 2, 1};
    changeArray(arr2);
    System.out.println();

    /** Without using division */
    int arr3[] = {1, 2, 3, 4, 5};
    withoutDivision(arr3);
  }
}