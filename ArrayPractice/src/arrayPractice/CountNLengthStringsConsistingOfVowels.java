package arrayPractice;

import java.util.*;

public class CountNLengthStringsConsistingOfVowels {

        // Function to count N-length strings
// consisting of vowels only sorted
// lexicographically
        static int findNumberOfStrings(int n)
        {
            // Stores count of strings consisting
            // of vowels sorted lexicographically
            // of all possible lengths
            int DP[][] = new int [n + 1][6];

            // Initialize DP[1][1]
            DP[1][1] = 1;

            // Traverse the matrix row-wise
            for (int i = 1; i < n + 1; i++)
            {
                for (int j = 1; j < 6; j++)
                {
                    // Base Case
                    if (i == 1)
                    {
                        DP[i][j] = DP[i][j - 1] + 1;
                    }

                    else
                    {
                        DP[i][j] = DP[i][j - 1] +
                                DP[i - 1][j];
                    }
                }
            }
            for(int i=0;i< DP.length;i++){
                for(int j=0;j< DP[0].length;j++){
                    System.out.print(DP[i][j]+" ");
                }
                System.out.println();
            }
            // Return the result
            return DP[n][5];
        }

        //second approach
       public static int findNumberOfStringsBetterApproach(int N)
        {
            // Initializing vector to store count of strings.
            Vector<Integer> counts = new Vector<Integer>();
            for(int i = 0; i < 5; i++)
            {
                counts.add(1);
            }

            for (int i = 2; i <= N; i++) {
                for (int j = 3; j >= 0; j--)
                    counts.set(j, counts.get(j) + counts.get(j + 1));
            }

            int ans = 0;

            // Summing up the total number of combinations.
            for(Integer c : counts)
                ans += c;

            // Return the result
            return ans;
        }

        // Driver Code
        public static void main(String[] args)
        {
            int N = 2;

            // Function Call
            System.out.print(findNumberOfStrings(N));
        }
}
