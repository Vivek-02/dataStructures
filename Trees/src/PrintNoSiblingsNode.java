
public class PrintNoSiblingsNode {
	
	public void printNoSiblingsNode(Node node) {
		if(node==null)
			return;
		
		if(node.left!=null && node.right!=null) {
			printNoSiblingsNode(node.left);
			printNoSiblingsNode(node.right);
		}
		
		else if(node.left!=null) {
			System.out.print(node.left.data+" ");
			printNoSiblingsNode(node.left);
		}
		
		else if(node.right!=null) {
			System.out.print(node.right.data+" ");
			printNoSiblingsNode(node.right);
		}
	}
}
