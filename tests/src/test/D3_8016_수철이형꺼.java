package test;

import java.util.Scanner;

public class D3_8016_¼öÃ¶ÀÌÇü²¨ {
	static long N;

	public static long hol_sum(long a) {
		long ret = 1;
		for (long i = 1; i <= a; i += 2) {
			ret = ret + i;
		}
		return ret;
	}

	public static long hol(long n) {
		return n * 2 - 1;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int iT = 1; iT <= T; iT++) {
			long N = sc.nextLong();

			long A = 1;
			long RA;
			long LA;
			if (N == 1) {
				LA = 1;
				RA = 1;
				System.out.println("#" + iT + " " + LA + " " + RA);
				continue;
			}

			A = hol_sum(hol(N - 1));
			LA = (A * 2) - 1;
			RA = ((N * 2 - 1) - 1) * 2 + LA;

			System.out.println("#" + iT + " " + LA + " " + RA);

		}

	}

}
