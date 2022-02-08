import java.util.*;

public class BalancedParanthesis {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();
    System.out.println(isBalanced(str));
  }

  public static boolean isBalanced(String str){
    Stack<Character> st = new Stack<>();

    // iterate through the string
    for(int i = 0;i < str.length();i++){
      char ch = str.charAt(i);

      if(isOpening(ch)){
        st.push(ch);
      } else{
        if(st.isEmpty()){
          /* 
            to handle cases like
            ")"
            "(()))"
            etc.
           */
          return false;
        } else if(isMatching(st.peek(),ch) == false){
          // if current character does not match the peek
          return false;
        } else{
          // matches
          st.pop();
        }
      }
    }

    return st.isEmpty();
  }

  public static boolean isOpening(char ch){
    return (ch == '(' || ch == '{' || ch == '[');
  }

  public static boolean isMatching(char a,char b){
    return (
      (a == '(' && b == ')') ||
      (a == '{' && b == '}') ||
      (a == '[' && b == ']')
    );
  }
}