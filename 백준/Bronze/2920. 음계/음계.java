import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String ans = "mixed";
		
		boolean isAsc = true;
		boolean isDes = true;
		for (int i=0; i<8; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (!isAsc&&!isDes) {
				System.out.println("mixed");
				return;
			}
			if (isAsc && num != i+1) {
				isAsc = false;
			}
			if (isDes && num != 8-i) {
				isDes = false;
			}
		}
		
		if (isAsc) System.out.println("ascending");
		else System.out.println("descending");
	}
}