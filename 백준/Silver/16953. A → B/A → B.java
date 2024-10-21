import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        sc.close();
        
        int count = 0;
        
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                break;
            }
            count++;
        }
        
        if (A == B) {
            System.out.println(count + 1);
        } else {
            System.out.println(-1);
        }
    }
}
