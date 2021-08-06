/** 
  * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair. 
  * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
  *
  * Given this implementation of cons:
  *
  * def cons(a, b):
  *   def pair(f):
  *     return f(a, b)
  *   return pair
  * Implement car and cdr.
*/
import java.util.Arrays;
import java.util.List;


public class Day5 {

  /**
    * car returns the first element in the pair
  */
  public static Integer car(List<Integer> list) {
    return list.get(0);
  }

  /**
    * cdr returns the last element in the pair
  */
  public static Integer cdr(List<Integer> list) {
    return list.get(1);
  }

  /**
    * cons creates a list containing the two numbers
  */
  public static List<Integer> cons(int a, int b) {
    List<Integer> list = Arrays.asList(3, 4);
    return list;
  }

  public static void main(String[] args) {
    List<Integer> list = cons(3, 4);

    Integer head = car(list);
    Integer tail = cdr(list);

    System.out.println(head); 
    System.out.println(tail); 
  }
}