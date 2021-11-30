package DSA;

public class MyLinkedList {
	Node head; // head of list

	/* Linked list Node*/
	class Node {
		int data;
		Node next;

		// Constructor to create a new node
		// Next is by default initialized
		// as null
		Node(int d) { 
			this.data = d; 
			next = null ;
			}
	}
	
	public void printLinkedList() {
		Node n = head;  //start from first and check till next is null
		while(n!=null) {
		System.out.println(n.data);
		n=n.next;
		}
	}

public static void main(String[] args) {
		
		MyLinkedList newData = new MyLinkedList();
		Node firstNode = newData.new Node(10);
		newData.head = firstNode;
		
		Node secNode = newData.new Node(20);
		firstNode.next = secNode ;
		newData.printLinkedList();
}


}
