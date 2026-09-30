package Week3;
import java.util.*;
public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        if (!scanner.hasNextLine()) return;
        int n = scanner.nextInt();
        StringBuilder text = new StringBuilder();
        Stack<String> history =  new Stack<>();
        for (int i = 0; i < n; i++){
            int type = scanner.nextInt();
            switch (type) {
                case 1: // append
                    String s = scanner.next();
                    history.push(text.toString());
                    text.append(s);
                    break;
                case 2: // delete
                    int k = scanner.nextInt();
                    history.push(text.toString());
                    text.delete(text.length() - k, text.length());
                    break;
                case 3: // pritn
                    int printIndex = scanner.nextInt();
                    System.out.println(text.charAt(printIndex - 1));
                    break;
                case 4:
                    if (!history.isEmpty()) {
                        text = new StringBuilder(history.pop());
                    }
                    break;
            }
        }
        scanner.close();
    }
}

