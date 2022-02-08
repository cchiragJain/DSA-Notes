import java.util.*;

public class InfixConversions {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    String str = sc.next();
    infixToPrefixPostfix(str);
  }

  public static void infixToPrefixPostfix(String str){
    Stack<String> prefix = new Stack<>();
    Stack<String> postfix = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for(int i = 0;i < str.length();i++){
      char ch = str.charAt(i);

      if(ch == '('){
        operators.push(ch);
      }
      // push if digit or character b/w a-z or b/w A-Z 
      else if((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')){
        // adding "" will convert ch to a string
        prefix.push(ch + "");
        postfix.push(ch + "");
      }
      else if(ch == ')'){
        while(operators.peek() != '('){
          char operator = operators.pop();

          String prev2 = prefix.pop();
          String prev1 = prefix.pop();

          String postv2 = postfix.pop();
          String postv1 = postfix.pop();

          String prefixValue = operator + prev1 + prev2;
          String postfixValue = postv1 + postv2 + operator;

          prefix.push(prefixValue);
          postfix.push(postfixValue);
        }
        // pop the ( bracket 
        operators.pop();
      } 
      else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
        while(
          operators.size() > 0 &&
          operators.peek() != '(' &&
          getPrecedence(ch) <= getPrecedence(operators.peek()))
        {
          char operator = operators.pop();

          String prev2 = prefix.pop();
          String prev1 = prefix.pop();

          String postv2 = postfix.pop();
          String postv1 = postfix.pop();

          String prefixValue = operator + prev1 + prev2;
          String postfixValue = postv1 + postv2 + operator;

          prefix.push(prefixValue);
          postfix.push(postfixValue);
        }
        
        // push the current operator as well
        operators.push(ch);
      }
    }
    
    // when stuff do end up remaining in the stack
    while(operators.isEmpty() == false){
      char operator = operators.pop();

      String prev2 = prefix.pop();
      String prev1 = prefix.pop();

      String postv2 = postfix.pop();
      String postv1 = postfix.pop();

      String prefixValue = operator + prev1 + prev2;
      String postfixValue = postv1 + postv2 + operator;

      prefix.push(prefixValue);
      postfix.push(postfixValue);
    }

    System.out.println("Prefix -> " + prefix.peek());
    System.out.println("Postfix -> " + postfix.peek());
  }

  public static int getPrecedence(char operator){
    if(operator == '+' || operator == '-'){
      return 1;
    } else if(operator == '*' || operator == '/'){
      return 2;
    }

    return -1;
  }
}