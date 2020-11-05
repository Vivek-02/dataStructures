
public class DoublyLinkedList {
	Node head;
	
	public void push(int item) {
		Node newNode = new Node(item);
		newNode.data = item;
		newNode.next = head;
		newNode.prev = null;
		if(head!=null)
			head.prev = newNode;	
		head = newNode;
	}
	
	public void display(Node node) {
		Node temp = null;
		System.out.println("The forward traversal is");
		while(node!=null) {
			System.out.print(node.data+" ");
			temp = node;
			node = node.next;
		}
		System.out.println();
		System.out.println("The reversed traversal is");
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.prev;
		}
	}
	
	public void displayHead() {
		System.out.println(head.data);
	}
}
