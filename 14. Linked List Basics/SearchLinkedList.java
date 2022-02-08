import java.util.*;

public class SearchLinkedList {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node<Integer> head = null;

		head = insertBegin(head, 10);
		head = insertBegin(head, 20);
		head = insertBegin(head, 30);
		printLinkedList(head);

		System.out.println(searchInLinkedList(head, 20));
		System.out.println(searchRecursive(head, 10, 1));
		System.out.println(searchRecursive(head, 70, 1));

	}

	public static int searchInLinkedList(Node<Integer> head, int data) {
		int currentPosition = 1;

		while (head != null) {
			if (head.data == data) {
				return currentPosition;
			}

			currentPosition++;
			head = head.next;
		}

		// if not found
		return -1;
	}

	public static int searchRecursive(Node<Integer> head, int data, int position) {
		if (head == null) {
			// if at the end of the list already and not found then return -1
			return -1;
		} else if (head.data == data) {
			return position;
		}

		return searchRecursive(head.next, data, position + 1);
	}

	public static Node<Integer> insertBegin(Node<Integer> head, int x) {
		Node<Integer> newNode = new Node<>(x);
		newNode.next = head;
		return newNode;
	}

	public static void printLinkedList(Node<Integer> head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}