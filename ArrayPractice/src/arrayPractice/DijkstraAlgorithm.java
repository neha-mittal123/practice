package arrayPractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;


public class DijkstraAlgorithm {
	private int V=5;
	private int distance[]=new int [V];
    private Set<Integer> visited=new LinkedHashSet<Integer>();
    private PriorityQueue<Node> pq=new PriorityQueue<Node>(V,new Node());
    static List<List<Node>> adjacencyMatrix;
	class Node implements Comparator<Node>{
		int node;
		int cost;
		public Node(int node, int cost) {
			super();
			this.node = node;
			this.cost = cost;
		}
		public Node() {
		}
		@Override
		public int compare(Node arg0, Node arg1) {
			if(arg0.cost>arg1.cost) {
				return 1;
			}	
			else if(arg0.cost<arg1.cost) {
				return -1;
			}
			return 0;
		}
		
	}

	public static void main(String[] args) {
		DijkstraAlgorithm dijkstraAlgorithm=new DijkstraAlgorithm();
		int V=5,source=0;
		adjacencyMatrix=new ArrayList<List<Node>>();
		for(int i=0;i<V;i++) {
			ArrayList<Node> list=new ArrayList<Node>();
			adjacencyMatrix.add(list);
		}
		adjacencyMatrix.get(0).add(dijkstraAlgorithm.new Node(1, 9));
		adjacencyMatrix.get(0).add(dijkstraAlgorithm.new Node(2, 6));
		adjacencyMatrix.get(0).add(dijkstraAlgorithm.new Node(3, 5));
		adjacencyMatrix.get(0).add(dijkstraAlgorithm.new Node(4, 3));
		adjacencyMatrix.get(2).add(dijkstraAlgorithm.new Node(1, 2));
		adjacencyMatrix.get(2).add(dijkstraAlgorithm.new Node(3, 4));
		dijkstraAlgorithm.calcShortestPath(adjacencyMatrix,source);
		for(int i=0;i<dijkstraAlgorithm.distance.length;i++) {
			System.out.println(i+" "+dijkstraAlgorithm.distance[i]);
		}
	}

	private void calcShortestPath(List<List<Node>> adjacencyMatrix, int source) {
		this.adjacencyMatrix=adjacencyMatrix;
		for(int i=0;i<V;i++) {
			distance[i]=Integer.MAX_VALUE;
		}
		distance[source]=0;
		pq.add(new Node(source,0));
		while(visited.size()!=V) {
			if(pq.isEmpty()) {
				return ;
			}
			int u=pq.remove().node;
			visited.add(u);
			visitedNeighbours(u);
		}
		
	}

	private void visitedNeighbours(int u) {
		for(int i=0;i<adjacencyMatrix.get(u).size();i++) {
			Node n=adjacencyMatrix.get(u).get(i);
			if(!visited.contains(n.node)) {
				if(distance[u]+n.cost<distance[n.node])
				distance[n.node]=distance[u]+n.cost;
				pq.add(new Node(n.node,distance[n.node]));
			}
		}
		
	}

}
