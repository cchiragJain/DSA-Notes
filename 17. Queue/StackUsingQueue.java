import java.util.*;

class StackUsingQueue {
    Queue<Integer> input = new ArrayDeque<>();
    Queue<Integer> output = new ArrayDeque<>();

    void push(int data){
        // shift to output
        while(input.isEmpty() == false){
            // output.push(input.pop());
            output.offer(input.poll());
        }
        
        // push to the first in position of queue (last in position in stack)
        input.push(data);

        // shift back to input
        while(output.isEmpty() == false){
            input.offer(output.poll());
        }
    }

    int pop(){
        // returns the first value of the queue technically or the last in position of the stack
        return input.poll();
    }
}