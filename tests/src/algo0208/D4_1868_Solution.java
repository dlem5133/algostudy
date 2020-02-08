package algo0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class D4_1868_Solution {
	static int dx[] = {0,1,1,1,0,-1,-1,-1};
	static int dy[] = {1,1,0,-1,-1,-1,0,1};
	static char[][] arr;
	static boolean visit[][];
	static int N;
	
	static boolean check(int y, int x, char a)
	{
		boolean ret = false;
		for(int i = 0;i<8;i++)
		{
			if(x+dx[i]>=0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<N && arr[y+dy[i]][x+dx[i]] == a)
			{
				return true;
			}
		}
		return ret;
	}
	static void go(int y,int x)
	{
		visit[y][x] = true;
		for(int i = 0;i<8;i++)
		{
			if(x+dx[i]>=0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<N && arr[y+dy[i]][x+dx[i]] == '0' && !visit[y+dy[i]][x+dx[i]])
			{
				go(y+dy[i],x+dx[i]);
			}
		}
		return ;
	}
	static void remove(int y,int x)
	{
		for(int i = 0;i<8;i++)
		{
			if(x+dx[i]>=0 && x+dx[i]<N && y+dy[i]>=0 && y+dy[i]<N && arr[y+dy[i]][x+dx[i]] == '1')
			{
				arr[y+dy[i]][x+dx[i]] = '2';
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int t= 1;t<=T;t++)
		{
			N = Integer.parseInt(br.readLine());
			arr = new char[N][N];
			visit = new boolean[N][N];
			for(int i = 0;i<N;i++)
			{
				arr[i] = br.readLine().toCharArray();
			}
			for(int i = 0;i<N;i++)
			{
				for (int j = 0; j < arr.length; j++) {
					if(arr[i][j]=='.')
					{
						if(check(i,j,'*'))
							arr[i][j]='1';
						else
							arr[i][j]='0';
					}
						
				}
			}
			int cnt = 0;
			for(int i = 0;i<N;i++)
			{
				for (int j = 0; j < N; j++) {
					if(arr[i][j]=='0'&& !visit[i][j])
					{
						cnt++;
						go(i,j);
					}
				}	
			}
			for(int i = 0;i<N;i++)
			{
				for (int j = 0; j < N; j++) {
					if(arr[i][j]=='0')
					{
						remove(i,j);
					}
				}
			}
			for(int i = 0;i<N;i++)
			{
				for (int j = 0; j < N; j++) {
					if(arr[i][j]=='1')
					{
						cnt++;
					}
				}
			}
			System.out.println("#"+t+" "+cnt);
		}
	}
}
