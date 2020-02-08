package algo0202;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D5_3308_Solution {
	static int cache[];
	static int arr[];
	static int N;
	static int T;

	public static int F() {
		int max = 0;
		for(int i =N-1;i>=0;i--)
        {
            max = Math.max(max, n_arr(i,0));
        }
		return max;
	}
	public static int n_arr(int start,int count)
	{
		int ret = count;
		long temp = arr[start];
		
		if(cache[start]!=0)
			return ret+cache[start];
		for(int i = start+1;i<N;i++)
		{
			if(temp<arr[i])
			{
				ret = Math.max(ret, n_arr(i,count+1));
			}
		}
		cache[start] = ret;
		return ret;
	}
	public static void input(BufferedReader br) throws NumberFormatException, IOException
	{
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	}
	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			arr = new int[N];
			cache = new int[N];
			cache[N-1] = 1;
			input(br);
			System.out.println("#"+t+" "+F());
		}
	}
}
