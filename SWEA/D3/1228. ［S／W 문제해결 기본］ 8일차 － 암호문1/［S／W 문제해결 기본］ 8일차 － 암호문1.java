import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 테스트케이스 10개 시작
		for (int t=1; t<=10; t++) {
			int N = Integer.parseInt(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			
			// 연결리스트 생성 후 자료 입력
			st = new StringTokenizer(br.readLine());
			for (int n=0; n<N; n++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 명령어 개수 입력
			int commands = Integer.parseInt(br.readLine());
			// 명령어 순차적 처리
			st = new StringTokenizer(br.readLine());
			for (int c=0 ; c<commands; c++) {
				String command = st.nextToken();
				
				// 삽입할 위치(x)와 개수(y)를 받을 변수 선언
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				// 명령어 I 아니면 작업 종료
				if (!command.equals("I")) continue;
				
				// 숫자의 개수만큼 x위치에 삽입
				for (int i=0; i<y; i++) {
					// 넣을 때마다 삽입 위치는 1씩 밀어줘야함
					list.add(x+i, Integer.parseInt(st.nextToken()));
				}
			}
			// 최종 출력
			System.out.print("#"+ t + " ");
			for (int i=0; i<10; i++) {
				System.out.print(list.get(i) + " ");
			}			
			System.out.println();
		}		
	}
}
