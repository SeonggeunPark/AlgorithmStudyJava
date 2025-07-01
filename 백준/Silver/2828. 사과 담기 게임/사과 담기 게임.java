import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        int N = Integer.parseInt(line[0]); 
        int M = Integer.parseInt(line[1]);  

        int left = 1;        
        int right = M;        
        int move = 0;          

        int T = Integer.parseInt(br.readLine());  

        for (int i = 0; i < T; i++) {
            int apple = Integer.parseInt(br.readLine());

            if (apple < left) {
                int diff = left - apple;
                move += diff;
                left -= diff;
                right -= diff;
            } else if (apple > right) {
                int diff = apple - right;
                move += diff;
                left += diff;
                right += diff;
            }
        }

        System.out.println(move);
    }
}
