import java.util.*;

public class SortedInsert {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);

		head = sortedInsert(head, 35);
		head = sortedInsert(head, 1);
		head = sortedInsert(head, 23);
		head = sortedInsert(head, 50);
		head = sortedInsert(head, -6);
		printLinkedList(head);

	}

	public static Node sortedInsert(Node head, int data) {
		Node newNode = new Node(data);
		if (head == null) {
			return newNode;
		}
		if (head.data > data) {
			newNode.next = head;
			return newNode;
		}

		Node curr = head;

		while (curr.next != null && curr.next.data < data) {
			curr = curr.next;
		}

		newNode.next = curr.next;
		curr.next = newNode;

		return head;

	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}