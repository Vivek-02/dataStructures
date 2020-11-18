//For all kinds of sum problems on trees.
public class SumTree extends Tree{
	
	//Sum at max Depth
	public int sumMaxDepth(Node root,int maxDepth) {
		if(root==null)
			return 0;
		if(maxDepth==1)
			return root.data;
		return (sumMaxDepth(root.left,maxDepth-1)+sumMaxDepth(root.right,maxDepth-1));
	}
}
