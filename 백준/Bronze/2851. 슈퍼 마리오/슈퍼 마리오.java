import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int sum = 0;
		int[] scores = new int[10];
		int score;
		for (int i = 0; i < 10; i++) {
			scores[i] = Integer.parseInt(br.readLine());
		}

		for (int i = 0; i < 10; i++) {
			score = scores[i];
			sum += score;
			if (sum > 100) {
				if (sum - 100 <= 100 - (sum-score)) {
					break;
				} else {
					sum = sum-score;
					break;
				}
			}				
		}		
		System.out.println(sum);
	}
}
