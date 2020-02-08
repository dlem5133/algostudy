package algo0208;

import java.util.Scanner;

public class baekjoon_1592_Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int arr[] = new int [N];
		int temp = 0;
		int cnt = 0;
		while(arr[temp]<M)
		{
			arr[temp]++;
			if(arr[temp]==M)
			{
				break;
			}
			if(arr[temp]%2==0)
			{
				temp = temp + L;
				if(temp>N-1)
				{
					temp= temp-N;
				}
			}
			else
			{
				temp = temp -L;
				if(temp<0)
				{
					temp = N+temp;
				}
			}
			cnt++;
		}
		System.out.println(cnt);
	}
}
