package algo0202;

import java.util.Scanner;

public class D5_9015_Solution {
	static int [] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1;t<=T;t++)
		{
			int N = sc.nextInt();
			arr = new int[N];
			boolean plag = true;
			for(int i = 0; i<N;i++)
			{
				arr[i] = sc.nextInt();
			}
			int cnt = 1;
			for(int i =1;i<N-1;i++)
			{
				if(arr[i-1]<arr[i]&&plag==false)
				{
					plag = true;
					cnt++;
				}
				else if(arr[i]>arr[i+1]&&plag==true)
				{
					plag = false;
					cnt++;
				}
			
				
			}
			System.out.println(cnt);
		}
	}
}
