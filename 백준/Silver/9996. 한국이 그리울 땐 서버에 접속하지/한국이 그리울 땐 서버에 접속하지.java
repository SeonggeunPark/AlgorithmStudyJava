import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;
    static String pattern, pre, suf;

    public static void main(String[] args) throws Exception {
        init();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            if (matches(s)) sb.append("DA\n");
            else            sb.append("NE\n");
        }

        System.out.print(sb);
    }

    private static boolean matches(String s) {
        if (s.length() < pre.length() + suf.length()) return false;
        if (!s.startsWith(pre)) return false;
        if (!s.endsWith(suf))  return false;
        return true; 
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        pattern = br.readLine();

        String[] parts = pattern.split("\\*", -1);
        pre = parts[0];
        suf = parts[1];
    }
}
