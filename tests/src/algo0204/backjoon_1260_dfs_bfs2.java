package algo0204;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class backjoon_1260_dfs_bfs2 {
	static int N, M;
	static int arr[][];
	static boolean visit[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int start = sc.nextInt();
		arr = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}
		visit = new boolean[N+1];
		visit[start] = true;
		System.out.print(start+" ");
		dfs(start);
		System.out.println();
		bfs(start);
		
	}

	public static void bfs(int a) {
		visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(a);
		visit[a] = true;
		while(!q.isEmpty())
		{
			int temp = q.poll();
			System.out.print(temp+" ");
			for(int i=1;i<N+1;i++)
			{
				if(arr[temp][i]==1 && !visit[i])
				{
					visit[i] = true;

					q.add(i);
				}
			}
		}
	}

	public static void dfs(int a) {
		for (int i = 1; i < N + 1; i++) {
			if (arr[a][i] == 1 && !visit[i]) {
				System.out.print(i + " ");
				visit[i] = true;
				dfs(i);
			}
		}
	}

}
