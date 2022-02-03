package com.company;

import sun.awt.image.ImageWatched;

import javax.jnlp.IntegrationService;
import java.util.*;

public class GraphAlgos {

    static class Node{
        int data,parent;
        public Node(int data,int parent) {
            this.data = data;
            this.parent = parent;
        }
    }

    static int noOfNodesUndirected = 8,noOfNodesDirected=9;
    static int m = 6;
    static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> adjacencyListOfDirectedGraph=new ArrayList<>();
    static int[] visitedUndirectedGraph = new int[noOfNodesUndirected+1];
    static int[] visitedDirectedGraph=new int[noOfNodesDirected+1];
    static int[] DFSVistiedDirectedGraph=new int[noOfNodesDirected+1];
    static Queue<Integer> queueUndirectedGraph= new LinkedList<>();
    static Queue<Integer> queueDirectedGraph = new LinkedList<>();
    static Queue<Node> nodeQueue=new LinkedList<>();
    static ArrayList<Integer> result = new ArrayList<>();
    static Stack<Integer> stackFortopologicalSortDirectedGraph = new Stack<>();
    static int[] inDegreeForCycleDetectionInDirectedGraphUsingTopologicalSortBFS = new int[noOfNodesDirected+1];
    static int[] distanceUndirectedGraph=new int[noOfNodesUndirected+1];
    public static void main(String args[]){
        for(int i=1;i<=noOfNodesUndirected+1;i++){
            al.add(new ArrayList<>());
            adjacencyListOfDirectedGraph.add(new ArrayList<>());
        }
        for(int i=1;i<=noOfNodesDirected+1;i++){
            adjacencyListOfDirectedGraph.add(new ArrayList<>());
        }
        createListForUndirectedGraph();
        createListForDirectedGraph();
        Arrays.fill(visitedUndirectedGraph,0);
        Arrays.fill(visitedDirectedGraph,0);
        Arrays.fill(DFSVistiedDirectedGraph,0);
        for(int i=1;i<=noOfNodesUndirected;i++){
            if(visitedUndirectedGraph[i] == 0){
                bfsTraversal(i);
            }
        }
        System.out.println("BFS");
        for(Integer i : result){
            System.out.println(i);
        }

        Arrays.fill(visitedUndirectedGraph,0);
        result.clear();
        for(int i=1;i<=noOfNodesUndirected;i++){
            if(visitedUndirectedGraph[i] == 0){
                dfsTraversal(i);
            }
        }
        System.out.println("DFS");
        for(Integer i : result){
            System.out.println(i);
        }

        System.out.println("Detect Cycle in Undirected graph using bfs");
        Arrays.fill(visitedUndirectedGraph,0);
        boolean flag=false;
        for(int i=1;i<=noOfNodesUndirected;i++){
            if(visitedUndirectedGraph[i] == 0){
                if(bfsDetectCycleInUndirectedGraph(i)){
                    flag=true;
                }
            }
        }
        System.out.println(flag);

        System.out.println("Detect Cycle in Undirected graph using dfs");
        Arrays.fill(visitedUndirectedGraph,0);
        flag=false;
        for(int i=1;i<=noOfNodesUndirected;i++){
            if(visitedUndirectedGraph[i] == 0){
                if(dfsDetectCycleInUndirectedGraph(i,-1)){
                    flag=true;
                }
            }
        }
        System.out.println(flag);

        System.out.println("Detect bipartite graph using bfs");
        Arrays.fill(visitedUndirectedGraph,-1);
        flag=false;
        queueUndirectedGraph.clear();
        for(int i=1;i<=noOfNodesUndirected;i++){
            if(visitedUndirectedGraph[i] == -1){
                if(detectBipartiteGraphUsingBfs(i)){
                    flag=true;
                }
            }
        }
        System.out.println(flag);

        System.out.println("Detect bipartite graph using dfs");
        Arrays.fill(visitedUndirectedGraph,-1);
        flag=true;
        for(int i=1;i<=noOfNodesUndirected;i++){
            if(visitedUndirectedGraph[i] == -1){
                visitedUndirectedGraph[i] = 1;
                if(!detectBipartiteGraphUsingDfs(i)){
                    flag=false;
                }
            }
        }
        System.out.println(flag);

        System.out.println("Detect cycle for Directed Graph Using DFS");
        flag=false;
        for(int i=1;i<noOfNodesDirected;i++){
            if(visitedDirectedGraph[i]==0){
                if(detectCycleInDirectedGraphUsingDFS(i)){
                    flag=true;
                }
            }
        }
        System.out.println(flag);

        System.out.println("Detect cycle for Directed Graph Using BFS");
        Arrays.fill(visitedDirectedGraph,0);
        Arrays.fill(DFSVistiedDirectedGraph,0);
        flag=false;
        for(int i=1;i<noOfNodesDirected;i++){
            if(visitedDirectedGraph[i]==0){
                if(detectCycleInDirectedGraphUsingBFS(i)){
                    flag=true;
                }
            }
        }
        System.out.println(flag);

        System.out.println("Topological Sort using DFS");
        Arrays.fill(visitedDirectedGraph,0);
        stackFortopologicalSortDirectedGraph.empty();
        for(int i=1;i<noOfNodesDirected;i++){
            if(visitedDirectedGraph[i]==0){
               topologicalSortByDfs(i);
            }
        }
        while(!stackFortopologicalSortDirectedGraph.isEmpty()){
            System.out.println(stackFortopologicalSortDirectedGraph.pop());
        }

        System.out.println("Cycle Detection Using Topological Sort using BFS");
        queueDirectedGraph.clear();
        detectCycleInDirectedGraphUsingTopologicalSortUsingBFS();

        System.out.println("shortest path in undirected graph");
        Arrays.fill(distanceUndirectedGraph,100);
        int source=1;
        queueUndirectedGraph.clear();

        calculateShortestPathInUndirectedGraphWithUnitWeights(source);
        for(Integer i: distanceUndirectedGraph){
            System.out.println(i);
        }

    }

