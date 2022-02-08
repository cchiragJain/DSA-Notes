import java.util.*;

public class ReverseLinkedListKGroups {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		printLinkedList(head);

		head = reverseInGroupsOfKRecursive(head, 3);

		printLinkedList(head);
	}

	public static Node reverseInGroupsOfKRecursive(Node head, int k) {
		Node currentNode = head;
		Node previousNode = null;
		Node nextNode = null;

		int count = 0;

		// reverse k nodes
		while (currentNode != null && count < k) {
			nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
			count++;
		}

		// if list still remains then reverse the next k nodes
		if (nextNode != null) {
			// head will be the last element in the reversed linked list
			head.next = reverseInGroupsOfKRecursive(nextNode, k);
		}

		return previousNode;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}