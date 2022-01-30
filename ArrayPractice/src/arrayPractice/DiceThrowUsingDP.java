package arrayPractice;

/*Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. X is the summation of values on each face when all the dice are thrown.

        Let the function to find X from n dice is: Sum(m, n, X)
        The function can be represented as:
        Sum(m, n, X) = Finding Sum (X - 1) from (n - 1) dice plus 1 from nth dice
        + Finding Sum (X - 2) from (n - 1) dice plus 2 from nth dice
        + Finding Sum (X - 3) from (n - 1) dice plus 3 from nth dice
        ...................................................
        ...................................................
        ...................................................
        + Finding Sum (X - m) from (n - 1) dice plus m from nth dice

        So we can recursively write Sum(m, n, x) as following
        Sum(m, n, X) = Sum(m, n - 1, X - 1) +
        Sum(m, n - 1, X - 2) +
        .................... +
        Sum(m, n - 1, X - m)*/
public class DiceThrowUsingDP {

    public static long findWays(int m, int n, int x){

    /* Create a table to store the results of subproblems.
    One extra row and column are used for simplicity
    (Number of dice is directly used as row index and sum is directly used as column index).
    The entries in 0th row and 0th column are never used. */
        long[][] table = new long[n+1][x+1];

        /* Table entries for only one dice */
        for(int j = 1; j <= Math.min(m,x); j++)
            table[1][j] = 1;

    /* Fill rest of the entries in table using recursive relation
    i: number of dice, j: sum */
        for(int i = 2; i <= n;i ++){
            for(int j = 1; j <= x; j++){
                for(int k = 1; k < j && k <= m; k++)
                    table[i][j] += table[i-1][j-k];
            }
        }


        /*for(int i = 0; i< n+1; i++){
            for(int j = 0; j< x+1; j++)
                System.out.print(table[i][j] + " ");
            System.out.println();
        }*/

        return table[n][x];
    }

    public static void main(String[] args){
        //System.out.println(findWays(4, 2, 1));
        //System.out.println(findWays(2, 2, 3));
        System.out.println(findWays(6, 3, 8));
        //System.out.println(findWays(4, 2, 5));
       // System.out.println(findWays(4, 3, 5));
    }
}
