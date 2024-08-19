import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i=1; i<=N; i++) {
			int num=i;
			boolean isContain369 = false;
			while (num>0) {
				if (num%10==3 || num%10==6 || num%10==9) {
					sb.append("-");
					isContain369=true;
				}
				num /= 10;
			}
			
			if (!isContain369) sb.append(i).append(" ");
			else sb.append(" ");
		}
		
		System.out.println(sb);
	}
}
