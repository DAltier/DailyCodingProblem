/** 
  * Given an array of integers, find the first missing positive integer in linear time and constant space. 
  * In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.
  *
  * For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.
  *
  * You can modify the input array in-place. 
*/

public class Day4 {
  public static int first_missing_positive(int nums[]) {
    int n = nums.length;

    /** If there are no elements in the array, the smallest missing positive number is 1 */
    if (n == 0) {
      return 1;
    }

    /** 
      * Checking only positive numbers between 1 and n-1 
      * Using the indices of the array itself to reorder the elements to where they should be.
      * 1 at index 0, 2 at index 1, etc.
    */
    for (int i = 0; i < n; i++) {
      while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
        int temp = nums[nums[i] - 1];
        nums[nums[i] - 1] = nums[i];
        nums[i] = temp;
      }
    }

    /**
      * Iterating through the array and returning the index of the first number that doesn't match
    */
    for (int i = 0; i < n; i++) {
      if (nums[i] != i + 1) {
        return (i + 1);
      }
    }
    return (n + 1);
  }

  public static void main(String[] args) {
    int arr1[] = {3, 4, -1, 1};
    System.out.println(first_missing_positive(arr1));

    int arr2[] = {1, 2, 0};
    System.out.println(first_missing_positive(arr2));
  }
}