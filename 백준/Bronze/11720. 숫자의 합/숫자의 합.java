import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int sum =0 ;
		
		for (int i=0; i<N; i++) {
			sum += Integer.parseInt(String.valueOf(str.charAt(i)));
		}
		
		System.out.println(sum);
		
	}
}
