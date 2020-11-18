import java.util.*;
public class Traversals {
	Node root;
	
	public void preOrder(Node node){
		if (node==null)
			return;
		
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public void postOrder(Node node){
		if (node==null)
			return;
		postOrder(node.left);
		postOrder(node.right);
		System.out.print(node.data+" ");		
	}
	
	public void inOrder(Node node){
		if (node==null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
	}
	
	public void levelOrder(Node root) {
		if(root==null)
			return;
		
		Queue<Node> que = new LinkedList<Node>();
		que.add(root);
		while(!que.isEmpty()) {
			Node tempNode = que.poll();
			System.out.print(tempNode.data+" ");
			
			if(tempNode.left!=null)
				que.add(tempNode.left);
			
			if(tempNode.right!=null)
				que.add(tempNode.right);
		}
	}
	
	public void reverseLevelOrder(Node root) {
		if(root==null)
			return;
		Node temp;
		Queue<Node> que = new LinkedList<Node>();
		Stack<Node> st = new Stack<Node>();
		que.add(root);
		while(!que.isEmpty()) {
			temp = que.poll();
			if(temp.right!=null)
				que.add(temp.right);
			if(temp.left!=null)
				que.add(temp.left);
			st.push(temp);
		}
		while(!st.isEmpty())
			System.out.print(st.pop().data+" ");
	}
	
	static class Pair{
        Node node;
        int value;
        Pair(Node n, int item){
            node = n;
            value = item;
        }
    }

	public void topView(Node root) {
        if(root==null)
            return;
        
        Node temp = null;
        Queue<Pair> q = new LinkedList<Pair>();

        Map<Integer,Integer> map = new HashMap<Integer,Integer>();

        q.add(new Pair(root,0));

        while(q.size()>0){
            temp = q.peek().node;
            int d = q.peek().value;
            q.remove();

            if(map.get(d)==null){
                System.out.print(temp.data+" ");
                map.put(d,temp.data);
            }

            if(temp.left!=null){
                q.add(new Pair(temp.left,d-1));
            }

            if(temp.right!=null){
                q.add(new Pair(temp.right,d+1));
            }
        }
    
    }
	
	public void bottomView(Node root) {
		if(root==null)
			return;
		
		Node temp = null;
		Queue<Pair> q = new LinkedList<Pair>();
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		
		q.add(new Pair(root,0));
		while(q.size()>0){
			temp = q.peek().node;
			int d = q.peek().value;
			q.remove();
			
			map.put(d, temp.data);
			
			if(temp.left!=null) {
				q.add(new Pair(root.left,d-1));
			}
			
			if(temp.right!=null) {
				q.add(new Pair(root.right,d+1));
			}
		}
		for(int n: map.values())
			System.out.print(n+" ");
		
	}
}
