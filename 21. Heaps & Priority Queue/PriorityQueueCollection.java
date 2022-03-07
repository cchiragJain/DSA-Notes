import java.util.*;

public class PriorityQueueCollection {
    public static void main(String[] args) {
        // BY DEFAULT IMPLEMENTS A MINHEAP DATA STRUCTURE
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(50);
        pq.add(20);
        pq.add(12);

        /* 
            Pictorially
                12
              /    \
            50      20
         */

        System.out.println(pq);
        System.out.println(pq.peek());
        System.out.println(pq.poll());
        System.out.println(pq.peek());

        // IMPLEMENTING MAXHEAP
        PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

        pq2.add(20);
        pq2.add(50);
        pq2.add(12);
        pq2.add(40);

        System.out.println(pq2);
        System.out.println(pq2.peek());
        System.out.println(pq2.poll());
        System.out.println(pq2.peek());
    }
}