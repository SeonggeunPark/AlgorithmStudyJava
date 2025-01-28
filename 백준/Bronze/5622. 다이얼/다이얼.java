import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] word = br.readLine().toCharArray();

		int time = 0;
		for (char c : word) {
			int dial = c - 65;
			if (dial <= 17) {
				time += (dial / 3) + 3;
			} else {
				if (dial == 25) {
					time += 10;
				} else {
					time += ((dial + 2) / 3) + 2;
				}
			}
		}

		System.out.println(time);
	}
}