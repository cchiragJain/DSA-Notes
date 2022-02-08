import java.util.*;

public class CircularLinkedListInsertDelete {
	public static void main(String[] args) {
		Node head = null;

		head = insertBeginNaive(head, 10);
		head = insertBeginNaive(head, 20);
		head = insertBeginNaive(head, 30);
		printCircularLinkedList(head);

		head = null;

		head = insertBeginEfficient(head, 5);
		head = insertBeginEfficient(head, 11);
		printCircularLinkedList(head);

		head = null;

		head = insertEndNaive(head, 10);
		head = insertEndNaive(head, 20);
		head = insertEndNaive(head, 30);
		printCircularLinkedList(head);

		head = null;

		head = insertEndEfficient(head, 10);
		head = insertEndEfficient(head, 20);
		head = insertEndEfficient(head, 30);
		head = insertEndEfficient(head, 40);
		printCircularLinkedList(head);

		// head = deleteFirstNaive(head);
		// head = deleteFirstNaive(head);
		// head = deleteFirstNaive(head);
		// head = deleteFirstNaive(head);
		// printCircularLinkedList(head);

		// head = deleteFirstEfficient(head);
		// head = deleteFirstEfficient(head);
		// printCircularLinkedList(head);

		head = deleteKthNode(head , 1);
		head = deleteKthNode(head , 2);
		printCircularLinkedList(head);
	}

	public static Node deleteKthNode(Node head, int k) {
		// assuming no of nodes >= k
		if (head.next == head) {
			return null;
		}
		if (k == 1) {
			return deleteFirstEfficient(head);
		}

		Node curr = head;
		int i = 0;
		while (i++ < k - 2) {
			curr = curr.next;
		}

		curr.next = curr.next.next;

		return head;

	}

	public static Node deleteFirstEfficient(Node head) {
		if (head == null || head.next == head) {
			return null;
		}

		// 2nd node ka data copy kar in 1st node
		head.data = head.next.data;
		// 1st node now points to the 3rd node
		head.next = head.next.next;

		return head;
	}

	public static Node deleteFirstNaive(Node head) {
		if (head == null || head.next == head) {
			return null;
		}

		Node curr = head;

		while (curr.next != head) {
			curr = curr.next;
		}

		curr.next = head.next;

		return curr.next;

	}

	public static Node insertEndEfficient(Node head, int data) {
		Node newNode = new Node(data);

		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		// add at 2nd position
		newNode.next = head.next;
		head.next = newNode;

		// swap values of 1st and second node
		int temp = head.data;
		head.data = head.next.data;
		head.next.data = temp;

		// after this our new node is at the first position but need at the last
		// so can just modify the head to point to this

		return head.next;

	}

	public static Node insertEndNaive(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		Node curr = head;

		while (curr.next != head) {
			curr = curr.next;
		}

		curr.next = newNode;
		newNode.next = head;

		return head;

	}

	public static Node insertBeginEfficient(Node head, int data) {
		// O(1)
		Node newNode = new Node(data);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		// insert between head and next node
		newNode.next = head.next;
		head.next = newNode;

		// swap head node data with the next node data
		int temp = head.data;
		head.data = head.next.data;
		head.next.data = temp;

		return head;
	}

	public static Node insertBeginNaive(Node head, int data) {
		// O(n)
		Node newNode = new Node(data);
		if (head == null) {
			newNode.next = newNode;
			return newNode;
		}

		Node curr = head;

		while (curr.next != head) {
			curr = curr.next;
		}

		curr.next = newNode;
		newNode.next = head;

		// newNode naya head bangya abh toh
		return newNode;
	}

	public static void printCircularLinkedList(Node head) {
		if (head == null || head.next == null) {
			// we are only checking for head.next if a wrong node is sent
			return;
		}

		Node temp = head;

		System.out.print(temp.data + " ");
		temp = temp.next;

		while (temp != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println();
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}