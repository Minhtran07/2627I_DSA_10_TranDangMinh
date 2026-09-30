package Week3;
import edu.princeton.cs.algs4.Stack;
import java.util.Scanner;
class OperatorPrecedence{
    public static int getPrecedence(char op){
        switch(op){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            default:
                return -1;
        }
    }
}
class InfixToPostfixConverter{
    public static String convert(String expression){
        StringBuilder postfix = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (Character.isLetterOrDigit(c)){
                postfix.append(c).append(" "); 
            }
            else if (c == '('){
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop()).append(" ");
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop();
                }
            }
            else if (OperatorPrecedence.getPrecedence(c) != -1){
                while(!stack.isEmpty() && OperatorPrecedence.getPrecedence(c) <= OperatorPrecedence.getPrecedence(stack.peek())){
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }
}
public class w3_tailop_25021889 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập biểu thức trung tố: ");
        String expression = input.nextLine();

        String result = InfixToPostfixConverter.convert(expression);

        System.out.println("Kết quả: " + result);

        input.close();
    }
}
