import java.util.*;

public class ReverseLinkedList {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);

		printLinkedList(head);

		head = reverseNaive(head);
		printLinkedList(head);

		head = reverseEfficient(head);
		printLinkedList(head);

		head = recursiveReverseLinkedList(head, null);
		printLinkedList(head);

	}

	public static Node recursiveReverseLinkedList(Node currentHead, Node prevHead) {
		if (currentHead == null) {
			return prevHead;
		}

		Node nextNode = currentHead.next;
		currentHead.next = prevHead;

		return recursiveReverseLinkedList(nextNode, currentHead);
	}

	public static Node reverseEfficient(Node head) {
		// T.C -> O(n)
		Node previousNode = null;
		Node currentNode = head;

		while (currentNode != null) {
			Node nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		// prev will be the new head of the reversed linked list
		// curr will be null after the loop
		return previousNode;
	}

	public static Node reverseNaive(Node head) {
		// T.C -> O(n)
		// S.C -> O(n)
		ArrayList<Integer> list = new ArrayList<>();

		Node curr = head;

		// add elements to arraylist
		while (curr != null) {
			list.add(curr.data);
			curr = curr.next;
		}

		// go back to head and then replace linked list data with end elements of the arraylist
		curr = head;

		while (curr != null) {
			int lastIndex = list.size() - 1;

			curr.data = list.get(lastIndex);
			// make sure to remove the last list entry as well
			list.remove(lastIndex);

			curr = curr.next;
		}

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