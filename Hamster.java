/* You are given a 0-indexed string hamsters where hamsters[i] is either:
1)- 'H' indicating that there is a hamster at index i, or
2)- '.' indicating that index i is empty.
You will add some number of food buckets at the empty indices in order to feed the hamsters. A hamster can be fed if 
there is at least one food bucket to its left or to its right. More formally, a hamster at index i can be fed if you 
place a food bucket at index i - 1 and/or at index i + 1. Return the minimum number of food buckets you should place 
at empty indices to feed all the hamsters or -1 if it is impossible to feed all of them.
* Eg 1 :  hamster = "H..H"       Buckets = 2 
* Eg 2 :  hamster = ".H.H."      Buckets = 1 
* Eg 3 :  hamster = ".HHH."      Buckets = -1
*/
import java.util.*;
public class Hamster
{
      public int MinimumBuckets(String hamsters)
      {
            int buckets = 0;     //* Variable declaration -> O(1)
            for(int i = 0; i < hamsters.length(); i++)    //! Comparison -> O(N)
            {
                  if(i == 0)    // for first hamster...
                  {
                        if((hamsters.charAt(i) == 'H') && (hamsters.charAt(i + 1) == 'H'))
                              return -1;    // If two hamster are at consective position...
                  }
                  else if((i > 0) && (i < hamsters.length() - 1))
                  {     // for in between hamsters...
                        if(hamsters.charAt(i) == '.')
                        {
                              if((hamsters.charAt(i + 1) == 'H') || (hamsters.charAt(i - 1) == 'H'))
                                    buckets++;     // If any place to left or right is empty...
                        }
                        else if((hamsters.charAt(i) == 'H') && (hamsters.charAt(i + 1) == 'H') && 
                        (hamsters.charAt(i - 1) == 'H'))
                              return -1;    // If three hamster are at consecutive position...
                  }
                  else
                  {
                        if((hamsters.charAt(i) == 'H') && (hamsters.charAt(i - 1) == 'H'))
                              return -1;     // If two hamster are at consecutive position...
                  }
            }
            return buckets;    // Return the number of buckets...
      }
      public static void main(String args[])
      {
            Scanner sc = new Scanner(System.in);
            String str;
            System.out.print("Enter the Sequence : ");
            str = sc.next();
            Hamster hamster = new Hamster();     // object creation...
            System.out.println("The Minimum Buckets required to feed : "+hamster.MinimumBuckets(str));
            sc.close();
      }
}


//! Time  Complexity -> O(N)
//* Space Complexity -> O(1)