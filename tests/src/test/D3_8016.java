package test;

import java.util.Scanner;

public class D3_8016 {
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			System.out.print("#" + t + " ");
			N = sc.nextInt();
			int arr[][] = new int[N][N];
			for (int i = 0; i < N; i++) {
				String a = sc.next();
				char [] temp = a.toCharArray();
				for (int j = 0; j < N; j++) {
					arr[i][j] = temp[j]-(int)'0';
				}
			}
			int ret =0;
			int cnt= 1;
			for (int i = 0; i < N; i++) {
				if (i <= N / 2) {
					int start = N/2-i;
					for (int j = 0; j < i*2+1; j++) {
						ret += arr[i][start];
						start++;
					}
				}
				else
				{
					int start = cnt;
					for (int j = 0; j < N-cnt*2; j++) {
						ret += arr[i][start];
						start++;
					}
					cnt++;


				}
				
			}
			System.out.println(ret);
		}

	}

}
