import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;

		int count = 0;
		boolean[][] area = new boolean[100][100];
		int x, y;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());

			for (int r = y; r < y + 10; r++) {
				for (int c = x; c < x + 10; c++) {
					if (area[r][c] == false) {
						area[r][c] = true;
						count++;
					}
				}
			}
		}

		System.out.println(count);

	}

}
