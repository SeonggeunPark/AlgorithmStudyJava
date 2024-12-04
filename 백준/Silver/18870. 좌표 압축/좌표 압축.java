import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int[] result = new int[N];
        
        // 값 입력 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        // 값 복사하여 오름차순 정렬
        int[] sortedArr = arr.clone();
        Arrays.sort(sortedArr);
        
        // 압축된 좌표를 저장할 맵 (값 -> 순위)
        Map<Integer, Integer> rankMap = new HashMap<>();
        int rank = 0;
        
        // 중복 값 처리: 중복 값에 대해 동일한 순위를 부여
        for (int value : sortedArr) {
            if (!rankMap.containsKey(value)) {
                rankMap.put(value, rank++);
            }
        }
        
        // 원래 배열에 대해 압축된 순위 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(rankMap.get(arr[i])).append(' ');
        }
        
        System.out.println(sb.toString());
    }
}
