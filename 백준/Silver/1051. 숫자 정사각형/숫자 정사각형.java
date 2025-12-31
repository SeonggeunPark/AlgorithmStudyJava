import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] a = new char[n][m];
        for (int i = 0; i < n; i++) {
            a[i] = br.readLine().toCharArray();
        }

        int ans = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; i + k < n && j + k < m; k++) {
                    char c = a[i][j];
                    if (a[i + k][j] == c &&
                        a[i][j + k] == c &&
                        a[i + k][j + k] == c) {
                        ans = Math.max(ans, (k + 1) * (k + 1));
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
