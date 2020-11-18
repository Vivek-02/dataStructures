/*We are given a binary tree (with root node root), a target node, and an integer value K.
Return a list of the values of all nodes that have a distance K from the target node.
The answer can be returned in any order. */

import java.util.ArrayList;

public class NodesAtDistance {
	
	ArrayList<Integer> list = new ArrayList<>();
	int dist;
	Node target;
	int k;
	
	public ArrayList<Integer> findNodesAtDistanceFromTarget(Node root, Node target, int k){
		this.k = k;
		this.target = target;
		dfs(root);
		return list;
	} 
	
	public ArrayList<Integer> findNodesAtDistanceUtil(Node root, int k, int dist){
		if(root==null)
			return  list;
		
		if(dist==k)
			list.add(root.data);
		else if(dist>k)
			return list;
		
		findNodesAtDistanceUtil(root.left, k, dist+1);
		findNodesAtDistanceUtil(root.right, k, dist+1);
		
		return list;
	}
	
	public int dfs(Node root) {
		if(root==null)
			return -1;
		
		if(root==target) {
			subtree_add(root,0);
			return 1;
		}else {
			int l=dfs(root.left);
			int r=dfs(root.right);
			if(l!=-1) {
				if(l==k)
					list.add(root.data);
				subtree_add(root.right,l+1);
				return l+1;
			}else if(r!=-1) {
				if(r==k)
					list.add(root.data);
				subtree_add(root.left,r+1);
				return r+1;
			}else
				return -1;
		}
	}
	
	public void subtree_add(Node root, int dist) {
		if(root==null)
			return;
		if(dist==k)
			list.add(root.data);
		else {
			subtree_add(root.left,dist+1);
			subtree_add(root.right,dist+1);
		}
	}
	
	
}
