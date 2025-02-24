import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		long T = Integer.parseInt(br.readLine());

		for (long t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			long x = Integer.parseInt(st.nextToken());
			long y = Integer.parseInt(st.nextToken());
			long dist = y-x;

			long n=(int) Math.sqrt(dist)-1;
			for (;; n++) {
				long tmp = n*(n+1);
				if (tmp > dist) {
					n-=1;
					break;
				} else if (tmp == dist) {
					break;
				}
			}
			
			long remain = dist-n*(n+1);
			
			if (remain == 0) {
				System.out.println(n*2);
			} else if (remain <= n+1) {
				System.out.println(n*2+1);
			} else {
				System.out.println(n*2+2);
			}
		}
	}
}
