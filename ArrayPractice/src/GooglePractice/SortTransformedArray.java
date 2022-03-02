package GooglePractice;

public class SortTransformedArray {
    public static void main(String[] args){
        int [] nums={-4, -2, 2, 4};
        int  a = 1, b = 3, c = 5;
        for(int i:findSortedNumsAfterTransformation(nums,a,b,c)){
            System.out.print(i+" ");
        }
    }

    private static int[] findSortedNumsAfterTransformation(int[] nums, int a, int b, int c) {
        if(nums==null || nums.length<=1){
            return nums;
        }
        int[] res=new int[nums.length];
        if(a>0){
            int l=0,k=nums.length-1;
            int r=k;
            while(k>=0){
                int left=getElement(nums[l],a,b,c);
                int right=getElement(nums[r],a,b,c);
                if(left>right){
                    res[k]=left;
                    l++;
                }else{
                    res[k]=right;
                    r--;
                }
                k--;
            }
        }else if(a<0){
            int l=0,r=nums.length-1,k=0;
            while(k<nums.length){
                int left=getElement(nums[l],a,b,c);
                int right=getElement(nums[r],a,b,c);
                if(left<right){
                    res[k]=left;
                    l++;
                }else{
                    res[k]=right;
                    r--;
                }
                k++;
            }

        }else{
            for(int i=0;i<nums.length;i++){
                res[i]=getElement(nums[i],0,b,c);
            }
            if(b<0){
                int l=0,r=res.length-1;
                while(l<r){
                    int temp=res[l];
                    res[l]=res[r];
                    res[r]=temp;
                    l++;
                    r--;
                }
            }

        }
        return res;
    }

    private static int getElement(int num, int a, int b, int c) {
        return a*num*num+b*num+c;
    }
}
