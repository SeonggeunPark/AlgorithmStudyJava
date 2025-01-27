import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int digit = N/10+1;
        
        int ans = 0;
        
        for (int i=N-(digit*9); i<=N; i++) {
        	if (digitSum(i)+i == N) {
        		ans = i;
        		break;
        	}
        }
        
        System.out.println(ans);
    }

	private static int digitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num%10;
			num /= 10;
		}
		return sum;
	}
}