import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력: 두 개의 큰 수 (n, m)
        BigInteger n = scanner.nextBigInteger();
        BigInteger m = scanner.nextBigInteger();

        // 각 사람이 받는 돈 (n / m)
        System.out.println(n.divide(m));

        // 남는 돈 (n % m)
        System.out.println(n.remainder(m));

        scanner.close();
    }
}
