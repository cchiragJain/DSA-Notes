import java.util.*;

public class FindNnodeFromEnd {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		printLinkedList(head);

		findNNodeFromEnd(head, 2);
		findNNodeFromEndEfficient(head, 3);
		findNNodeFromEndEfficient(head, 10);

		head = deleteNNodeFromEnd(head, 3);
		printLinkedList(head);
	}

	public static Node deleteNNodeFromEnd(Node head, int n) {
		Node fast = head;
		Node slow = head;

		while (n-- > 0) {
			fast = fast.next;
		}

		if (fast == null) {
			// will happen if we have n == size
			return head.next;
		}

		while (fast.next != null) {
			slow = slow.next;
			fast = fast.next;
		}

		slow.next = slow.next.next;

		return head;
	}

	public static void findNNodeFromEndEfficient(Node head, int n) {
		Node first = head;
		Node second = head;

		while (n-- > 0 && first != null) {
			first = first.next;
		}

		if (first == null) {
			return;
		}

		while (first != null) {
			second = second.next;
			first = first.next;
		}

		System.out.println(second.data);
	}

	public static void findNNodeFromEnd(Node head, int n) {
		Node curr = head;
		int size = 0;

		while (curr != null) {
			size++;
			curr = curr.next;
		}

		if (n > size) {
			return;
		}

		curr = head;

		for (int i = 0; i < size - n; i++) {
			curr = curr.next;
		}

		System.out.println(curr.data);
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}