import java.util.Stack;

public class NonRecursiveTraversals {
	
	public static void main(String[] args) {
		/*Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		postOrderNonRecursiveTraversal(root);*/
		
		int[] arr = {3,2,0,1};
		int n = arr.length;
		for (int i=0; i < n; i++) 
	        arr[i] += (arr[arr[i]]%n)*n;
		
		for (int i=0; i<n; i++) { 
	        arr[i] /= n;
	        System.out.print(arr[i]+" ");
		}
	}
	
	public static void preOrderNonRecursiveTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		
		while(true) {
			while(root != null) {
				System.out.print(root.data+" ");
				stack.push(root);
				
				root = root.left;
			}
			
			if(stack.isEmpty())
				break;
			
			root=stack.pop();
			
			root=root.right;
		}
	}
	
	//Similar to pre-order. Instead of printing it before popping it should be printed after popping.
	public static void inOrderNonRecursiveTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		
		while(true) {
			while(root!=null) {
				stack.push(root);
				
				root=root.left;
			}
			
			if(stack.isEmpty())
				break;
			
			root = stack.pop();
			
			System.out.print(root.data+" ");
			
			root=root.right;
		}
	}
	
	public static void postOrderNonRecursiveTraversal(Node root) {
		Stack<Node> stack = new Stack<>();
		Node previous=null;
		do{
			while(root!=null) {
				stack.push(root);
				root=root.left;
			}
		
			while(root==null && !stack.isEmpty()) {
				root = stack.peek();
				
				if(root.right==null || root.right==previous) {
					System.out.print(root.data+" ");
					stack.pop();
					previous=root;	
					root=null;
				}else
					root=root.right;
			}
		}while(!stack.isEmpty());
	}
	
}
