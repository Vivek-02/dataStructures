
public class BoundaryNodesOperations {
	//Node root;
	
	void printLeftBoundary(Node root) {
		if(root!=null) {
			if(root.left!=null) {
				System.out.print(root.data+" ");
				printLeftBoundary(root.left);
			}
			else if(root.right!=null) {
				System.out.print(root.data+" ");
				printLeftBoundary(root.right);
			}
		}
	}
	
	void printRightBoundary(Node root) {
		if(root!=null) {
			if(root.right!=null) {
				printRightBoundary(root.right);
				System.out.print(root.data+" ");
			}
			else if(root.left!=null) {
				printRightBoundary(root.left);
				System.out.print(root.data+" ");
			}
		}
	}
	
	void printLeaves(Node root) {
		if(root!=null) {
			printLeaves(root.left);
			if((root.left==null) && (root.right==null))
				System.out.print(root.data+" ");
			printLeaves(root.right);					
		}
	}
	
	void printBoundary(Node root) {
		if(root!=null) {
			System.out.print(root.data+" ");
			printLeftBoundary(root.left);
			printLeaves(root);
			printRightBoundary(root.right);
		}
	}
}
