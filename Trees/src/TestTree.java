
public class TestTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree tree = new Tree();
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		
		LevelOrderTraversal lot = new LevelOrderTraversal();
		lot.levelOrder(tree.root);
	}

}
