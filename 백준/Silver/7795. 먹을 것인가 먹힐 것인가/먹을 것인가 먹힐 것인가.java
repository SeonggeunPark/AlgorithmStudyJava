import java.io.*;
import java.util.*;

public class Main {

    // B에서 a보다 작은 원소 개수 찾기
    private static int getSmallerCount(int[] bList, int target) {
        int left = 0, right = bList.length;
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (bList[mid] < target) left = mid + 1;
            else right = mid;
        }
        return left; // target보다 작은 원소 개수
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testCnt = Integer.parseInt(br.readLine().trim());

        while (testCnt-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int bSize = Integer.parseInt(st.nextToken());

            int[] foodsA = new int[aSize];
            int[] foodsB = new int[bSize];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < aSize; i++) foodsA[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < bSize; i++) foodsB[i] = Integer.parseInt(st.nextToken());

            Arrays.sort(foodsB);

            long pairCnt = 0;
            for (int a : foodsA) {
                pairCnt += getSmallerCount(foodsB, a);
            }
            sb.append(pairCnt).append('\n');
        }

        System.out.print(sb);
    }
}