    private static void calculateShortestPathInUndirectedGraphWithUnitWeights(int source) {
        distanceUndirectedGraph[source]=0;
        queueUndirectedGraph.add(source);
        while(!queueUndirectedGraph.isEmpty()){
            int element=queueUndirectedGraph.remove();
            for(Integer i: al.get(element)){
                if(distanceUndirectedGraph[element]+1<distanceUndirectedGraph[i]){
                    distanceUndirectedGraph[i]=distanceUndirectedGraph[element]+1;
                    queueUndirectedGraph.add(i);
                }
            }
        }
    }

    private static void detectCycleInDirectedGraphUsingTopologicalSortUsingBFS(){
        for(int i=1;i<=noOfNodesDirected;i++){
            for(Integer adj : adjacencyListOfDirectedGraph.get(i)){
                inDegreeForCycleDetectionInDirectedGraphUsingTopologicalSortBFS[adj]++;
            }
        }
        for(int i=1;i<inDegreeForCycleDetectionInDirectedGraphUsingTopologicalSortBFS.length;i++){
            if(inDegreeForCycleDetectionInDirectedGraphUsingTopologicalSortBFS[i] == 0){
                queueDirectedGraph.add(i);
            }
        }
        int counter=0;
        while(!queueDirectedGraph.isEmpty()){
            int element = queueDirectedGraph.remove();
            counter++;
            for(Integer adj : adjacencyListOfDirectedGraph.get(element)){
                inDegreeForCycleDetectionInDirectedGraphUsingTopologicalSortBFS[adj]--;
                if(inDegreeForCycleDetectionInDirectedGraphUsingTopologicalSortBFS[adj] == 0){
                    queueDirectedGraph.add(adj);
                }
            }
        }
        if(counter==noOfNodesDirected){
            System.out.println("cycle not detected");
        }else{
            System.out.println("cycle detected");
        }
    }
    
    //This algorithm detects false cycles in case of 5th node.
    private static boolean detectCycleInDirectedGraphUsingBFS(int i) {
        visitedDirectedGraph[i]=1;
        DFSVistiedDirectedGraph[i]=1;
        queueDirectedGraph.add(i);
        while(!queueDirectedGraph.isEmpty()){
            int element=queueDirectedGraph.remove();
            for(Integer adjElement : adjacencyListOfDirectedGraph.get(element)){
                if(visitedDirectedGraph[adjElement]==0){
                    visitedDirectedGraph[adjElement]=1;
                    DFSVistiedDirectedGraph[adjElement]=1;
                    queueDirectedGraph.add(adjElement);
                }else if(visitedDirectedGraph[adjElement]==DFSVistiedDirectedGraph[adjElement]){
                    return true;
                }
            }
            DFSVistiedDirectedGraph[i]=0;
        }
        return false;
    }

    private static boolean detectCycleInDirectedGraphUsingDFS(int i) {
        visitedDirectedGraph[i]=1;
        DFSVistiedDirectedGraph[i]=1;
        for(Integer adjElement : adjacencyListOfDirectedGraph.get(i)){
            if(visitedDirectedGraph[adjElement]==0){
                if(detectCycleInDirectedGraphUsingDFS(adjElement)){
                    return true;
                }
            }else if(visitedDirectedGraph[adjElement]==DFSVistiedDirectedGraph[adjElement]){
                return true;
            }
        }
        DFSVistiedDirectedGraph[i]=0;
        return false;
    }

