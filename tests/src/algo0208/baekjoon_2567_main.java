package algo0208;

import java.util.Arrays;
import java.util.Scanner;

public class baekjoon_2567_main {
	static int arr[][];
	static void coloring(int x,int y)
	{
		for(int i = x;i<x+10;i++)
		{
			for(int j = y;j<y+10;j++)
			{
				arr[i][j] = 1;
			}
		}
	}
	static int isone(int y,int x)
	{
		int ret = 0;
		if(arr[y+1][x] == 0)
			ret++;
		if(arr[y][x+1] == 0)
			ret++;
		if(arr[y-1][x] == 0)
			ret++;
		if(arr[y][x-1] == 0)
			ret++;
		return ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new int [102][102];
		for(int i =1;i<N+1;i++)
		{
			int x = sc.nextInt()+1;
			int y = sc.nextInt()+1;
			coloring(x,y);
		}
		for(int i =0;i<102;i++)
		{
			System.out.println(Arrays.toString(arr[i]));
		}
		int cnt = 0;
		for(int i = 1;i<101;i++)
		{
			for(int j = 1;j<101;j++)
			{
				if(arr[i][j]==1)
				{
					cnt+= isone(i,j);
				}
			}
		}
		System.out.println(cnt);
		
	}
}
