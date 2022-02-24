package GooglePractice;

public class MaximumProductOfWordLengthsHavingNoCommonCharactor {
    public static void main(String [] args){
        String arr[] = { "abcw", "baz",
                "foo", "bar",
                "xtfn", "abcdef" };
        System.out.println(findMaxProduct(arr));
    }

    private static int findMaxProduct(String[] arr) {
        int[] bits=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length();j++){
                bits[i]=bits[i] | 1 << (arr[i].charAt(j)-'a');
            }
        }
        int res=0;
        for(int i=0;i<bits.length;i++){
            for(int j=i+1;j<bits.length;j++){
                if((bits[i] & bits[j])==0){
                    int L=countSetBits(bits[i]);
                    int R=countSetBits(bits[j]);
                    res=Math.max(res,L*R);
                }
            }
        }
        return res;
    }

    private static int countSetBits(int bit) {
        int count=0;
        while(bit>0){
            count =count+(bit & 1);
            bit = bit >> 1;
        }
        return count;
    }
}
