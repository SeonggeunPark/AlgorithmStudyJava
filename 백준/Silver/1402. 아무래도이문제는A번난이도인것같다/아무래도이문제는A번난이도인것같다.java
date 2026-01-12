import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());

        for (int i = 0; i < t; i++) {
            String line = br.readLine();
            while (line != null && line.trim().isEmpty()) { 
                line = br.readLine(); 
            }

            StringTokenizer st = new StringTokenizer(line);
            st.nextToken();
            st.nextToken();

            sb.append("yes\n");
        }

        System.out.print(sb.toString());
    }
}
