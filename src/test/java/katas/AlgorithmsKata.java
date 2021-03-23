package katas;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class AlgorithmsKata
{

   /**
    * Given an array of numbers, and a desired number, write a method that determines if a pair of numbers exist in the array that sums to the desired number.
    *
    * <blockquote>For example,
    *
    * <pre>
    * {@code
    * arr = {4,2,1,3}
    * desiredNo = 5
    * result = true (4 + 1 = 5) }
    * </pre>
    *
    * </blockquote>
    *
    * <ul> Solutions:
    *   <li>loop in a loop</li>
    *   <li><a href="https://stackoverflow.com/questions/42177054/every-combination-of-2-strings-in-list-java-8">stream to flatMap of stream</a></li>
    */
   @Test
   public void isPairTest() {

      int[] numbers = new int[]{4,2,1,3};

      assertTrue( Algorithms.isPair(numbers, 5) );
      assertFalse( Algorithms.isPair(numbers, 1) );
   }
  
}