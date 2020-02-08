package test;

import java.util.Arrays;
import java.util.Scanner;

public class D4_1858_Solution {
	static char arr[][];
	static int Di[] = {-1,-1, 0, 1 , 1, 1, 0,-1};//ºÏ µ¿ºÏ µ¿ µ¿³² ³² ¼­³² ¼­ ¼­ºÏ
 	static int Dj[] = {0 , 1, 1, 1 , 0,-1,-1,-1};
 	public static boolean check(int di,int dj,char c)
	{
		boolean ret = false;
		for(int i=0;i<Di.length;i++)
		{
			System.out.println((di+Di[i])+" "+(dj+Dj[i]));
			if(arr[di+Di[i]][dj+Dj[i]]==c)
			{
				return true;
			}
		}
		return ret;
	}
 	public static boolean visit(int di,int dj)
	{
		boolean ret = true;
		
		if(arr[di][dj-1]=='v' || arr[di+1][dj]=='v'||arr[di-1][dj]=='v' || arr[di][dj+1]=='v')
		{
			ret = false;
		}
		return ret;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T;t++) {
			int N = sc.nextInt();
			arr = new char[N+3][N+3];
			for(int i =0;i<N+3;i++)
			{
				Arrays.fill(arr[i],'1');
			}
			for(int i =1;i<=N;i++)
			{
				String s = sc.next();
				arr[i] = s.toCharArray();
			}
			int cnt =0;
			for (int i = 1; i < arr[0].length-3; i++) {
				for (int j = 1; j < arr[0].length-3; j++) {
					if(check(i,j,'*'))
					{
						arr[i][j] = '1';
						cnt++;
					}
				}
			}
			for (int i = 1; i < arr[0].length-3; i++) {
				for (int j = 1; j < arr[0].length-3; j++) {
					if(check(i,j,'0'))
					{
						cnt--;
					}
				}
			}
//			for (int i = 1; i < arr.length-1; i++) {
//				for (int j = 1; j < arr.length-1; j++) {
//					if(arr[i][j]=='0')
//					{
//						if(visit(i, j))
//						{
//							cnt++;
//						}
//						for(int k =0;k<4;k++)
//						{
//							
//						}
//						arr[i][j] = 'v';
//					}
//				}
//			}
			
			System.out.println(cnt);
			
		}
		
	}
}
