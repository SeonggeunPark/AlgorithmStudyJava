import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        long A = scanner.nextLong();
        long B = scanner.nextLong();
        long C = scanner.nextLong();
        
        long result = modularExponentiation(A, B, C);
        System.out.println(result);
        
        scanner.close();
    }

    public static long modularExponentiation(long A, long B, long C) {
        if (B == 0) {
            return 1; // A^0 = 1
        }
        
        long half = modularExponentiation(A, B / 2, C);
        long result = (half * half) % C;
        
        if (B % 2 == 1) {
            result = (result * A) % C; // B가 홀수일 경우 A를 한번 더 곱해줌
        }
        
        return result;
    }
}
