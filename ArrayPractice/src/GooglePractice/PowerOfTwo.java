package GooglePractice;

//Given a positive integer, write a function to find if it is a power of two or not.
//        Examples :
//
//        Input : n = 4
//        Output : Yes
//        22 = 4
//
//        Input : n = 7
//        Output : No
//
//        Input : n = 32
//        Output : Yes
//        25 = 32
public class PowerOfTwo {
    public static void main(String [] args){
        int n=8;
        System.out.println(checkPowerOfTwo(n));
    }

    private static boolean checkPowerOfTwo(int n) {
        if(n==0){
            return false;
        }
        while(n!=1){
            if(n%2!=0){
                return false;
            }
            n=n/2;
        }
        return true;
    }
}
