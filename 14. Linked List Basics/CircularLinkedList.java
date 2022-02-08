import java.util.*;

public class CircularLinkedList {
	public static void main(String[] args) {
		Node head = new Node(5);
		Node n2 = new Node(10);
		Node n3 = new Node(15);
		Node n4 = new Node(20);

		head.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = head;

		printCircularLinkedList(head);
		printCircularLinkedList(null);
		head = new Node(100);
		head.next = head;
		printCircularLinkedList(head);
	}

	public static void printCircularLinkedList(Node head) {
		if (head == null || head.next == null) {
			// we are only checking for head.next if a wrong node is sent
			return;
		}

		Node temp = head;

		System.out.print(temp.data + " ");
		temp = temp.next;

		while (temp != head) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}