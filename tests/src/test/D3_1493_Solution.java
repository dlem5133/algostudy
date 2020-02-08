package test;

import java.util.Scanner;

public class D3_1493_Solution {
	public static int find_value(int x, int y)
	{
		int ret=1;
		for(int i = 1;i<y;i++)
		{
			ret = ret+i;
		}
		int cnt = y+1;
		for(int i = 1;i<x;i++)
		{
			ret = ret+cnt;
			cnt++;
		}
		return ret;
	}
	public static void find_point(int t,int a,int b)
	{
		int limit = 0;
		int i = 1;
		while(limit<a)
		{
			limit += i;
			i++;
		}
		int x1 = i-(limit - a)-1;
		int y1 = limit-a+1;
		limit =0;
		i = 1;
		while(limit<b)
		{
			limit += i;
			i++;
		}
		int x2 = i-(limit - b)-1;
		int y2 = limit-b+1;
		int ret = find_value(x1+x2, y1+y2);
		System.out.println("#"+t+" "+ret);
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			find_point(t, sc.nextInt(), sc.nextInt());
		}
	}
}
