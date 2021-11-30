package DSA;

public class AddElementInLinkedLIst {
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
	
	public static AddElementInLinkedLIst insert(AddElementInLinkedLIst newData , int data) {
		
		// Create a new node with given data
		Node new_node = newData.new Node(data);
				new_node.next = null;
	    // If the Linked List is empty,
			// then make the new node as head
			if (newData.head == null) {
				newData.head = new_node;
			}
			else {
				// Else traverse till the last node
				// and insert the new_node there
				Node last = newData.head;
				while (last.next != null) {
					last = last.next;
				}

				// Insert the new_node at last node
				last.next = new_node;
			}
		return newData;
	}

public static void main(String[] args) {
		
	AddElementInLinkedLIst newData = new AddElementInLinkedLIst();
		
		newData = insert(newData , 10);
		newData = insert(newData , 20);
		newData.printLinkedList();
}




}
