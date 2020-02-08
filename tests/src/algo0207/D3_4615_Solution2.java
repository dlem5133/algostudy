package algo0207;

import java.util.Scanner;

public class D3_4615_Solution2 {
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int arr[][];
	static int N;

	public static void reverse(int x, int y, int color) {
		arr[y][x] = color;
		int temp_c = 0;
		if (color == 1)
			temp_c = 2;
		else
			temp_c = 1;
		for (int i = 0; i < 8; i++) {
			int tx = x;
			int ty = y;
			if (tx + dx[i] >= 0 && tx + dx[i] < N && ty + dy[i] >= 0 && ty + dy[i] < N
					&& arr[ty + dy[i]][tx + dx[i]] == temp_c) {
				tx += dx[i];
				ty += dy[i];
				while (arr[ty][tx] == temp_c) {
					tx += dx[i];
					ty += dy[i];
					if (tx < 0 || tx >= N || ty < 0 || ty >= N || arr[ty][tx] == 0) {
						break;
					}
				}
				
				if (tx < 0 || tx >= N || ty < 0 || ty >= N || arr[ty][tx] == 0)
					continue;
				if(arr[ty][tx]==1) {
					while (!(tx - dx[i] == x && ty - dy[i] == y)) {
						tx -= dx[i];
						ty -= dy[i];
						arr[ty][tx] = color;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			arr = new int[N][N];
			arr[N / 2 - 1][N / 2 - 1] = 2;
			arr[N / 2 - 1][N / 2] = 1;
			arr[N / 2][N / 2 - 1] = 1;
			arr[N / 2][N / 2] = 2;
			for (int i = 0; i < M; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				reverse(x, y, sc.nextInt());
			}
			int white = 0;
			int black = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 1) {
						black++;
					} else if (arr[i][j] == 2)
						white++;
				}
			}
			System.out.println("#" + t + " " + black + " " + white);
		}
	}
}
