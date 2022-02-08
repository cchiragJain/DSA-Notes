import java.util.*;

public class TwoStacksInArray {
  public static void main(String[] args) {
    TwoStacks st = new TwoStacks(5);
    st.push1(1);
    st.push2(5);
    st.push2(4);
    st.push2(3);
    st.push2(2);
   
    st.print();

    st.push1(1300);
  }
}

class TwoStacks{
  /* 
    This is the space efficient implementation that does not statically divide the array
    For the naive implementation just do top1 = c/2 + 1 & top2 = c
   */
  int[] arr;
  int cap;
  int top1;
  int top2;

  TwoStacks(int c){
    cap = c;
    arr = new int[c];
    // start from bottom of stack
    top1 = -1;
    // start from top of the stack
    top2 = cap;
  }

  void push1(int x){
    if(top1 < top2 - 1){
      top1++;
      arr[top1] = x;
    } else{
      System.out.println("Overflow from left");
    }
  }

  void push2(int x){
    if(top1 < top2 - 1){
      top2--;
      arr[top2] = x;
    } else{
      System.out.println("Overflow from right");
    }
  }

  int pop1(){
    if(top1 >= 0){
      int res = arr[top1];
      top1--;
      return res;
    } else{
      // should throw an error
      return Integer.MIN_VALUE;
    }
  }

  int pop2(){
    if(top2 < cap){
      int res = arr[top2];
      top2++;
      return res;
    } else{
      // should throw an error
      return Integer.MIN_VALUE;
    }
  }

  void print(){
    for(int val:arr){
      System.out.print(val + " ");
    }
  }
}