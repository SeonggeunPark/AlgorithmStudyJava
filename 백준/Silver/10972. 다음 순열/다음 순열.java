import java.io.*;
import java.util.*;

public class Main {
    static boolean nextPermutation(int[] a) {
        int n = a.length;

        int i = n - 1;
        while (i > 0 && a[i - 1] >= a[i]) i--;
        if (i == 0) return false; 

        int j = n - 1;
        while (a[j] <= a[i - 1]) j--;

        int t = a[i - 1]; a[i - 1] = a[j]; a[j] = t;

        for (int l = i, r = n - 1; l < r; l++, r--) {
            t = a[l]; a[l] = a[r]; a[r] = t;
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[] a = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int k = 0; k < N; k++) a[k] = Integer.parseInt(st.nextToken());

        if (nextPermutation(a)) {
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < N; k++) {
                if (k > 0) sb.append(' ');
                sb.append(a[k]);
            }
            System.out.println(sb.toString());
        } else {
            System.out.println(-1);
        }
    }
}
