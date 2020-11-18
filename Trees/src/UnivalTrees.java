
public class UnivalTrees {
	
	private int count=0;
	
	public int countUnivalTrees(Node root) {
		if(root==null)
			return 0;
		isUnival(root);
		return count;
	}
	
	public boolean isUnival(Node node) {
		if(node.left==null && node.right==null) {
			count++;
			return true;
		}
		
		boolean is_unival = true;
		
		if(node.left!=null)
			is_unival = isUnival(node.left) && is_unival && node.left.data == node.data;
		
		if(node.right!=null)
			is_unival = isUnival(node.right) && is_unival && node.right.data == node.data;
		
		if(!is_unival)
			return false;
		
		count++;
		return true;
		
	}
}
