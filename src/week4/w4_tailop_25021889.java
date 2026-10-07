package week4;
import java.util.Scanner;
import java.util.Arrays;
public class w4_tailop_25021889 {
    public int hIndex(int[] citations){
        Arrays.sort(citations);
        int n = citations.length;
        int i = 0, j = n -1;
        while (i<j){
            int temp = citations[i];
            citations[i] = citations[j];
            citations[j] = temp;
            i++;
            j--;
        }

        for (int k = 0; k < n; k++){
                if (citations[k] < k + 1 ){
                    return k;
            }
        }
        return n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(new w4_tailop_25021889().hIndex(arr));
        sc.close();
    }
}
