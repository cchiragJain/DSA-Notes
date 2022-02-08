import java.util.*;

public class LinkedListInput {
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		printLinkedList(head);
	}

	public static Node<Integer> takeInput() {
		Scanner sc = new Scanner(System.in);

		int data = sc.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;

		while (data != -1) {
			// Theta(n)
			Node<Integer> currentNode = new Node<>(data);
			if (head == null) {
				// make this node as the head node as well as the tail node for only one element
				// will only be checked once
				head = currentNode;
				tail = currentNode;
			} else {
				// jo pichla tha uske andr next bhardo
				// and tail ko agle vaale/current vaale node pe kardo (tail toh last pe hi honi chaiye )
				tail.next = currentNode;
				tail = currentNode;

				// THIS INCREASES TIME COMPLEXITY TO O(N^2)
				// Node<Integer> tail = head;
				// while (tail.next != null) {
				// 	tail = tail.next;
				// }
				// // now tail will point to the last node which will have .next as null
				// // create connection
				// tail.next = currentNode;
			}

			data = sc.nextInt();
		}

		return head;
	}

	public static void printLinkedList(Node<Integer> head) {
		// can use head here but still a better practice to declare a temp Node and use it
		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
}