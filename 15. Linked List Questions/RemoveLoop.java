import java.util.*;

public class RemoveLoop {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = head.next.next; // 50 next = 30 node

		removeLoop(head);

		printLinkedList(head);
	}

	public static void removeLoop(Node head) {
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				break;
			}
		}

		if (slow != fast) {
			// does not have a loop
			return;
		}

		slow = head;
		while (slow.next != fast.next) {
			slow = slow.next;
			fast = fast.next;
		}

		// if want to return starting of loop in linked list return slow when slow != fast
		fast.next = null;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}