import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int E = Integer.parseInt(st.nextToken()); // 1 ~ 15
        int S = Integer.parseInt(st.nextToken()); // 1 ~ 28
        int M = Integer.parseInt(st.nextToken()); // 1 ~ 19

        int year = 1;
        int e = 1, s = 1, m = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                System.out.println(year);
                break;
            }

            year++;
            e = e % 15 + 1;
            s = s % 28 + 1;
            m = m % 19 + 1;
        }
    }
}
