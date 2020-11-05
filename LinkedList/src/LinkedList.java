
public class LinkedList{
	
	Node head;
	
	public void push(int d) {
		Node newNode = new Node(d);
		newNode.data = d;
		newNode.next = head;
		head = newNode;		
	}
	
	public int getCount() {
		int count=0;
		Node temp = head;
		while(temp!=null) {
			count++;
			temp = temp.next;
		}		
		return count;
	}
	
	public void display() {
		Node tnode = head;
		while(tnode!=null) {
			System.out.print(tnode.data+" ");
			tnode = tnode.next;
		}
	}
	
	//Recursively print the list in reverse order
	public void reversePrint(Node head) {
		if(head == null)
			return;
		reversePrint(head.next);
		System.out.print(head.data+" ");
	}
	
	public Node reverseList() {
		Node curr=head,next=null,prev=null;
		while(curr!=null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public void deleteNode(int key) {
		Node temp = head,prev=null;
		
		if(temp==null)
			return;
		
		if(temp!=null && temp.data==key) {
			head = temp.next;
			return;
		}
		
		while(temp.data!=key) {
			prev = temp;
			temp = temp.next;		
		}
		
		prev.next = temp.next;
	}
}
