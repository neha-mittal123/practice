package GooglePractice;

//Given two integers x and n, write a function to compute xn. We may assume that x and n are small and overflow doesn’t happen.

public class PowerMethodImplementation {
    public static void main(String[] args){
        int x=2,y=3;
        System.out.println(power(x,y));
    }

    private static int power(int x, int y) {
        int result=1;
        while(y>0){
            if(y%2==0){
                x=x*x;
                y=y/2;
            }else{
                result=result*x;
                y=y-1;
            }
        }
        return  result;
    }
}
