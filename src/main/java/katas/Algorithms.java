package katas;

import java.util.Arrays;

public class Algorithms
{
   public static boolean isPair( int[] numbers, int desiredNumber )
   {
      return Arrays.stream( numbers ).flatMap( no1 -> Arrays.stream( numbers ).
            map( no2 -> no1 + no2 ) ).anyMatch( com -> com == desiredNumber );
   }
}
