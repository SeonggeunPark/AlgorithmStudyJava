import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);

		int t = sc.nextInt();
		out: for (int tc = 1; tc <= t; tc++) {

			char[] strArr1 = sc.next().toCharArray();
			char[] strArr2 = sc.next().toCharArray();

			if (strArr1.length != strArr2.length) {
				System.out.printf("#%d %s \n", tc, "DIFF");
				continue out;
			}
			for (int i = 0; i < strArr1.length; i++) {
				if (strArr1[i] == 'B') {
					if (strArr2[i] != 'B') {
						System.out.printf("#%d %s \n", tc, "DIFF");
						continue out;
					}
				}else if (strArr1[i] == 'A' || strArr1[i] == 'D' || strArr1[i] == 'O' || strArr1[i] == 'P'
						|| strArr1[i] == 'Q' || strArr1[i] == 'R') {
					if (strArr2[i] != 'A' && strArr2[i] != 'D' && strArr2[i] != 'O' && strArr2[i] != 'P'
							&& strArr2[i] != 'Q' && strArr2[i] != 'R') {
						System.out.printf("#%d %s \n", tc, "DIFF");
						continue out;
					}
				} else {
					if (strArr2[i] == 'A' || strArr2[i] == 'D' || strArr2[i] == 'O' || strArr2[i] == 'P'
							|| strArr2[i] == 'Q' || strArr2[i] == 'R' || strArr2[i] == 'B') {
						System.out.printf("#%d %s \n", tc, "DIFF");
						continue out;
					}
				}
			}
			System.out.printf("#%d %s \n", tc, "SAME");
		}
	}
}