    private static boolean detectBipartiteGraphUsingDfs(int i) {
        if(visitedUndirectedGraph[i] == -1){
            visitedUndirectedGraph[i] = 1;
        }
        for(Integer adjElement : al.get(i)){
            if(visitedUndirectedGraph[adjElement] == -1 ){
                visitedUndirectedGraph[adjElement] = 1 - visitedUndirectedGraph[i];
                if(!detectBipartiteGraphUsingDfs(adjElement)){
                    return false;
                }
            }else if(visitedUndirectedGraph[adjElement] == visitedUndirectedGraph[i]){
                return false;
            }
        }
        return true;
    }

    private static boolean detectBipartiteGraphUsingBfs(int i) {
        visitedUndirectedGraph[i]=1;
        queueUndirectedGraph.add(i);
        while(!queueUndirectedGraph.isEmpty()){
            int element=queueUndirectedGraph.remove();
            for(Integer adjElement : al.get(element)){
                if(visitedUndirectedGraph[adjElement]==-1){
                    visitedUndirectedGraph[adjElement]=1-visitedUndirectedGraph[element];
                    queueUndirectedGraph.add(adjElement);
                }else if(visitedUndirectedGraph[adjElement]==visitedUndirectedGraph[element]){
                    return false;
                }
            }
        }
        return true;
    }

    private static void topologicalSortByDfs(int i){
        visitedDirectedGraph[i] = 1;
        for(Integer adjElement : adjacencyListOfDirectedGraph.get(i)){
            if(visitedDirectedGraph[adjElement]==0){
                topologicalSortByDfs(adjElement);
            }
        }
        stackFortopologicalSortDirectedGraph.push(i);
    }

    private static boolean dfsDetectCycleInUndirectedGraph(int i,int parent) {
        visitedUndirectedGraph[i]=1;
        for(Integer adjElement : al.get(i)){
            //System.out.println(i);
            if(visitedUndirectedGraph[adjElement]==0){
                if(dfsDetectCycleInUndirectedGraph(adjElement,i)){
                    return true;
                }
            }else if(adjElement!=parent){
                return true;
            }
        }
        return false;
    }

    private static boolean bfsDetectCycleInUndirectedGraph(int i) {
        nodeQueue.add(new Node(i,-1));
        visitedUndirectedGraph[i]=1;
        while(!nodeQueue.isEmpty()){
            int data = nodeQueue.peek().data;
            int parent=nodeQueue.remove().parent;

            for(Integer adjElement : al.get(data)){
                //System.out.println(i);
                if(visitedUndirectedGraph[adjElement]==0){
                    nodeQueue.add(new Node(adjElement,data));
                    visitedUndirectedGraph[adjElement]=1;
                }else if(adjElement!=parent){
                    return true;
                }
            }
        }
        return false;
    }

    private static void dfsTraversal(int node) {
        result.add(node);
        visitedUndirectedGraph[node]=1;
        for(Integer i : al.get(node)){
            //System.out.println(i);
            if(visitedUndirectedGraph[i]==0){
                dfsTraversal(i);
            }
        }
    }

    private static void bfsTraversal(int node){
        //System.out.println("inside bfs");
        visitedUndirectedGraph[node] = 1;
        queueUndirectedGraph.add(node);
        while(!queueUndirectedGraph.isEmpty()){
            int element = queueUndirectedGraph.remove();
            result.add(element);
            for(Integer i : al.get(element)){
                //System.out.println(i);
                if(visitedUndirectedGraph[i]==0){
                    queueUndirectedGraph.add(i);
                    visitedUndirectedGraph[i]=1;
                }
            }
        }
    }
    private static void createListForUndirectedGraph(){
        al.get(1).add(2);
        al.get(2).add(1);
        al.get(2).add(3);
        al.get(2).add(7);
        al.get(3).add(2);
        al.get(3).add(5);
        al.get(4).add(6);
        al.get(5).add(3);
        al.get(5).add(8);
        al.get(6).add(4);
        al.get(7).add(2);
        al.get(7).add(8);
        al.get(8).add(5);
        al.get(8).add(7);
    }
    private static void createListForDirectedGraph(){
        adjacencyListOfDirectedGraph.get(1).add(2);
        adjacencyListOfDirectedGraph.get(2).add(3);
        adjacencyListOfDirectedGraph.get(3).add(4);
        adjacencyListOfDirectedGraph.get(4).add(5);
        adjacencyListOfDirectedGraph.get(3).add(6);
        adjacencyListOfDirectedGraph.get(6).add(5);
        adjacencyListOfDirectedGraph.get(7).add(2);
        adjacencyListOfDirectedGraph.get(7).add(8);
        adjacencyListOfDirectedGraph.get(8).add(9);
        adjacencyListOfDirectedGraph.get(9).add(7);
    }
}
