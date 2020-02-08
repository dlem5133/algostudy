package algo0205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class baekjoon_4885_Main {
	static int n[][];
	static int N;
	static boolean visit[][];
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };

	public static int greedy(int x, int y) {
		int ret = n[x][y];
		while (true) {
			if (x == N - 1 && y == N - 1) {
				return ret;
			}
			if (n[x + 1][y] < n[x][y + 1]) {
				x++;
			} else {
				y++;
			}
			ret += n[x][y];
		}
	}

	public static int dfs(int x, int y, int value) {
		int ret = value;
		int min = Integer.MAX_VALUE;
		if (x == N - 1 && y == N - 1) {
			return ret+n[N - 1][N - 1];
		}
		for (int i = 0; i < 4; i++) {
			if (x + dx[i] > -1 && y + dy[i] > -1 && x + dx[i] < N && y + dy[i] < N && !visit[y + dy[i]][x + dx[i]]) {
				visit[y][x] = true;
				min = Math.min(ret, dfs(x+dx[i],y+dy[i],value+n[y+dy[i]][x+dx[i]]));
				visit[y][x] = false;
			}
		}
		return ret+min;
	}

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