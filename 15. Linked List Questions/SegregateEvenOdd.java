import java.util.*;

public class SegregateEvenOdd {
	public static void main(String[] args) {
		Node head = new Node(17);
		head.next = new Node(12);
		head.next.next = new Node(8);
		head.next.next.next = new Node(15);
		head.next.next.next.next = new Node(9);

		printLinkedList(head);

		head = segregate(head);

		printLinkedList(head);
	}

	public static Node segregate(Node head) {
		Node evenStart = null;
		Node evenEnd = null;
		Node oddStart = null;
		Node oddEnd = null;

		Node curr = head;

		while (curr != null) {
			int x = curr.data;

			if (x % 2 == 0) {
				if (evenStart == null) {
					// if list not created create a new one
					evenStart = curr;
					evenEnd = evenStart;
				} else {
					// if list created add to the last and update end
					evenEnd.next = curr;
					evenEnd = evenEnd.next;
				}
			} else {
				if (oddStart == null) {
					oddStart = curr;
					oddEnd = oddStart;
				} else {
					oddEnd.next = curr;
					oddEnd = oddEnd.next;
				}
			}

			curr = curr.next;
		}

		if (evenStart == null || oddStart == null) {
			return head;
		}

		// connect even and odd list
		evenEnd.next = oddStart;
		oddEnd.next = null;

		return evenStart;
	}

	public static Node segregateNaive(Node head) {
		Node originalEnd = head;

		while (originalEnd.next != null) {
			originalEnd = originalEnd.next;
		}

		Node curr = head;

		while (curr != originalEnd) {
			int x = curr.data;
			Node currNext = curr.next;

			if (x % 2 != 0) {
				head = insertAtEnd(head, x);
				deleteCurrentNode(head);
			}

			curr = currNext;
		}

		if (originalEnd.data % 2 != 0) {
			head = insertAtEnd(head, originalEnd.data);
			deleteCurrentNode(head);
		}

		return head;
	}

	public static Node insertAtEnd(Node head, int x) {
		Node newNode = new Node(x);
		if (head == null) {
			return newNode;
		}

		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}

		curr.next = newNode;

		return head;
	}

	public static void deleteCurrentNode(Node curr) {
		curr.data = curr.next.data;
		curr.next = curr.next.next;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}