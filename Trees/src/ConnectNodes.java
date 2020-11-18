/*You are given a perfect binary tree where all leaves are 
 * on the same level, and every parent has two children.*/
public class ConnectNodes {
	
	public Node connect(Node root) {
		if(root==null)
			return root;
		
		connectUtil(root);
		
		return root;
	}
	
	public void connectUtil(Node root) {
		if(root == null)
			return;
		
		if(root.left!=null)
			root.left.next = root.right;
		
		if(root.right!=null)
			root.right.next = root.next!=null ? root.next.left : null;
		
		connectUtil(root.left);
		connectUtil(root.right);
	}
}
