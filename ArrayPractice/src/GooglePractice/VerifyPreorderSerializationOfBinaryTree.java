package GooglePractice;

public class VerifyPreorderSerializationOfBinaryTree {
    public static void main(String[] args){
        String input="9,3,4,#,#,1,#,#,2,#,6,#,#";
        System.out.println(check(input));
    }

    private static boolean check(String input) {
        String[] nodes=input.split(",");
        int vacancy=1;
        for(String s:nodes){
            vacancy--;
            if(vacancy<0){
                return false;
            }
            if(!s.equals("#")){
                vacancy=vacancy+2;
            }
        }
        return vacancy==0;
    }
}
