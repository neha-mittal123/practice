package arrayPractice;

//Problem Statement
//        Given a binary tree with unique integer values. Return the vector of roots of subtrees formed after
//        removing the given node.
//        Node {
//        int id;
//        Node left;
//        Node right;
//        };
//        Vector<Integer> removeNode(Node root, int nodeToBeRemoved)
//        Example:
//                            1
//                       2          3
//                4          5          6
//                                   7
//
//        Case # Node to be removed vector of roots of subtrees (Answer) Explanation
//        1:) { 2 } [1,4,5] After removing 2 from above tree, we get 3 subtrees – {4},{5}, {1,3,6,7} so the root of subtrees are – [1,4,5].
//        2:) { 1 } [2,3] After removing 1 from above tree, we get 2 subtrees –{2,4,5}, {3,6,7} so the root of subtrees are – [2,3]

import java.util.ArrayList;
import java.util.List;

public class ReturnListOfRootsOfSubTreesFormedAfterRemovingNode {

    class Node{
        int data;
        Node left,right;
        Node(int data){
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }
    static Node root;
    public static void main(String [] args){
        ReturnListOfRootsOfSubTreesFormedAfterRemovingNode tree=new ReturnListOfRootsOfSubTreesFormedAfterRemovingNode();
         root=tree.new Node(1);
         root.left=tree.new Node(2);
         root.right=tree.new Node(3);
         root.left.left=tree.new Node(4);
         root.left.right=tree.new Node(5);
         root.right.right=tree.new Node(6);
         root.right.right.left=tree.new Node(7);
         for(Node i: removeNode(root,2)){
             System.out.println(i.data);
         }
    }
    public static List<Node> removeNode(Node root, int deleteNode){
        ArrayList<Node> list=new ArrayList<Node>();
        addToList(helper(root,deleteNode,list),list);
        return list;
    }
    public static Node helper(Node root, int deleteNode, ArrayList<Node> list){

        if(root==null){
            return null;
        }
        if(root.data==deleteNode){
                addToList(root.left,list);
                addToList(root.right,list);
            return null;
        }else{
            root.left=helper(root.left,deleteNode,list);
            root.right=helper(root.right,deleteNode,list);
            return root;
        }
    }
    public static void addToList(Node node, ArrayList<Node> list){
        if(node!=null){
            list.add(node);
        }
    }


}
