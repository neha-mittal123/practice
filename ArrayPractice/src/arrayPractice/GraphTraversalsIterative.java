package arrayPractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



public class GraphTraversalsIterative {

	static List<List<Integer>> adjacencyList=new ArrayList<List<Integer>>();
	static int noOfNodes=5;
	static int[] visited=new int[noOfNodes];
	public static void main(String[] args) {
		for(int i=0;i<noOfNodes;i++) {
			adjacencyList.add(new ArrayList<Integer>());
		}
		addEdge(0, 1);
        addEdge(0, 4);
        addEdge(1, 2);
        addEdge(1, 3);
//        addEdge(1, 4);
//        addEdge(2, 3);
//        addEdge(3, 4);
//        addEdge(4,1);
        Arrays.fill(visited, 0);
        dfsTraversal(0);
        Arrays.fill(visited, 0);
        System.out.println();
        bfsTraversal(0);
        Arrays.fill(visited, 0);
        //boolean res=detectCycleForDirectedGraph();
        //System.out.println(res);
        Arrays.fill(visited, 0);
        boolean result=detectCycleForUnDirectedGraph();
        System.out.println(result);
	}
	private static boolean detectCycleForUnDirectedGraph() {
		boolean flag=false;
		for(int i=0;i<noOfNodes;i++) {
			visited[i]=1;
			for(int j=0;j<adjacencyList.get(i).size();j++) {
				flag=isCyclicForUnDirectedGraph(adjacencyList.get(i).get(j));
				if(flag) {
					return true;
				}
			}
			visited[i]=0;
		}
		return false;
	}
	private static boolean isCyclicForUnDirectedGraph(Integer curr) {
		if(visited[curr]==2) {
			return true;
		}
		visited[curr]=1;
		boolean flag=false;
		for(int i=0;i<adjacencyList.get(curr).size();i++) {
			if(visited[adjacencyList.get(curr).get(i)]==1) {
				visited[adjacencyList.get(curr).get(i)]=2;
			}else {
				flag=isCyclicForUnDirectedGraph(adjacencyList.get(curr).get(i));
				if(flag) {
					return true;
				}
				visited[adjacencyList.get(curr).get(i)]=1;
			}
			
		}
		visited[curr]=0;
		return false;
	}
	private static boolean detectCycleForDirectedGraph() {
		boolean flag=false;
		for(int i=0;i<noOfNodes;i++) {
			visited[i]=1;
			for(int j=0;j<adjacencyList.get(i).size();j++) {
				flag=isCyclicForDirectedGraph(adjacencyList.get(i).get(j));
				if(flag) {
					return true;
				}
			}
			visited[i]=0;
		}
		return false;
	}
	
	private static boolean isCyclicForDirectedGraph(Integer curr) {
		if(visited[curr]==1) {
			return true;
		}
		visited[curr]=1;
		boolean flag=false;
		for(int i=0;i<adjacencyList.get(curr).size();i++) {
			flag=isCyclicForDirectedGraph(adjacencyList.get(curr).get(i));
			if(flag) {
				return true;
			}
		}
		visited[curr]=0;
		return false;
	}
	private static void bfsTraversal(int source) {
		Queue<Integer> q=new LinkedList<>();
		q.add(source);
		visited[source]=1;
		while(!q.isEmpty()) {
			int curr=q.remove();
			System.out.print(curr+" ");
			for(int i=0;i<adjacencyList.get(curr).size();i++) {
				if(visited[adjacencyList.get(curr).get(i)]==0) {
					q.add(adjacencyList.get(curr).get(i));
					visited[adjacencyList.get(curr).get(i)]=1;
				}
			}
		}
		
	}
	private static void addEdge(int i, int j) {
		adjacencyList.get(i).add(j);
		adjacencyList.get(j).add(i);
	}
	private static void dfsTraversal(int source) {
		visited[source]=1;
		System.out.print(source+" ");
		for(int i=0;i<adjacencyList.get(source).size();i++) {
			if(visited[adjacencyList.get(source).get(i)]==0) {
				dfsTraversal(adjacencyList.get(source).get(i));
			}
		}
	}
	

}
