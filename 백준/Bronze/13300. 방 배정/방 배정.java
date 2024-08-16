import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int room = 0;
        
        //[학년][성별]: 학생수
        int[][] students = new int [6][2];
        // 성별, 학년 입력받아 저장
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            
            students[grade-1][sex]++;
        }
        // K명으로 나누어 떨어지면 => 방 수 : 학생 수 / K 
        // 안떨어지면 방 1개 더 추가 => 방 수 : 학생 수 / K + 1
        for (int i=0; i<6; i++) {
        	for (int j=0; j<2; j++) {
        		room += students[i][j]%K == 0 ? students[i][j]/K : students[i][j]/K+1;
        	}
        }
        
        System.out.println(room);
    }
}