import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long gcd = gcd(A, B);
        long lcm = (A / gcd) * B;  // 오버플로우 방지: A * (B / gcd) 도 가능

        System.out.println(lcm);
    }
}
