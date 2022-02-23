package GooglePractice;

//Roots of a tree which give minimum height
//Given an undirected graph, which has tree characteristics. It is possible to choose any node as root, the task is to find those nodes only which minimize the height of tree.
//
//        Example:
//        In below diagram all node are made as root one by one, we can see that when 3 and 4 are root, height of tree is minimum(2) so {3, 4} is our answer.
//        Input: n = 4, edges = [[1,0],[1,2],[1,3]]
//        Output: [1]
//        Explanation: As shown, the height of the tree is 1 when the root is the node with label 1 which is the only MHT.
//        Input: n = 6, edges = [[3,0],[3,1],[3,2],[3,4],[5,4]]
//        Output: [3,4]

import java.util.ArrayList;
import java.util.LinkedList;

public class MinimumHeightsTree {
    static int noOfVertices;
    static int[] degree;
    static ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
    MinimumHeightsTree(int noOfVertices){
        this.noOfVertices=noOfVertices;
        this.degree=new int[noOfVertices];
        for(int i=0;i<noOfVertices;i++){
            adj.add(new ArrayList<>());
        }
    }
    public static void main(String[] args){
        MinimumHeightsTree graph=new MinimumHeightsTree(6);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(2,3);
        graph.addEdge(4,3);
        graph.addEdge(5,4);

        for(Integer i:findRootForMinHeightTree()){
            System.out.println(i);
        }


    }

    private static ArrayList<Integer> findRootForMinHeightTree() {
        ArrayList<Integer> res=new ArrayList<>();
        LinkedList<Integer> queue=new LinkedList<>();
        for(int i=0;i<noOfVertices;i++){
            if(degree[i]==1){
                queue.addLast(i);
            }
        }
        while(noOfVertices>2){
            int currNoOfLeafNodes=queue.size();
            noOfVertices -=currNoOfLeafNodes;
            for(int i=0;i<currNoOfLeafNodes;i++){
                int temp=queue.removeFirst();
                for(Integer element:adj.get(temp)){
                    degree[element]--;
                    if(degree[element]==1){
                        queue.addLast(element);
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            res.add(queue.removeFirst());
        }
        return res;
    }

    private void addEdge(int i, int j) {
        adj.get(i).add(j);
        adj.get(j).add(i);
        degree[i]++;
        degree[j]++;
    }
}
