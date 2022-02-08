import java.util.*;

public class StackWithGetMin {
  public static void main(String[] args) {
    // StackUsingONSpace st = new StackUsingONSpace();
    BetterStack st = new BetterStack();

    st.push(10);
    st.push(20);
    System.out.println(st.getMin() + " ");
    st.push(5);
    System.out.println(st.getMin() + " ");
    st.pop();
    System.out.println(st.getMin() + " ");
    st.push(2);
    st.push(2);
    System.out.println(st.getMin() + " ");
    st.pop();
    System.out.println(st.getMin() + " ");
    // st.print();
  }
}

/* 
  T.C -> O(1) & S.C ->O(1)
*/

class BetterStack {
  private Node head;

  public void push(int x) {
    if (head == null) {
      head = new Node(x, x, null);
    } else {
      head = new Node(x, Math.min(x, head.min), head);
    }
  }

  public void pop() {
    head = head.next;
  }

  public int peek() {
    return head.val;
  }

  public int getMin() {
    return head.min;
  }

  private class Node {
    int val;
    int min;
    Node next;

    private Node(int val, int min, Node next) {
      this.val = val;
      this.min = min;
      this.next = next;
    }
  }
}

/* T.C -> O(1) & S.C -> O(N) */

class StackUsingONSpace {
  Stack<Integer> mainStack;
  Stack<Integer> auxStack;

  StackUsingONSpace() {
    mainStack = new Stack<>();
    auxStack = new Stack<>();
  }

  void push(int x) {
    if (mainStack.isEmpty()) {
      mainStack.push(x);
      auxStack.push(x);
    } else {
      mainStack.push(x);

      if (x <= auxStack.peek()) {
        auxStack.push(x);
      }
    }
  }

  int pop() {
    if (auxStack.peek() == mainStack.peek()) {
      auxStack.pop();
    }
    return mainStack.pop();
  }

  int peek() {
    return mainStack.peek();
  }

  int getMin() {
    return auxStack.peek();
  }

  // just for testing purposes
  void print() {
    System.out.println("Main ->" + mainStack);
    System.out.println("Aux ->" + auxStack);
  }
}