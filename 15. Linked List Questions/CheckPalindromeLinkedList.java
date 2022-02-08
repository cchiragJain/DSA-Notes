import java.util.*;

public class CheckPalindromeLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(2);
		head.next.next.next.next = new Node(1);

		printLinkedList(head);

		System.out.println(isPalindromeNaive(head));

		System.out.println(isPalindrome(head));
	}

	public static boolean isPalindrome(Node head) {
		Node slow = head;
		Node fast = head;

		// find mid
		while (fast.next != null && fast.next.next != null) {
			// in the case of even nodes finds the left middle node
			// odd will be the same
			slow = slow.next;
			fast = fast.next.next;
		}

		slow.next = reverseLinkedList(slow.next);

		Node curr = head;
		Node curr2 = slow.next;

		while (curr2 != null) {
			if (curr.data != curr2.data) {
				return false;
			}
			curr = curr.next;
			curr2 = curr2.next;
		}

		return true;

	}

	private static Node reverseLinkedList(Node head) {
		Node previousNode = null;
		Node currentNode = head;

		while (currentNode != null) {
			Node nextNode = currentNode.next;
			currentNode.next = previousNode;
			previousNode = currentNode;
			currentNode = nextNode;
		}

		return previousNode;
	}

	public static boolean isPalindromeNaive(Node head) {
		Stack<Integer> stack = new Stack<>();

		Node curr = head;

		while (curr != null) {
			stack.push(curr.data);
			curr = curr.next;
		}

		curr = head;

		while (curr != null) {
			if (stack.peek() != curr.data) {
				return false;
			}
			stack.pop();
			curr = curr.next;
		}

		return true;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}