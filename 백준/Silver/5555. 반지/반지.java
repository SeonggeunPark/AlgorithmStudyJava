import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int ans = 0;


        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            String doubled = ring + ring; // 원형 처리

            if (doubled.contains(target)) {
                ans++;
            }
        }

        System.out.println(ans);
    }

}