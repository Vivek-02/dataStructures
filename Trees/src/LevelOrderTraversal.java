
public class LevelOrderTraversal {
	
	public void levelOrder(Node root) {
		
		if(root==null)
			return;
		
		System.out.println(root.data+" ");
		
		if(root.left!=null) {
			System.out.print(root.left.data+" "+root.data+" ");
			levelOrder(root.left);
		}
		
		if(root.right!=null) {
			System.out.print(root.data+" ");
			levelOrder(root.right);
		}
	}
	
	public static void main(String[] args) {
		
	}
		//System.out.println(printTotalPaths(arr.length-1,arr[0].length-1,arr));
}
