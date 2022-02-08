import java.util.*;

public class InfixEvaluation {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = sc.next();

    System.out.println(evalInfix(str));
  }

  public static int evalInfix(String str){
    Stack<Integer> operands = new Stack<>();
    Stack<Character> operators = new Stack<>();

    for(int i = 0;i < str.length();i++){
      char ch = str.charAt(i);

      if(ch == '('){
        operators.push(ch);
      }
      // operand case 
      else if(Character.isDigit(ch)){
        // will convert it to number
        operands.push(ch - '0');
      }
      //  
      else if(ch == ')'){
        while(operators.peek() != '('){
          char operator = operators.pop();

          // hamesha v1 op v2 karna h
          int v2 = operands.pop();
          int v1 = operands.pop();

          int value = doOperation(v1,v2,operator);

          operands.push(value);
        }
        // for the ( bracket 
        operators.pop();
      } 
      else if(ch == '+' || ch == '-' || ch == '*' || ch == '/'){
        while(
          operators.size() > 0 &&
          operators.peek() != '(' &&
          getPrecedence(ch) <= getPrecedence(operators.peek()))
        {
          char operator = operators.pop();

          // hamesha v1 op v2 karna h
          int v2 = operands.pop();
          int v1 = operands.pop();

          int value = doOperation(v1,v2,operator);

          operands.push(value);
        }

        // push the current operator as well
        operators.push(ch);
      }
    }
    
    // when stuff do end up remaining in the stack
    while(operators.isEmpty() == false){
      char operator = operators.pop();

      // hamesha v1 op v2 karna h
      int v2 = operands.pop();
      int v1 = operands.pop();

      int value = doOperation(v1,v2,operator);

      operands.push(value);
    }

    return operands.peek();
  }

  public static int doOperation(int v1,int v2,char operator){
    if(operator == '+'){
      return v1 + v2;
    } else if(operator == '-'){
      return v1 - v2;
    }else if(operator == '*'){
      return v1 * v2;
    }else if(operator == '/'){
      return v1 / v2;
    }

    return -1;
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
