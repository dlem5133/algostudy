package algo0207;

import java.util.Scanner;

public class D3_7234_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			int B = sc.nextInt();
			int arr[][] = new int[N+1][N+1];
			for (int i = 0; i < B; i++) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				arr[y][x] = 1;
				if(y-1>=0)
				{
					arr[y-1][x]++;
				}
				if(y-2>=0)
				{
					arr[y-2][x]++;
				}
				if(y+1<N)
				{
					arr[y+1][x]++;
				}
				if(y+2<N)
				{
					arr[y+2][x]++;
				}
				if(x-1>=0)
				{
					arr[y][x-1]++;
				}
				if(x-2>=0)
				{
					arr[y][x-2]++;
				}
				if(x+1<N)
				{
					arr[y][x+1]++;
				}
				if(x+2<N)
				{
					arr[y][x+2]++;
				}
			}
			int max =0;
			for(int i =0;i<N;i++)
			{
				for(int j = 0; j<N;j++)
				{
					max = Math.max(max, arr[i][j]);
				}
			}
			
			System.out.println("#"+t+" "+max);
			
		}
	}
}
