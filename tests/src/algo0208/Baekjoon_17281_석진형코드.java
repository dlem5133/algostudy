package algo0208;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_17281_�������ڵ� {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer ST;
	static int INNING;
	static int[][] result;
	static int[] play_order = new int[9];
	static int max;

	public static void main(String[] args) throws Exception {
		INNING = Integer.parseInt(br.readLine());
		result = new int[INNING][9];
		max = Integer.MIN_VALUE;
		long t = System.nanoTime();
		for (int i = 0; i < INNING; i++) {
			ST = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				result[i][j] = Integer.parseInt(ST.nextToken());
			}
		}

		perm(0, 0);

		if (max <= 0)
			max = 0;
		System.out.println(max);
		System.out.println(System.nanoTime()-t);
	}

	static int[] i_buf = { 2, 3, 4, 5, 6, 7, 8, 9 };
	static int[] ii_buf = new int[8];

// ����
	static void perm(int flag, int count) {
		if (count == 8) {
// System.out.println("�۹� ����");
			play_order[0] = ii_buf[0];
			play_order[1] = ii_buf[1];
			play_order[2] = ii_buf[2];
			play_order[3] = 1;
			play_order[4] = ii_buf[3];
			play_order[5] = ii_buf[4];
			play_order[6] = ii_buf[5];
			play_order[7] = ii_buf[6];
			play_order[8] = ii_buf[7];

//  for(int jj = 0; jj<9; jj++) {
//  System.out.print(play_order[jj]+"  ");
//  }System.out.println();
//  // ���⼭ ���� ����
			game();
			return;
		}
		for (int i = 0; i < 8; i++) {
			if ((flag & (1 << i)) != 0) {
				continue;
			} else if ((flag & (1 << i)) == 0) {
				ii_buf[count] = i_buf[i];
				perm(flag | (1 << i), count + 1);
			}
		}
	}

// ��������
// ���� Ÿ���� ����ִ� ���� index�� -1 ���� ��!!!

	static void game() {
		int[] base = { 0, 0, 0 };
		int out_cnt = 0;
		int score = 0;
		int tmp = 0;
		int play_cnt = 0;
		for (int i = 0; i < INNING; i++) {
			out_cnt = 0;
			base[2] = 0;
			base[1] = 0;
			base[0] = 0;
			do {

				tmp = result[i][play_order[play_cnt] - 1]; // �� �̴״�, �÷��̾��� ���
				play_cnt++;
				if (play_cnt == 9) {
					play_cnt = 0;
				}

				if (tmp == 0) {
					out_cnt++;
					if (out_cnt == 3) // �ƿ�ī��Ʈ 3���� �̴�����
						break;
				}

// ����� ���� ���̽� ä���
// 1��Ÿ
				else if (tmp == 1) {
					score += base[2];
					base[2] = base[1];
					base[1] = base[0];
					base[0] = 1;
				}

// 2��Ÿ
				else if (tmp == 2) {
					score = score + base[2] + base[1];
					base[2] = base[0];
					base[1] = 1;
					base[0] = 0;
				}

// 3��Ÿ
				else if (tmp == 3) {
					score = score + base[2] + base[1] + base[0];
					base[2] = 1;
					base[1] = 0;
					base[0] = 0;
				}

// Ȩ��
				else if (tmp == 4) {
					score = score + base[2] + base[1] + base[0] + 1;
					base[2] = 0;
					base[1] = 0;
					base[0] = 0;
				}

			} while (true);

		}
		if (score > max) {
			max = score;
		}

	}
// max Ȯ��

}
