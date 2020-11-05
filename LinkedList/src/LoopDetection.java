
public class LoopDetection{
		
	public boolean isLoop(Node head) {
		Node slowPtr = head, fastPtr = head;
		while(fastPtr!=null && fastPtr.next!=null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
			if(slowPtr==fastPtr)
				return true;
		}
		return false;
	}
}
