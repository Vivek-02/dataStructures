import java.util.*;
public class Tree {
	
	Node root;

	public int treeSize(Node root) {
		if(root==null)
			return 0;
		else
			return (treeSize(root.left) + 1 + treeSize(root.right));
	}

	public int maxElement(Node root) {
		int max=0, left, right;
		if(root==null) {
			return -1;
		}
		
		left = maxElement(root.left);
		right = maxElement(root.right);
		if(left>=right)
			max = left;
		else
			max = right;
		if(root.data>max)
			max = root.data;
		
		return max;
	}
	
	public boolean searchElement(Node root, int item) {
		boolean temp;
		if(root==null)
			return false;
		else {
			if(root.data==item)
				return true;
			else {
				temp = searchElement(root.left,item);
				if(temp!=false)
					return temp;
				else
					return(searchElement(root.right,item));
			}
		}
	}
	
	public int heightOfTree(Node root) {
		int left, right;
		if(root==null)
			return 0;
		else {
			left = heightOfTree(root.left);
			right = heightOfTree(root.right);
			if(left>right)
				return (left+1);
			else
				return (right+1);
		}
	}
	
	public int treeAncestors(Node root, Node node) {
		if (root==null || root==node)
			return 0;
		if(root.left==node || root.right==node || treeAncestors(root.left,node)==1 || treeAncestors(root.right,node)==1) {
			System.out.print(root.data+" ");
			return 1;
		}
		return 0;
	}
	
	public Node treeLCA(Node root, int n1, int n2) {
		if(root==null)
			return null;
		
		if(root.data==n1 || root.data==n2)
			return root;
		
		Node leftLCA = treeLCA(root.left,n1,n2);
		Node rightLCA = treeLCA(root.right,n1,n2);
		if(leftLCA!=null && rightLCA!=null)
			return root;
		else
			return (leftLCA!=null)?leftLCA:rightLCA;
	}
	
	public int findDistance(Node root, int a, int b) { 
        Node lca = treeLCA(root, a, b); 
  
        int d1 = findLevel(lca, a, 0); 
        int d2 = findLevel(lca, b, 0); 
  
        return d1 + d2; 
    } 
	
	public int findLevel(Node root, int a, int level){ 
        if (root == null) 
            return -1; 
        if (root.data == a) 
            return level; 
        int left = findLevel(root.left, a, level + 1); 
        if (left == -1) 
            return findLevel(root.right, a, level + 1); 
        return left; 
    } 
	
	public Node findNextNode(Node root,Node node) {
		if(node==null)
			return null;
		
		Queue<Node> qn = new LinkedList<Node>();
		Queue<Integer> ql = new LinkedList<Integer>();
		qn.add(root);
		ql.add(0);
		while(!qn.isEmpty()) {
			Node temp = qn.poll();
			int level = ql.poll();
			
			if(temp.data == node.data) {
				if(ql.size()==0)
					return null;
				
				return qn.peek();
			}
			
			if(temp.left!=null) {
				qn.add(temp.left);
				ql.add(level+1);
			}
				
			if(temp.right!=null) {
				qn.add(temp.right);
				ql.add(level+1);
			}
		}
		
		
		return null;
	}
	
	public void nextNode(Node root,Node node) {
		Node next = findNextNode(root,node);
		if(next!=null)
			System.out.println("The next node is "+next.data);
		else
			System.out.println("Next node not found");
	}
}
