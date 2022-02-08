import java.util.*;

public class LinkedListInsertDelete {
	public static void main(String[] args) {
		Node<Integer> head = null;

		// head = insertBegin(head, 10);
		// head = insertBegin(head, 20);
		// head = insertBegin(head, 30);

		// printLinkedList(head);

		// head = null;
		// head = insertEnd(head, 10);
		// head = insertEnd(head, 20);
		// head = insertEnd(head, 30);

		// printLinkedList(head);

		// head = deleteFirst(head);
		// head = deleteFirst(head);
		// head = deleteFirst(head);

		// printLinkedList(head);
		// linked list will be empty here

		head = insertEnd(head, 10);
		head = insertEnd(head, 20);
		head = insertEnd(head, 30);
		printLinkedList(head);

		// head = deleteLast(head);
		// head = deleteLast(head);
		// printLinkedList(head);

		head = insertAtPosition(head, 2, 15);
		head = insertAtPosition(head, 5, 200);
		head = insertAtPosition(head, 1 , 5);
		head = insertAtPosition(head, 10, 1000);
		printLinkedList(head);

	}

	public static Node<Integer> insertAtPosition(Node<Integer> head, int pos, int data) {
		Node<Integer> newNode = new Node<>(data);
		if (pos == 1) {
			newNode.next = head;
			return newNode;
		}

		Node<Integer> curr = head;
		for (int i = 0; i < pos - 2 && curr != null; i++) {
			curr = curr.next;
		}

		// if curr becomes null then pos must have been > than size
		if (curr == null) {
			return head;
		}

		newNode.next = curr.next;
		curr.next = newNode;

		return head;
	}

	public static Node<Integer> deleteLast(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;

		Node<Integer> curr = head;

		// calculate second last node
		while (curr.next.next != null) {
			curr = curr.next;
		}

		// second last aur last ka connection tod do
		curr.next = null;

		return head;
	}

	public static Node<Integer> deleteFirst(Node<Integer> head) {
		if (head == null) {
			return head;
		}
		head = head.next;
		return head;
	}

	public static Node<Integer> insertBegin(Node<Integer> head, int x) {
		Node<Integer> newNode = new Node<>(x);
		newNode.next = head;
		return newNode;
	}

	public static Node<Integer> insertEnd(Node<Integer> head, int x) {
		Node<Integer> newNode = new Node<>(x);
		if (head == null) {
			return newNode;
		}

		Node<Integer> tail = head;
		// calculate tail
		while (tail.next != null) {
			tail = tail.next;
		}

		// create a new node and make the tail point to it
		tail.next = newNode;

		return head;
	}

	public static void printLinkedList(Node<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}