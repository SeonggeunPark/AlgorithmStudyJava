import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] left = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];

        for (int height = 1; height <= n; height++) {
            int cnt = left[height - 1];
            for (int i = 0; i < n; i++) {
                if (result[i] == 0) {
                    if (cnt == 0) {
                        result[i] = height;
                        break;
                    }
                    cnt--;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int x : result) {
            sb.append(x).append(' ');
        }
        System.out.println(sb.toString().trim());
    }
}
