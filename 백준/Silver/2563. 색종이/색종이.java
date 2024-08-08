import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		int[][] area = new int[100][100];
//		int[][] papers = new int[N][2];
		int x, y;
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
//			papers[i][0] = Integer.parseInt(st.nextToken());
//			papers[i][1] = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			
			for (int r=y; r<y+10; r++) {
				for (int c=x; c<x+10; c++) {
//					if (area[r][c] == 0)
					area[r][c] = 1;
				}
			}
		}
		int sum = 0;
		for (int r=0; r<area.length; r++) {
			for (int c=0; c<area[r].length; c++) {
				if (area[r][c] == 1)
				sum++;
			}
		}
		
		System.out.println(sum);
		
	}

}
