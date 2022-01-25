package arrayPractice;

public class ConvertGivenTreeToItsSumTree {

     class Node {
        int data;
        Node left, right;

        Node(int data) {
            super();
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }
    static Node root;

    public static void main(String[] args){
        ConvertGivenTreeToItsSumTree tree=new ConvertGivenTreeToItsSumTree();
        root= tree.new Node(10);
        root.left= tree.new Node(-2);
        root.right= tree.new Node(6);
        root.left.left=tree.new Node(8);
        root.left.right=tree.new Node(-4);
        root.right.left=tree.new Node(7);
        root.right.right=tree.new Node(5);
            makeSumTree(root);
        inOrderTrvaerslToCheckSumTree(root);

    }

    private static void inOrderTrvaerslToCheckSumTree(Node root) {
        if(root==null){
            return;
        }
        inOrderTrvaerslToCheckSumTree(root.left);
        System.out.print(root.data+" ");
        inOrderTrvaerslToCheckSumTree(root.right);
    }

    private static int makeSumTree(Node root) {
        if(root==null){
            return 0;
        }
        int oldVal=root.data;
        root.data=makeSumTree(root.left)+makeSumTree(root.right);
        return root.data+oldVal;
    }
}
