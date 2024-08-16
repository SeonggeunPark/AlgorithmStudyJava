import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *  int 자료형의 1000 * 1000 배열을 만든 후,
 *  for문을 활용해 각 종이에 번호를 부여하여 배열에 저장하면
 *  이후에 종이가 덮어씌어질 것이므로 번호별 면적을 구할 수 있을 것임.
 *  작업이 완료되면 다시 for문을 이용해 번호 개수를 카운트하는 배열을 만들어
 *  번호별 개수를 저장하고 출력한다. 
 */
public class Main{

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[1000][1000];
		// [종이번호(1번부터)][0: x좌표, 1: y좌표, 2: width, 3: height, 4: 종이면적]
		int[][] papers = new int[N+1][5];
		int x, y, width, height;
		
		for (int pNum = 1; pNum <= N; pNum++) {
			st = new StringTokenizer(br.readLine());
			papers[pNum][0] = Integer.parseInt(st.nextToken());
			papers[pNum][1] = Integer.parseInt(st.nextToken());
			papers[pNum][2] = Integer.parseInt(st.nextToken());
			papers[pNum][3] = Integer.parseInt(st.nextToken());
			x = papers[pNum][0];
			y = papers[pNum][1];
			width = papers[pNum][2];
			height = papers[pNum][3];

			for (int i = x; i < x + width; i++) {
				for (int j = y; j < y + height; j++) {
					map[i][j] = pNum;
				}
			}
//			for (int i = 0; i < 10; i++) {
//				for (int j = 0; j < 10; j++) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
		}
		// 저장해뒀던 종이들의 x,y 좌표들만 탐색하여 종이 면적을 구함.
		for (int pNum = 1; pNum<=N; pNum++) {
			for (int i=papers[pNum][0]; i<papers[pNum][0]+papers[pNum][2]; i++) {
				for (int j=papers[pNum][1]; j<papers[pNum][1]+papers[pNum][3]; j++) {
					// 해당 위치 종이번호가 찾으려는 종이 번호와 같으면 카운트
					if (map[i][j] == pNum) {
						papers[pNum][4]++;
					}
				}
			}
		}
		// 종이 면적 출력
		for (int pNum = 1; pNum<=N; pNum++) {
			System.out.println(papers[pNum][4]);
		}
		

	}

}
