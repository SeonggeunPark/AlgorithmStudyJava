import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        long n = sc.nextLong();
        
        int ans = (int) Math.sqrt(n);
        
        System.out.println(ans);
    }
}