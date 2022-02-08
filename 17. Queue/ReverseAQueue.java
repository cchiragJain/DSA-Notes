import java.util.*;

public class ReverseAQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(1);
        q.offer(2);
        q.offer(3);
        q.offer(4);

        System.out.println(q);
        System.out.println(q.peek());

        reverseRecursive(q);
        System.out.println(q);
        System.out.println(q.peek());
    }
    
    /**iterative code would be to use a stack and do the same thing
    */
    public static void reverseRecursive(Queue<Integer> q){
        if(q.isEmpty()){
            return;
        }

        int x = q.poll();
        reverseRecursive(q);
        q.offer(x);
    }
}