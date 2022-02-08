import java.util.*;

class QueueUsingStack{
    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    void push(int data){
        input.push(data);
    }

    int pop(){
        if(output.isEmpty() == false){
            return output.pop();
        } else {
            // shift values from input to output
            while(input.isEmpty() == false){
                output.push(input.pop());
            }
            return output.pop();
        }
    }

    int peek(){
        if(output.isEmpty() == false){
            return output.peek();
        } else {
            // shift values from input to output
            while(input.isEmpty() == false){
                output.push(input.pop());
            }
            return output.peek();
        }
    }
}