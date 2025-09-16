import java.io.*;
import java.util.*;

public class Main {
    static long fact(long n, int p) {
        long cnt = 0;
        while (n > 0) {
            n /= p;
            cnt += n;
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        long v2 = fact(n, 2) - fact(k, 2) - fact(n - k, 2);
        long v5 = fact(n, 5) - fact(k, 5) - fact(n - k, 5);

        System.out.println(Math.min(v2, v5));
    }
}
