public class Node<T> {
    T data;
    // Node type ka address store kar rahe h next mein
    Node<T> next;

    Node(T data) {
        this.data = data;

        // this.next = null;
        // Object reference is by default null so no need to do this
    }

}
