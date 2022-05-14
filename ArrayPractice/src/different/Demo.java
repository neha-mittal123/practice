package different;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class Demo {
    public int firstMissingPositive(int[] nums) {
        Set<Integer> set1 = new HashSet<Integer>();

        for(int num : nums){
            if(num > 0)
                set1.add(num);
        }

        Iterator<Integer> itr = set1.iterator();

        int firstElement = itr.next();

        if(firstElement > 1){
            return 1;
        }
        int currElement = -1;
        while(itr.hasNext()){
            currElement = itr.next();
            if(currElement == firstElement+1){
                firstElement = currElement;
                continue;
            }else{
                return firstElement+1;
            }
        }
        return currElement+1;
    }
}
