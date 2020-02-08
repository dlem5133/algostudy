package algo0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baekjoon_17281_Main {
	static int N;
	static boolean Select[];
	static int[] seq;
	static int[][] inning;
	static int max = 0;

	static int play() {
		int ret = 0;
		int start = 0;
		for (int i = 0; i < N; i++) {
			int base[] = new int[3];
			int out = 0;
			while (true) {
				if (start == 9) {
					start = 0;
				}
				int tmp = inning[i][seq[start]];
				if (tmp == 0) {
					out++;
					if (out == 3) // 아웃카운트 3개면 이닝종료
						break;
				}

// 결과에 따른 베이스 채우기
// 1루타
				else if (tmp == 1) {
					ret += base[2];
					base[2] = base[1];
					base[1] = base[0];
					base[0] = 1;
				}

// 2루타
				else if (tmp == 2) {
					ret = ret + base[2] + base[1];
					base[2] = base[0];
					base[1] = 1;
					base[0] = 0;
				}

// 3루타
				else if (tmp == 3) {
					ret = ret + base[2] + base[1] + base[0];
					base[2] = 1;
					base[1] = 0;
					base[0] = 0;
				}

// 홈런
				else if (tmp == 4) {
					ret = ret + base[2] + base[1] + base[0] + 1;
					base[2] = 0;
					base[1] = 0;
					base[0] = 0;
				}
				start++;
			}
		}

		return ret;
	}

	static void DFS(int cnt) {
		if (cnt == 9) {
			seq[3] = 0;
			max = Math.max(max, play());
			return;

		}
		for (int i = 1; i < 9; i++) {
			if (Select[i] == true)
				continue;
			if (cnt == 3)
				cnt++;
			Select[i] = true;
			seq[cnt] = i;
			DFS(cnt + 1);
			Select[i] = false;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		inning = new int[N][9];
		Select = new boolean[9];
		seq = new int[9];
		long time = System.nanoTime();
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		DFS(0);
		System.out.println(max);
		System.out.println(System.nanoTime() - time);

	}
}

