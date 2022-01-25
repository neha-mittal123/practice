package arrayPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PossibleBipartitionUsingBipartiteGraph {

	static List<List<Integer>> adjacencyList=new ArrayList<List<Integer>>();
	static int noOfNodes=5;
	static int[] color=new int[noOfNodes+1];
	public static void main(String[] args) {
		for(int i=0;i<noOfNodes;i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		int[][] dislikes= {{1,2},{2,3},{3,4},{4,5},{1,5}};
		for(int i=0;i<dislikes.length;i++) {
			for(int j=0;j<dislikes[0].length;j++) {
				adjacencyList.get(i).add(j);
				adjacencyList.get(j).add(i);
			}
		}
		Arrays.fill(color, -1);
		boolean res=checkBipartite();
		System.out.println(res);

	}
	private static boolean checkBipartite() {
		for(int i=1;i<=noOfNodes;i++) {
			if(color[i]==-1) {
				if(!isBipartite(i)) {
					return false; 
				}
			}
		}
		return true;
	}
	private static boolean isBipartite(int node) {
		Queue<Integer> queue=new LinkedList<>();
		queue.add(node);
		color[node]=1;
		while(!queue.isEmpty()) {
			int curr=queue.remove();
			for(Integer i:adjacencyList.get(curr)) {
				if(color[i]==color[curr]) {
					return false;
				}
				if(color[i]==-1) {
					color[i]=1-color[curr];
					queue.add(i);
				}
			}
		}
		return true;
	}

}
