import java.util.*;

public class LinkedListDemo {
	public static void main(String[] args) {
		// Node<Integer> n1 = new Node<>(10);

		Node<Integer> head = createLinkedList();
		System.out.println(head);

		printLinkedList(head);
		printLinkedListRecursive(head);

		int length = lengthOfLinkedList(head);
		System.out.println(length);

		printIthData(head, 10);

	}

	public static Node<Integer> createLinkedList() {
		Node<Integer> n1 = new Node<>(10);
		Node<Integer> n2 = new Node<>(20);
		Node<Integer> n3 = new Node<>(30);
		Node<Integer> n4 = new Node<>(40);

		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		// n4.next toh phele se hi null hogi voh

		// first node se saare connection bante h
		return n1;

	}

	public static void printLinkedList(Node<Integer> head) {
		// BETTER TO DO THIS SINCE CAN USE THE LINKED LIST AGAIN AS WELL
		Node<Integer> temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
		System.out.println();

		// while (head != null) {
		// 	System.out.println(head.data);
		// 	head = head.next;
		// }

	}

	public static void printLinkedListRecursive(Node<Integer> head) {
		if (head == null) {
			return;
		}

		System.out.println(head.data);
		printLinkedListRecursive(head.next);
	}

	public static int lengthOfLinkedList(Node<Integer> head) {
		Node<Integer> temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp = temp.next;
		}

		return count;
	}

	public static void printIthData(Node<Integer> head, int i) {
		// need to check for head as well since i can be larger than length in which it
		// will throw exception
		while (i > 0 && head != null) {
			head = head.next;
			i--;
		}
		if (head != null) {
			System.out.println(head.data);
		}
	}
}
