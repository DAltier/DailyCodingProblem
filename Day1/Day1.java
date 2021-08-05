/**Given a list of numbers and a number k, return whether any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.

Bonus: Can you do this in one pass? */

import java.util.*;

public class Day1 {
  public static boolean addUpToK(int[] nums, int k) {

    /** Declare a set that will remmeber the numbers in the array seen up to that point */
    Set<Integer> seen = new HashSet<Integer>();


    for (int i = 0; i < nums.length; i++) {
      /** If the set contains a number equal to (k - current number), return true */
      if (seen.contains(k - nums[i])) {
        return true;
      }
      /** Add current number to the set */
      seen.add(nums[i]);
    }
    return false;
  }
  public static void main(String[] args) {
    int[] array = new int[]{10, 15, 3, 7};
    System.out.println(addUpToK(array, 17));
  }
}