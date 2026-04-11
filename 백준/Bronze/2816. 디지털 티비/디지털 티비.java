import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(br.readLine());
        }

        StringBuilder ans = new StringBuilder();

        // KBS1
        int idx1 = list.indexOf("KBS1");

        for (int i = 0; i < idx1; i++) ans.append("1");
        for (int i = 0; i < idx1; i++) ans.append("4");

        for (int i = idx1; i > 0; i--) {
            Collections.swap(list, i, i - 1);
        }

        // KBS2
        int idx2 = list.indexOf("KBS2");

        for (int i = 0; i < idx2; i++) ans.append("1");
        for (int i = 0; i < idx2 - 1; i++) ans.append("4");

        System.out.println(ans.toString());
    }
}