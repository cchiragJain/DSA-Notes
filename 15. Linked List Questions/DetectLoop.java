import java.util.*;

public class DetectLoop {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = head.next.next; // 50 next = 30 node

		System.out.println(detectLoopNaive(head));
		System.out.println(detectLoopUsingHashSet(head));
		System.out.println(detectLoopEfficient(head));
	}

	public static boolean detectLoopEfficient(Node head) {
		// FLOYD CYCLE DETECTION
		// T.C -> O(n)
		// S.C -> O(1)

		if (head == null || head.next == null) {
			return false;
		}

		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				return true;
			}
		}

		return false;
	}

	public static boolean detectLoopUsingHashSet(Node head) {
		// T.C -> O(n)
		// S.C -> O(n)
		HashSet<Node> set = new HashSet<>();

		Node curr = head;

		while (curr != null) {
			if (set.contains(curr)) {
				return true;
			}
			set.add(curr);
			curr = curr.next;
		}

		return false;
	}

	public static boolean detectLoopNaive(Node head) {
		// O(n^2)
		if (head == null) {
			return false;
		}
		if (head == head.next) {
			return true;
		}

		Node curr = head.next;

		while (curr != null) {
			Node temp = head;
			while (temp != curr) {
				if (temp == curr.next) {
					return true;
				}
				temp = temp.next;
			}
			curr = curr.next;
		}

		return false;
	}


}