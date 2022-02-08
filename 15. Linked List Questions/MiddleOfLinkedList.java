import java.util.*;

public class MiddleOfLinkedList {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		printLinkedList(head);

		// head = findMiddleNaive(head);
		// printLinkedList(head);

		head = findMiddleEfficient(head);
		printLinkedList(head);

		head = findMiddleEfficient(head);
		printLinkedList(head);

	}

	// Both of them take O(n) time but naive takes 2 traversals and efficient only one
	public static Node findMiddleEfficient(Node head) {
		// will select the right middle node in case of even nodes
		if (head == null) {
			return null;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public static Node findMiddleNaive(Node head) {
		if (head == null) {
			return null;
		}
		int size = 0;

		Node curr = head;
		while (curr != null) {
			size++;
			curr = curr.next;
		}

		curr = head;

		// will select the right middle node in case of even nodes
		for (int i = 0; i < size / 2; i++) {
			curr = curr.next;
		}

		return curr;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

		System.out.println();
	}
}