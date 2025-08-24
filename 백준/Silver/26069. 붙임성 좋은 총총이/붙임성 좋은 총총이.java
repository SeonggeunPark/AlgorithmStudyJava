import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void main(String[] args) throws Exception {
        init();
    }

    private static void init() throws Exception {
        N = Integer.parseInt(br.readLine());
        Set<String> dancing = new HashSet<>();
        dancing.add("ChongChong");

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            if (dancing.contains(a) || dancing.contains(b)) {
                dancing.add(a);
                dancing.add(b);
            }
        }

        System.out.println(dancing.size());
    }
}
