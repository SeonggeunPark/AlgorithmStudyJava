import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int cur = 0;
        int max = 0;

        for (int i = 0; i < 4 ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int get_off = Integer.parseInt(st.nextToken());
            int get_on = Integer.parseInt(st.nextToken());

            cur -= get_off;
            cur += get_on;

            if (max < cur) {
                max = cur;
            }
        }

        System.out.println(max);
    }
}
