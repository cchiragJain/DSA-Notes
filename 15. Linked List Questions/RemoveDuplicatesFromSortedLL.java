import java.util.*;

public class RemoveDuplicatesFromSortedLL {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(20);
		head.next.next.next = new Node(30);
		head.next.next.next.next = new Node(30);
		head.next.next.next.next.next = new Node(30);
		head.next.next.next.next.next.next = new Node(40);

		printLinkedList(head);

		head = removeDuplicates(head);

		printLinkedList(head);

	}

	public static Node removeDuplicates(Node head) {
		Node curr = head;

		while (curr != null && curr.next != null) {
			if (curr.data != curr.next.data) {
				curr = curr.next;
			} else {
				deleteNode(curr);
			}
		}

		return head;
	}

	public static Node deleteNode(Node head) {
		head.next = head.next.next;

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