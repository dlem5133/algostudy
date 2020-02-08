package test;


import java.util.Scanner;

public class D3_2805_Solution {
	static long N;
	public static long hol_sum(long a)
	{
		if(a==1)
		{
			System.out.println(1+" "+1);
			return 0;
		}
		long ret = 1;
		for(long i = 1;i<=a; i+=2)
		{
			ret = ret+i;
		}
		long left = hol(ret);
		long right = hol(ret+(N-1)*2);
		System.out.println(left+" "+right);
		return ret;
	}
	
	public static long hol(long n)
	{
		return n*2-1;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for(int t =1; t<=T ;t++)
		{
			System.out.print("#"+t+" ");
			N = sc.nextLong();
			long left_n = 0;
			long right_n = 0;
			if(N==1 || N==2)
				left_n=hol_sum(N);
			else
			{
				left_n = hol_sum(hol(N-1));
			}

		}
		
	}
			
}
