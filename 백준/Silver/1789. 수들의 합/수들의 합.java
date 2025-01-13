import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long S = Long.parseLong(br.readLine());
        
        long n = 0;
        for (long i = 0; i<=Long.MAX_VALUE; i++) {
        	if (i*(i+1)/2 > S) {
        		n = i-1;
        		break;
        	}
        }

        System.out.println(n);
    }
}