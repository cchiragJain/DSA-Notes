import java.util.*;

public class PairwiseSwap {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		// head.next.next.next.next.next = new Node(60);

		printLinkedList(head);

		head = pairWiseSwapData(head);

		printLinkedList(head);

		head = pairWiseSwapOnlyNodesRecursion(head);

		printLinkedList(head);

		head = pairWiseSwapNodes(head);

		printLinkedList(head);
	}

	public static Node pairWiseSwapNodes(Node head) {
		Node curr = head;
		Node newHead = head.next;

		while (true) {
			Node nextNode = curr.next;
			Node temp = nextNode.next;

			nextNode.next = curr;

			if (temp == null || temp.next == null) {
				curr.next = temp;
				break;
			}

			curr.next = temp.next;

			curr = temp;

		}

		return newHead;
	}

	public static Node pairWiseSwapOnlyNodesRecursion(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node remainingList = node.next.next;
		Node newHead = node.next;

		newHead.next = node;

		node.next = pairWiseSwapOnlyNodesRecursion(remainingList);

		return newHead;
	}

	public static Node pairWiseSwapData(Node head) {
		// this will take a lot of time if data is not integer and is a object with a lot of fields
		Node curr = head;

		while (curr != null && curr.next != null) {
			int temp = curr.data;
			curr.data = curr.next.data;
			curr.next.data = temp;

			curr = curr.next.next;
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