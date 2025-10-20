import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		System.out.println(fibonacci(n));
	}
	static final long MOD = 1_000_000_007L;
    private static long fibonacci(long n) {
        if (n == 0) return 0;

        long a = 0; // F(0)
        long b = 1; // F(1)

        // n의 최상위 1비트부터 내려오며 처리
        for (int i = 63 - Long.numberOfLeadingZeros(n); i >= 0; --i) {
            // (F(2k), F(2k+1)) 만들기
            long t = ((2 * b) % MOD - a + MOD) % MOD;
            long c = (a * t) % MOD;                         
            long d = ((a * a) % MOD +(b * b) % MOD) % MOD; 

            if (((n >> i) & 1L) == 0) { 
                a = c; 
                b = d;
            } else {                    
                a = d; 
                b = (c + d) % MOD;
            }
        }
        return a; // F(n)
    }
}
/* 
 * 2 = 1 0
 * 3 = 2 1
 * ...
 * n-2 = n-3 n-4
 * n-1 = n-2 n-3
 * n = n-1 n-2
 * 
 * 
 * => Fn = Fn-2 + Fn-3 + Fn-4 + Fn-5 + Fn-6 ...F2 + F1 + F1 + F0
 * 			= Fn-1 + Fn-3 + Fn-5 +... + F3 + F2
 * 			= 2*Fn-2 + Fn-3
 * 
 *  F6 = F4 + F3 + F2 + F1+ 1
 *    = F3+F2+F1+1 + F2+F1+1 + F1+1 + F2 + F1 + 1
 *    = 
 *  2 = 1 + 0  = 0 + 2*1
 *  3 = 1 0 1 0 = 2t + 3k
 *  4 = 1 0 1 0 1 0 3F1 3F0 = 
 *  5 = 1 0 1 0 1 0 1 0 1 0 = 5F1 5F0
 *  6 = 1 0 1 0 1 0 1 0 1 0 1 0 1 0 1 0 = 8F1 8F0
 * 	Fn-2 = Fn-4+....+F1+1
 *  Fn-3 = Fn-5+....+F1+1
 *  F3 = F1+1
 */ 