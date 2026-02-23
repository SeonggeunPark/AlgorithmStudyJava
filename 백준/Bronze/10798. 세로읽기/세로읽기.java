import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[5];
        int m = 0;

        for (int i = 0; i < 5; i++) {
            s[i] = br.readLine();
            m = Math.max(m, s[i].length());
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < m; j++) {
            for (int i = 0; i < 5; i++) {
                if (j < s[i].length()) sb.append(s[i].charAt(j));
            }
        }

        System.out.print(sb.toString());
    }
}