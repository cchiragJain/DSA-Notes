import java.util.*;

public class StackBasics {
	public static void main(String[] args) {
		// StackUsingArray stack = new StackUsingArray(5);
		// StackUsingArrayList stack = new StackUsingArrayList();
		StackUsingLinkdedList stack = new StackUsingLinkdedList();
		stack.push(5);
		stack.push(2);
		stack.push(3);
		stack.push(20);
		stack.push(1);

		System.out.println(stack.size());

		// for linked list print to work need to add a recursive print function
		// stack.print();

		System.out.println(stack.pop());

		// stack.print();

		System.out.println(stack.peek());
		System.out.println(stack.size());
		System.out.println(stack.isEmpty());
	}
}

class StackUsingLinkdedList {
	// Uses simple Node class implementation of linked list
	// Considering head as the last element inserted to the stack
	Node head;
	int size;

	StackUsingLinkdedList() {
		// initially null hoga
		head = null;
		size = 0;
	}

	void push(int x) {
		Node newNode = new Node(x);
		newNode.next = head;
		head = newNode;
		size++;
	}

	int pop() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}

		int res = head.data;
		head = head.next;
		size--;
		return res;
	}

	int peek() {
		if (head == null) {
			return Integer.MAX_VALUE;
		}

		return head.data;
	}

	int size() {
		return size;
	}

	boolean isEmpty() {
		return size == 0;
	}
}

class StackUsingArrayList {
	// BETTER TO ADD EXCEPTIONS HERE
	ArrayList<Integer> storage = new ArrayList<>();

	void push(int x) {
		storage.add(x);
	}

	int pop() {
		int res = storage.get(storage.size() - 1);
		storage.remove(storage.size() - 1);
		return res;
	}

	int size() {
		return storage.size();
	}

	int peek() {
		return storage.get(storage.size() - 1);
	}

	boolean isEmpty() {
		return storage.isEmpty();
	}

	void print() {
		System.out.println(storage);
	}
}

class StackUsingArray {
	// DOES NOT HAVE DYNAMIC RESIZING
	int[] storage;
	int capacity;
	int topIndex;

	StackUsingArray(int c) {
		capacity = c;
		// initially -1 hoga jab koi bhi element inserted nahi h
		topIndex = -1;
		// declare new array
		storage = new int[capacity];
	}

	void push(int x) {
		// if stack is full
		if (topIndex == capacity - 1) {
			// throw a exception rather than printing
			System.out.println("Stack full");
			return;
		}

		storage[++topIndex] = x;
	}

	int pop() {
		if (topIndex == -1) {
			// can't pop on empty stack
			// throw a exception
			System.out.println("Empty stack");
			return Integer.MIN_VALUE;
		}
		// does not actually delete it
		int res = storage[topIndex];
		topIndex--;
		return res;
	}

	int size() {
		// topIndex starts with -1
		// if -1 then the size is 0
		return topIndex + 1;
	}

	int peek() {
		if (topIndex == -1) {
			// can't pop on empty stack
			// throw a exception
			System.out.println("Empty stack");
			return Integer.MIN_VALUE;
		}
		return storage[topIndex];
	}

	boolean isEmpty() {
		// if empty then topIndex must be -1
		return topIndex == -1;
	}

	void print() {
		for (int i = 0; i < topIndex + 1; i++) {
			System.out.print(storage[i] + " ");
		}
		System.out.println();
	}
}

class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
	}
}