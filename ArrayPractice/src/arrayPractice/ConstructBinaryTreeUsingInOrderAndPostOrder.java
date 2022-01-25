package arrayPractice;

import java.util.Stack;

import arrayPractice.IterativeTreeTraversal.Node;

public class ConstructBinaryTreeUsingInOrderAndPostOrder {
	static Node root;
	class Node{
		char data;
		Node left,right;
		public Node(char data) {
			super();
			this.data = data;
			this.left = null;
			this.right = null;
		}
		public Node() {
			super();
		}
		
		
	}
	public static void main(String[] args) {
		String inOrder="DBEAFC";
		String postOrder="DEBFCA";//ABDECF
		Node head=constructBinaryTree(inOrder,postOrder);
		System.out.println("root is"+head.data);
		preOrderTraverse(head);

	}

	private static Node constructBinaryTree(String inOrder, String postOrder) {
		ConstructBinaryTreeUsingInOrderAndPostOrder tree = new ConstructBinaryTreeUsingInOrderAndPostOrder();
		Node node;
		if(inOrder.length() == 0) {
			return null;
		}
		if(postOrder.length() == 1) {
			Character rootElement=postOrder.charAt(0);
			node = tree.new Node(rootElement);
			return node;
		}
		if(inOrder.length() == 1) {
			Character rootElement=inOrder.charAt(0);
			node = tree.new Node(rootElement);
			return node;
		}
		Character rootElement=postOrder.charAt(postOrder.length()-1);
		node = tree.new Node(rootElement);
		//root = node;
		int rootPos = inOrder.indexOf(rootElement);
		node.left=constructBinaryTree(inOrder.substring(0, rootPos), postOrder.substring(0, rootPos));
		node.right=constructBinaryTree(inOrder.substring(1+rootPos,inOrder.length()), postOrder.substring(rootPos, postOrder.length()-1));
		
		
		return node;
	}
	
	@SuppressWarnings("unused")
	private static void preOrderTraverse(Node head) {
		Stack<Node> s = new Stack<>();
		s.push(head);
		while (!s.empty()) {
			Node data = s.pop();
			System.out.print(" " + data.data);
			if (data.right != null) {
				s.push(data.right);
			}
			if (data.left != null) {
				s.push(data.left);
			}

		}

	}

}
