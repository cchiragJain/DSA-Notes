import java.util.*;

public class QueueImplementations {
    public static void main(String[] args) {
        // QueueUsingLinkedList q = new QueueUsingLinkedList();
        // QueueUsingArray q = new QueueUsingArray(3);
        QueueUsingCircularArray q = new QueueUsingCircularArray(3);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(5);
        System.out.println(q.dequeue());
        q.enqueue(6);
        // System.out.println(q.getFront());
        // System.out.println(q.getRear());

        // System.out.println(q.getSize());
        System.out.println(q.dequeue());
        // System.out.println(q.getSize());
    }
}

class QueueUsingCircularArray {
    // T.C -> O(1) for all operations
    int[] arr;
    int n;
    int front;
    int rear;

    QueueUsingCircularArray(int n) {
        this.n = n;
        arr = new int[n];
        front = -1;
        rear = -1;
    }

    void enqueue(int data) {
        // check if already full
        // will be full if rear is behind front
        // even when front = 0 and rear is at end the rear will be behind front since circular array
        if (isFull()) {
            System.out.println("Queue Full");
            return;
        }

        if (front == -1) {
            front = 0;
        }

        rear = (rear + 1) % n;
        arr[rear] = data;
    }

    int dequeue() {
        // check if empty
        if (front == -1) {
            // throw a exception here
            return Integer.MIN_VALUE;
        }

        int result = arr[front];

        // check if last element of the queue and if yes update to start posn
        if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            front = (front + 1) % n;
        }

        return result;
    }

    boolean isFull() {
        return (((rear + 1) % n) == front);
    }
}

class QueueUsingArray {
    // T.C -> O(1) for enqueue & O(n) for dequeue

    int[] arr;
    int capacity;
    // dont' need a front since it will always be 0 in this case
    int rear;

    QueueUsingArray(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        // front will always remain 0 only the rear is going to change
        rear = -1;
    }

    void enqueue(int data) {
        // checking if already full
        if (rear == this.capacity - 1) {
            // ex. if capacity = 3 then rear must be at 2 for it to be full
            // should throw a exception
            System.out.println("Queue Full");
            return;
        }
        rear++;
        arr[rear] = data;
    }

    int dequeue() {
        // checking if queue empty
        if (rear == -1) {
            // throw a new exception
            return Integer.MIN_VALUE;
        }

        // store the result
        int result = arr[0];

        // push values 1 index back
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i + 1];
        }

        // update rear
        rear--;

        return result;
    }

    int getFront() {
        if (rear == -1) {
            // throw a new exception
            // queue is empty
            return Integer.MIN_VALUE;
        }

        // the first element will always be the front
        return arr[0];
    }

    int getRear() {
        if (rear == -1) {
            // throw a new exception
            // queue is empty
            return Integer.MIN_VALUE;
        }

        return arr[rear];
    }

    int getSize() {
        return rear + 1;
    }
}

class QueueUsingLinkedList {
    // T.C -> O(1) for all operations S.C -> O(n) for the linked list implementation
    Node front;
    Node rear;

    // for size just maintain a size variable

    void enqueue(int data) {
        Node newNode = new Node(data);

        if (front == null) {
            // means queue is empty
            front = newNode;
            rear = newNode;
            return;
        }

        // put new node at the end and then update the rear
        rear.next = newNode;
        rear = newNode;
    }

    int dequeue() {
        if (front == null) {
            // the queue could be empty
            // should throw a exception 
            return Integer.MIN_VALUE;
        }

        int data = front.data;
        front = front.next;

        return data;
    }

    int getFront() {
        return front.data;
    }

    int getRear() {
        return rear.data;
    }

    boolean isEmpty() {
        // if front is null then empty
        return front == null;
    }

    /* 
      ONLY FOR TESTING PURPOSES
    */
    void print() {
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        // next will be by default null
    }
}