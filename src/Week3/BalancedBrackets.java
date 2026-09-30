package Week3;
import java.util.*;
public class BalancedBrackets {
    public static String isBalanced(String s){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '{' || c == '[' || c == '('){
                stack.push(c);
            }
            else{
                if (stack.isEmpty()){
                    return "NO";
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return "NO";
                }
            }
        }return stack.isEmpty() ? "YES" : "NO";
    }public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;
        int t = scanner.nextInt();

        while (t-- > 0) {
            String s = scanner.next();
            System.out.println(isBalanced(s));
        }
        scanner.close();
    }
}
