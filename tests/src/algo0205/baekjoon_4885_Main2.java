package algo0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_4885_Main2 {
	static int n[][];
	static int N;
	static boolean visit[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			N = Integer.parseInt(br.readLine());
			if (N == 0)
				break;
			n = new int[N + 1][N + 1];
			for (int i = 0; i < N + 1; i++) {
				Arrays.fill(n[i], Integer.MAX_VALUE);
			}
			visit = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					n[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			System.out.println(dfs(0, 0,n[0][0]));
		}
	}

}