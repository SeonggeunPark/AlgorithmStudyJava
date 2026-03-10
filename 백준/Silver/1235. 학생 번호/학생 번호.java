import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];

        for (int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        int len = arr[0].length();

        for (int k = 1; k <= len; k++) {
            HashSet<String> set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                set.add(arr[i].substring(len - k));
            }

            if (set.size() == N) {
                System.out.println(k);
                return;
            }
        }
    }
}