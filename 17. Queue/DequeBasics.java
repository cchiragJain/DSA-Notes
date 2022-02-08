import java.util.*;

public class DequeBasics {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();

        dq.offerFirst(10);
        dq.offerFirst(20);
        System.out.println(dq);

        dq.offerLast(30);
        System.out.println(dq);

        System.out.println(dq.peekFirst());
        System.out.println(dq.peekLast());

        System.out.println(dq.pollFirst());
        System.out.println(dq.pollLast());

        System.out.println(dq);

        dq.offerLast(20);
        dq.offerLast(30);
        dq.offerLast(40);
        
        // TRAVERSAL
        for(int x:dq){
            System.out.print(x + " ");
        }

        System.out.println();
        
        // Better to use the iterator class for traversing collections
        Iterator i = dq.iterator();
        while(i.hasNext()){
            System.out.print(i.next() + " ");
        }
        
        System.out.println();
        // REVERSE TRAVERSAL
        Iterator it = dq.descendingIterator();
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}