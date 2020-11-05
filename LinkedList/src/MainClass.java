
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList llist1 = new LinkedList();
		llist1.push(1);
		llist1.push(2);
		llist1.push(3);
		llist1.push(4);
		llist1.display();
		llist1.reverseList();
		System.out.println();
		System.out.println(llist1.getCount());
		llist1.display();
	}

}
