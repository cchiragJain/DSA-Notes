import java.util.*;

public class ReverseDoublyLinkedList {
	public static void main(String[] args) {
		Node head = null;

		head = insertBegin(head, 10);
		head = insertBegin(head, 20);
		head = insertBegin(head, 30);
		printLinkedList(head);

		head = reverseDoublyLinkedList(head);
		printLinkedList(head);
	}

	public static Node reverseDoublyLinkedList(Node head) {
		if (head == null || head.next == null) {
			return head;
		}

		Node temp = null;
		Node curr = head;

		while (curr != null) {
			temp = curr.prev;
			curr.prev = curr.next;
			curr.next = temp;

			// since prev and next have been swapped and prev will still have it's next stored
			curr = curr.prev;
		}

		return temp.prev;
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