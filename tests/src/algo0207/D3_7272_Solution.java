package algo0207;

import java.util.Scanner;

public class D3_7272_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 1;t<=T;t++)
		{
			char[] A = sc.next().toCharArray();
			char[] B = sc.next().toCharArray();
			if(A.length!=B.length)
			{
				System.out.println("#"+t+" "+"DIFF");
				continue;
			}
			for(int i = 0; i<A.length;i++)
			{
				if(A[i] == 'A' || A[i] == 'D' || A[i] == 'O' ||A[i] == 'P' || A[i] == 'Q' || A[i] == 'R')
				{
					A[i] = '1';
				}
				else if(A[i] =='B')
				{
					A[i] = '2';
				}
				else
				{
					A[i] = '0';
				}
			}
			for(int i = 0; i<B.length;i++)
			{
				if(B[i] == 'A' || B[i] == 'D' || B[i] == 'O' ||B[i] == 'P' || B[i] == 'Q' || B[i] == 'R')
				{
					B[i] = '1';
				}
				else if(B[i] =='B')
				{
					B[i] = '2';
				}
				else
				{
					B[i] = '0';
				}
			}
			boolean plag = true;
			for(int i = 0;i<A.length;i++)
			{
				if(A[i] != B[i])
				{
					plag = false;
					break;
				}
			}
			if(plag)
				System.out.println("#"+t+" "+"SAME");
			else
				System.out.println("#"+t+" "+"DIFF");

		}
	}
}
