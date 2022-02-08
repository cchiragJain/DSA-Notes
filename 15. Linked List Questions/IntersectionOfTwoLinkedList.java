import java.util.*;

public class IntersectionOfTwoLinkedList {
	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(8);
		head.next.next.next = new Node(7);
		head.next.next.next.next = new Node(6);

		Node head2 = new Node(2);
		head2.next = new Node(8);
		head2.next.next = new Node(1);
		head2.next.next.next = new Node(3);
		// 2 -> 8 -> 1 -> 3 -> (from first list) 8 -> 7 -> 6
		head2.next.next.next.next = head.next.next;

		printLinkedList(head);
		printLinkedList(head2);

		Node result = intersectionOfLinkedListNaive(head, head2);
		printLinkedList(result);

		result = intersectionOfLinkedListUsingHashSet(head, head2);
		printLinkedList(result);

		result = intersectionBest(head, head2);
		printLinkedList(result);
	}

	public static Node intersectionBest(Node list1, Node list2) {
		int count1 = getCount(list1);
		int count2 = getCount(list2);

		int traversalsRequired = Math.abs(count1 - count2);

		Node curr1 = list1;
		Node curr2 = list2;

		if (count1 > count2) {
			for (int i = 1; i <= traversalsRequired; i++) {
				curr1 = curr1.next;
			}
		} else {
			for (int i = 1; i <= traversalsRequired; i++) {
				curr2 = curr2.next;
			}
		}

		while (curr1 != null && curr2 != null) {
			if (curr1 == curr2) {
				return curr1;
			}
			curr1 = curr1.next;
			curr2 = curr2.next;
		}

		return null;
	}

	private static int getCount(Node list) {
		int count = 0;
		while (list != null) {
			count++;
			list = list.next;
		}

		return count;
	}

	public static Node intersectionOfLinkedListUsingHashSet(Node list1, Node list2) {
		HashSet<Node> set = new HashSet<>();

		while (list1 != null) {
			set.add(list1);
			list1 = list1.next;
		}

		while (list2 != null) {
			if (set.contains(list2)) {
				return list2;
			}
			list2 = list2.next;
		}

		return null;
	}

	public static Node intersectionOfLinkedListNaive(Node list1, Node list2) {
		Node curr = list1;

		while (curr != null) {
			Node temp = list2;

			while (temp != null) {
				if (curr == temp) {
					return temp;
				}
				temp = temp.next;
			}

			curr = curr.next;
		}

		return null;
	}

	public static void printLinkedList(Node head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}
}