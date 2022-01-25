package arrayPractice;

import java.util.ArrayList;
import java.util.List;

public class CraftDemo {

	static int sum = 0;
	class Node {
		int data;
		int parent;
		Node left, right;

		public Node(int data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
			this.parent = -1;
		}

	}

	public List<Node> removeNode(Node root, List<Integer> deleteNode) {
		ArrayList<Node> list = new ArrayList<Node>();
		while (deleteNode.iterator().hasNext()) {
			int del = deleteNode.iterator().next();
			addToList(helper(root,del , list), list,del);
		}
		return list;
	}

	public Node helper(Node root, int deleteNode, ArrayList<Node> list) {

			if (root == null) {
				return null;
			}

			if (root.data == deleteNode) {
				if (root.left != null) {
					addToList(root.left, list,deleteNode);
				}
				if (root.right != null) {
					addToList(root.right, list,deleteNode);
				}
				return null;
			} else {
				root.left = helper(root.left, deleteNode, list);
				root.right = helper(root.right, deleteNode, list);
				return root;
			}
	}

	public void addToList(Node node, ArrayList<Node> list,int deleteNode) {
		if (node != null) {
			list.add(node);
		}
		while (list.iterator().hasNext()) {
			if(list.iterator().next().data == deleteNode) {
				list.iterator().remove();
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CraftDemo tree = new CraftDemo();
		Node root = tree.new Node(10);
		root.left = tree.new Node(12);
		root.right = tree.new Node(3);
		root.left.left = tree.new Node(4);
		root.left.right = tree.new Node(5);
		root.right.right = tree.new Node(6);
		root.right.right.left = tree.new Node(7);
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);
		list1.add(3);
		//List<Node> list = tree.removeNode(root, list1);
		/*
		 * for (Node n : list) { System.out.println(n.data); }
		 */
		tree.calculateSum(root,2);
		System.out.println(sum);
		
	}
	
	public static void calculateSum(Node root,int node) {
		if(root == null) {
			return;
		}
		if(root.data == node || root.parent == node) {
			sum = sum+root.data;
			if(root.left != null) {
				root.left.parent = node;
			}if(root.right != null) {
				root.right.parent = node;
			}
			
		}
		calculateSum(root.left,node);
		calculateSum(root.right,node);
				
	}

	
}
