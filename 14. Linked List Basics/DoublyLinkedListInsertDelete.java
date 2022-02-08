import java.util.*;

public class DoublyLinkedListInsertDelete {
	public static void main(String[] args) {
		Node head = null;

		head = insertBegin(head, 10);
		head = insertBegin(head, 20);
		head = insertBegin(head, 30);

		printLinkedList(head);

		head = insertEnd(head, 20);
		head = insertEnd(head, 30);

		printLinkedList(head);

		head = deleteFirst(head);
		head = deleteFirst(head);

		printLinkedList(head);

		head = deleteLast(head);
		head = deleteLast(head);
		head = deleteLast(head);

		printLinkedList(head);
	}

	public static Node deleteLast(Node head) {
		if (head == null || head.next == null) {
			return null;
		}
		Node curr = head;
		// can also find the last and then for it go to curr.prev.next = null
		while (curr.next.next != null) {
			curr = curr.next;
		}

		curr.next = null;

		return head;
	}

	public static Node deleteFirst(Node head) {
		if (head == null || head.next == null) {
			return null;
		}

		head = head.next;
		head.prev = null;

		return head;
	}

	public static Node insertEnd(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			return newNode;
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = newNode;
		newNode.prev = curr;

		return head;

	}

	public static Node insertBegin(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			return newNode;
		}

		newNode.next = head;
		head.prev = newNode;

		return newNode;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}

class Node {
	int data;
	Node prev;
	Node next;

	Node(int data) {
		this.data = data;
	}
}