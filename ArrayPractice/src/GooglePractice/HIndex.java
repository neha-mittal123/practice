package GooglePractice;

//Find H-Index for sorted citations using Binary Search
//Given an array citations[] consisting of N integers in non-increasing order, representing citations, the task is to find the H-index.
//
//        H-Index is usually assigned to the researcher denoting the contributions made in terms of no of papers and citations. H-index(H) is the largest value
//        such that the researcher has at least H papers cited at least H times.
//
//        Examples:
//
//        Input: citations[] = {5, 3, 3, 0, 0}
//        Output: 3
//        Explanation:
//        There are atleast 3 papers (5, 3, 3) with atleast 3 citations
//        Input: citations[] = {5, 4, 2, 1, 1}
//        Output: 2
//        Explanation:
//        There are atleast 2 papers (5, 4, 2) with atleast 2 citations.

public class HIndex {
    public static void main(String[] args){
        int [] citations={5, 4, 2, 1, 1};
        System.out.print(findHIndex(citations));
    }

    private static int findHIndex(int[] citations) {
        int low=0,high=citations.length-1,mid=0,hIndex=0;
        while(low<=high){
            mid=(low+high)/2;
            if(citations[mid]>=mid+1){
                low=mid+1;
                hIndex=mid+1;
            }else{
                high=mid-1;
            }
        }
        return hIndex;
    }
}