package GooglePractice;

import java.util.*;

public class ReconstructItinerary {

    public static void main(String[] args){
        String[][] tickets= {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
        HashMap<String,ArrayList<String>> adj=new HashMap<>();
        ArrayList<String> temp;
        for(String[] entry: tickets){
            if(!adj.containsKey(entry[0])){
                temp=new ArrayList<>();
            }else{
                temp=adj.get(entry[0]);
            }
            temp.add(entry[1]);
            Collections.sort(temp);
            adj.put(entry[0],temp);
        }
        for(String s:checkReconstructedItinerary(adj))
            System.out.print(s+" ");

    }

    private static ArrayList<String> checkReconstructedItinerary(HashMap<String, ArrayList<String>> adj) {
        ArrayList<String> res=new ArrayList<>();
        Stack<String> myStack=new Stack<>();
        myStack.add("JFK");
        while(!myStack.isEmpty()){
            String str=myStack.peek();
            if(adj.get(str).size()==0){
                res.add(str);
                myStack.pop();
            }else{
                ArrayList<String> arr = adj.get(str);
                if(arr.size()>0){
                    myStack.add(arr.remove(0));
                    adj.put(str,arr);
                }
            }
        }
        while(!myStack.isEmpty()){
            res.add(myStack.pop());
        }
         Collections.reverse(res);
        return res;
    }
}
