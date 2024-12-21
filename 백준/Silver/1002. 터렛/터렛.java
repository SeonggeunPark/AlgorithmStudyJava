import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int r1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			int r2 = Integer.parseInt(st.nextToken());

			double d = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
			int R = r1 + r2;

			if (x1 == x2 && y1 == y2) {
				if (r1 == r2) {
					System.out.println(-1);
				} else {
					System.out.println(0);
				}
			} else {
                // 두 원이 전혀 교차하지 않는 경우
                if (d > R || d < Math.abs(r1 - r2)) {
                    System.out.println(0);
                }
                // 두 원이 외접하는 경우
                else if (d == R) {
                    System.out.println(1);
                }
                // 두 원이 내부에서 접하는 경우
                else if (d == Math.abs(r1 - r2)) {
                    System.out.println(1);
                }
                // 두 원이 두 점에서 교차하는 경우
                else {
                    System.out.println(2);
                }
			}
		}
	}

}
