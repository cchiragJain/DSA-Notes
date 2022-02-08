import java.util.*;

public class MergeTwoSortedLL {
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(29);
		head.next.next = new Node(32);

		Node head2 = new Node(15);
		head2.next = new Node(25);
		head2.next.next = new Node(28);
		head2.next.next.next = new Node(31);
		head2.next.next.next.next = new Node(70);

		printLinkedList(head);
		printLinkedList(head2);

		// Node merged = mergeSortedLLNaive(head, head2);

		// printLinkedList(merged);

		// Node merged = mergeSortedEfficientUsingRecursion(head, head2);
		// printLinkedList(merged);

		Node merged = mergeSortedEfficient(head, head2);
		printLinkedList(merged);
	}

	public static Node mergeSortedEfficient(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		Node head = null;
		Node tail = null;

		if (list1.data < list2.data) {
			tail = list1;
			head = list1;
			list1 = list1.next;
		} else {
			tail = list2;
			head = list2;
			list2 = list2.next;
		}

		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				tail.next = list1;
				tail = tail.next;
				list1 = list1.next;
			} else {
				tail.next = list2;
				tail = tail.next;
				list2 = list2.next;
			}
		}

		if (list1 != null) {
			tail.next = list1;
		}
		if (list2 != null) {
			tail.next = list2;
		}

		return head;
	}

	public static Node mergeSortedEfficientUsingRecursion(Node list1, Node list2) {
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		if (list1.data < list2.data) {
			list1.next = mergeSortedEfficientUsingRecursion(list1.next, list2);
			return list1;
		} else {
			list2.next = mergeSortedEfficientUsingRecursion(list1, list2.next);
			return list2;
		}
	}

	public static Node mergeSortedLLNaive(Node list1, Node list2) {
		Node head = new Node(-1);
		Node curr = head;

		while (list1 != null && list2 != null) {
			if (list1.data < list2.data) {
				curr.next = list1;
				curr = curr.next;
				list1 = list1.next;
			} else {
				curr.next = list2;
				curr = curr.next;
				list2 = list2.next;
			}
		}

		if (list1 != null) {
			// just point current to the un used list
			// no need to run a loop like in the case of arrays
			curr.next = list1;
		}

		if (list2 != null) {
			curr.next = list2;
		}

		return head.next;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}