
public class SideView {
	Node root;
	static int max_level = 0;
	
	//left view of tree
	public void leftView(Node root, int level) {
		if(root==null)
			return;
		if(max_level<level) {
			System.out.print(root.data+" ");
			max_level = level;
		}
		leftView(root.left,level+1);
		leftView(root.right,level+1);
	}
	
	//right view of tree
	public void rightView(Node root, int level) {
		if(root==null)
			return;
		if(max_level<level) {
			System.out.print(root.data+" ");
			max_level=level;
		}
		rightView(root.right,level+1);
		rightView(root.left,level+1);
	}
}
