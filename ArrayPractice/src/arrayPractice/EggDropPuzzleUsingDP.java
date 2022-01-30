package arrayPractice;

/*
The following is a description of the instance of this famous puzzle involving n=2 eggs and a building with k=36 floors.
        Suppose that we wish to know which stories in a 36-story building are safe to drop eggs from, and which will cause the eggs to break on landing. We make a few assumptions:
        …..An egg that survives a fall can be used again.
        …..A broken egg must be discarded.
        …..The effect of a fall is the same for all eggs.
        …..If an egg breaks when dropped, then it would break if dropped from a higher floor.
        …..If an egg survives a fall then it would survive a shorter fall.
        …..It is not ruled out that the first-floor windows break eggs, nor is it ruled out that the 36th-floor do not cause an egg to break.
        If only one egg is available and we wish to be sure of obtaining the right result, the experiment can be carried out in only one way. Drop the egg from the first-floor window; if it survives, drop it from the second-floor window. Continue upward until it breaks. In the worst case, this method may require 36 droppings. Suppose 2 eggs are available. What is the least number of egg-droppings that is guaranteed to work in all cases?
        The problem is not actually to find the critical floor, but merely to decide floors from which eggs should be dropped so that the total number of trials are minimized.
*/
public class EggDropPuzzleUsingDP {

    static int noOfFloors=10,noOfEggs=2;
    static int[][] dp=new int[noOfEggs+1][noOfFloors+1];

    public static void main(String [] args){
        System.out.println(findMinNoOfTrails());

    }

    private static int findMinNoOfTrails() {
        int res = 0;
        for(int i=0;i<noOfFloors;i++){

            dp[1][i]=i;
        }
        for(int j=0;j<noOfEggs;j++){
            dp[j][0]=0;
            dp[j][1]=1;
        }
        for(int i=2;i<=noOfEggs;i++){
            for(int j=2;j<=noOfFloors;j++){
                dp[i][j]=Integer.MAX_VALUE;
                for(int x=1;x<=j;x++) {
                    res=1+Math.max(dp[i-1][x-1],dp[i][j-x]);
                    if(res<dp[i][j]){
                        dp[i][j]=res;
                    }
                }
            }
        }
        return dp[noOfEggs][noOfFloors];
    }
}
