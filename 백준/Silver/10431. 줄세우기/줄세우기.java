import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int P = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= P ; tc++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();     // tc 이미 있어서 필요없음

            int N = 20;
            int[] students = new int[N];
            int cnt = 0;

            for (int idx = 0; idx < N; idx++) {
                students[idx] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j<i; j++) {
                    if (students[j] > students[i]) {
                        cnt++;
                    }
                }
             }

            System.out.println(tc + " " + cnt);
        }

    }

}
