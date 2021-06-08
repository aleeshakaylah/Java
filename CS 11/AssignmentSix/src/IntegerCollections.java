import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class IntegerCollections {

  /**
   * Returns {@code true} if the two specified collections have no element in common.
   * 
   * <p><b>Implementation note: For full credit, consider how to avoid very slow performance.</b></p>
   * 
   * @param coll1 a collection of Integers
   * @param coll2 a collection of Integers
   * @return {@code true} if {@code coll1} and {@code coll2} have no element in common
   * 
   * HashSet, Treeset
   */
  public static boolean disjoint(Collection<Integer> coll1, Collection<Integer> coll2) {
    // TODO
    HashSet<Integer> uniqueVals=new HashSet<Integer>();
    
    //iterate through coll1, load elements into HashSet
    for(Integer i : coll1){
        uniqueVals.add(i);
    }
    //iterate through coll2,
    for(Integer j: coll2){
        //returns false if for any element e: e.equals(j)==true
        if (uniqueVals.contains(j))
            return false;
    }
    
    return true;
        //return false if any elements are already in the HashSet
        //otherwise, return True
  }

  /**
   * Replaces all of the elements in the specified list with the specified value.
   * 
   * <p>
   * <b>Implementation note: For full credit, use an iterator to accomplish this, since some Lists
   * (e.g. LinkedList) are slow at accessing values by index. List classes have method
   * {@link List#listIterator()}, which may be useful in implementing this method</b>
   * </p>
   *
   * @param list the list to be filled with the specified value
   * @param fillValue the value with which to fill the specified list
   * 
   * doesn't matter
   */
  public static void fill(List<Integer> list, int fillValue) {
    // TODO
    //foreach Integer i in list,
        //i=fillvalue
  }

  /**
   * Returns the number of elements in the specified collection equal to the specified value.
   *
   * @param values the collection in which to determine the frequency of {@code target}
   * @param target the value whose frequency is to be determined
   * @return the number of elements in {@code values} equal to {@code target}
   * 
   * Lists (any kind)
   */
  public static int frequency(Collection<Integer> values, int target) {
    // TODO
    //iterate through values, add 1 to return val every time target is encountered,
    //return val
  }

  /**
   * Returns {@code true} if the specified list is sorted in ascending order.
   * 
   * <p><b>Implementation note: For full credit, use an iterator/enhanced-for to accomplish this, since
   * some Lists (e.g. LinkedList) are slow at accessing values by index.</b></p>
   * 
   * @param list the list to be assessed for order
   * @return {@code true} if {@code list} is sorted in ascending order
   *
   * Sets, as long as no duplicates are needed
   */
  public static boolean isSorted(List<Integer> list) {
    // TODO
    //iterate through
        //return false if next element < this element
        
    //return true
  }

  /**
   * Returns the largest element in the specified collection.
   * 
   * @param values the collection to search
   * @return the largest element in {@code values}
   */
  public static Integer max(Collection<Integer> values) {
    // TODO
    //set max to first element
    //foreach Integer i in values
        //set max to current element iff current element>max
        
    //return max
  }

  /**
   * Returns the median value of the specified collection.
   * 
   * <p><b>Implementation note: You will probably want to create a temporary List containing the
   * collection's elements, sort it using {@link List#sort(java.util.Comparator)}, and use the
   * sorted list to find the median. For full credit, choose an appropriate kind of list for this
   * process.</b></p>
   * 
   * @param values the collection to search
   * @return the median value in {@code values} (this will be the average of the two middle
   *         elements, if the size of the collection is even)
   */
  public static double median(Collection<Integer> values) {
    // TODO
    //new ArrayList<Integer>(values.toArray);
    //valArray.sort();
    //calculate median
    //return valArray[median];
  }

  /**
   * Returns the smallest element in the specified collection.
   * 
   * @param values the collection to search
   * @return the smallest element in @{values}
   */
  public static Integer min(Collection<Integer> values) {
    // TODO
    //!!!! be sure to change ordering
    //set max to first element
    //foreach Integer i in values
        //set max to current element iff current element<min
        
    //return max
  }

  /**
   * Returns the most frequent element in the specified collection.
   * 
   * <p><b>Implementation note: You will probably want to create a temporary List containing the
   * collection's elements, sort it using {@link List#sort(java.util.Comparator)}, and use the
   * sorted list to find the mode.</b></p>
   * 
   * @param values the collection to search
   * @return the most frequent element in {@code values}. In the case of a tie, returns the
   *         lowest-valued tied element.
   */
  public static Integer mode(Collection<Integer> values) {
    // TODO
    //get sortedValArray() (see median())
    //count each sequence of consecutive same elements
    //return max of consecutive counts
  }

  /**
   * Rotates the elements in the specified list by the specified distance. After calling this
   * method, the element at index {@code i} will be the element previously at index
   * {@code (i - distance) % list.size()}, for all values of {@code i} between {@code 0} and
   * {@code list.size() - 1}, inclusive. (This method has no effect on the size of the list.)
   *
   * For example, suppose {@code list} comprises{@code  ['t', 'a', 'n', 'k', 's']}.
   * After invoking {@code IntegerCollections.rotate(list, 1)} (or
   * {@code IntegerCollections.rotate(list, -4)}), {@code list} will comprise
   * {@code ['s', 't', 'a', 'n', 'k']}.
   * 
   * To move more than one element forward, increase the absolute value of the rotation distance. To
   * move elements backward, use a positive shift distance.
   *
   * @param list the list to be rotated
   * @param distance the distance to rotate the list. There are no constraints on this value; it may
   *          be zero, negative, or greater than {@code list.size()}.
   */
  public static void rotate(List<Integer> list, int distance) {
    // TODO
    //if RIGHT (positive):
        //copy elements 0-list.length-distance to temporary array, starting at temp[distance]
        //copy remaining elements of list to temp, starting at temp[0];
    
    //if LEFT (negative):
        //copy list[|r|->end] to temp[0->len+r]
        //copy list[0->|r|] to temp[len+r->end]
        
    //iterate through temp, set list[i] to temp[i]
  }

  /**
   * Returns the sum of the values in the specified collection.
   * 
   * @param values the collection to investigate
   * @return the sum of the values in the specified collection
   */
  public static long sum(Collection<Integer> values) {
    // TODO
    //iterate through values and collect sum
  }

  /**
   * Returns a {@code Set} of the unique values in the specified collection.
   * 
   * @param values the collection to investigate
   * @return a {@code Set} of the unique values in the specified collection
   */
  public static Set<Integer> uniqueValues(Collection<Integer> values) {
    // TODO
    //iterate through values, add each element to HashSet<Integer> retSet
    
    //return retSet
  }

}