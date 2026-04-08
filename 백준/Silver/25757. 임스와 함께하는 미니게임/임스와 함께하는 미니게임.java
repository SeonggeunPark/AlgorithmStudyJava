import java.io.*;
import java.util.*;



public class Main {

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<String> set = new HashSet<>();
        int ans = 0;


        int N = Integer.parseInt(st.nextToken());
        String game = st.nextToken();

        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int L = set.size();

        switch (game) {
            case "Y" :
                ans = L;
                break;
            case "F" :
                ans = L/2;
                break;
            case "O" :
                ans = L/3;
                break;
        }

        System.out.println(ans);
        
    }

}
