package Week3;
import java.util.*;
public class EqualStacks {
    public static int equalStacks(List<Integer> h1, List<Integer> h2, List<Integer> h3){
        int sum1 = 0;
        int sum2 = 0;
        int sum3 = 0;
        for (int hight : h1){sum1 += hight;}
        for (int hight : h2){sum2 += hight;}
        for (int hight : h3){sum3 += hight;}
        int i1 = 0, i2 = 0, i3 = 0;
        while (true){
            if (i1 == h1.size() || i2 == h2.size() || i3 == h3.size()) {
                return 0;
            }
            if (sum1 == sum2 && sum2 == sum3) {
                return sum1;
            }
            if (sum1 >= sum2 && sum1 >= sum3) {
                sum1 -= h1.get(i1++);
            } else if (sum2 >= sum1 && sum2 >= sum3) {
                sum2 -= h2.get(i2++);
            } else {
                sum3 -= h3.get(i3++);
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNextInt()) return;

        int n1 = scanner.nextInt();
        int n2 = scanner.nextInt();
        int n3 = scanner.nextInt();

        List<Integer> h1 = new ArrayList<>();
        List<Integer> h2 = new ArrayList<>();
        List<Integer> h3 = new ArrayList<>();

        for (int i = 0; i < n1; i++) h1.add(scanner.nextInt());
        for (int i = 0; i < n2; i++) h2.add(scanner.nextInt());
        for (int i = 0; i < n3; i++) h3.add(scanner.nextInt());

        System.out.println(equalStacks(h1, h2, h3));
        scanner.close();
    }
}
