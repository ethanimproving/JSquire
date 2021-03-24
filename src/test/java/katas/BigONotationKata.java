package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * <table border="1">
 *   <tr><td>Big-O<td>Time Complexity
 *   <tr><td>O(1)<td>Constant
 *   <tr><td>O(logn)<td>Logarithmic
 *   <tr><td>O(n)<td>Linear
 *   <tr><td>O(nlogn)<td>n log-start n
 *   <tr><td>O(n^2)<td>Quadratic
 * </table>
 *
 * @see <a href="https://en.wikipedia.org/wiki/Big_O_notation#/media/File:Comparison_computational_complexity.svg">Graphs of functions commonly used in the analysis of algorithms</a>
 */
class BigONotationKata
{

   /**
    * Find the index of an item in a list based on its value.
    * Worst case scenario is that the desired value is in the last position in the array.
    * Our time complexity is O(n). Anytime we have to loop over an array,
    * we have at least a linear time complexity.
    * <pre>
    * <table border="1">
    *   <tr><td>Operation<td>Time Complexity
    *   <tr><td>Retrieve with index<td>O(1)
    *   <tr><td>Retrieve without index<td>O(n)
    *   <tr><td>Add an element to a full array<td>O(n)
    *   <tr><td>Add an element at the end of an array (has space)<td>O(1)
    *   <tr><td>Insert or update an element at a specific index<td>O(1)
    *   <tr><td>Delete an element by setting it to null<td>O(1)
    *   <tr><td>Delete an element by shifting elements<td>O(n)
    * </table>
    * </pre>
    */
   @Test
   public void linearTimeComplexity()
   {

      int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

      int index = 0;
      for( int i = 0; i < intArray.length; i++ )
      {
         if( intArray[i] == 7 )
         {
            index = i;
            break;
         }
      }

      assertEquals( 3, index );
   }

   /**
    * O(n^2)
    */
   @Test
   public void bubbleSort()
   {

      int[] intArray = { 20, 35, -15, 7, 55, 1, -22 };

      for( int lastUnsortedIndex = intArray.length - 1; lastUnsortedIndex > 0; lastUnsortedIndex-- )
      {
         for( int i = 0; i < lastUnsortedIndex; i++ )
         {
            if( intArray[i] > intArray[i + 1] )
            {
               int temp = intArray[i];
               intArray[i] = intArray[i + 1];
               intArray[i + 1] = temp;
            }
         }
      }

      assertArrayEquals( new int[] { -22, -15, 1, 7, 20, 35, 55 }, intArray );

   }

}