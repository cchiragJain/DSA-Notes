import java.util.*;

public class SortAStack {
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(9);
        st.push(-3);
        st.push(1);
        st.push(10);
        st.push(3);

        System.out.println(st);
        sortStack(st);
        System.out.println(st);
    }

    public static void sortStack(Stack<Integer> st){
        if(st.isEmpty()){
            return;
        }

        // get the top element of the stack
        int x = st.pop();
        // call to sort the stack
        sortStack(st);
        // add the top element x in a sorted way to the stack
        sortedInsert(st,x);
    }

    public static void sortedInsert(Stack<Integer> st,int x){
        if(st.isEmpty() || st.peek() > x){
            st.push(x);
        } else {
            int data = st.pop();
            sortedInsert(st,x);
            st.push(data);
        }
    }
}