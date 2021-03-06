package algo0208;

import java.util.Arrays;
import java.util.Scanner;

public class D3_1244_Solution {
	static int n;
	static int result = 0;
	static char[] num;
	static void dfs(int cur, int cnt) {
	    if(cnt==n) {
	        result=Math.max(result,Integer.parseInt(String.valueOf(num)));
	        return;
	    }
	    for(int i=cur; i<num.length; i++) {
	        for(int j=i+1; j<num.length; j++) {
	            
	            	char temp = num[i];
	            	num[i] = num[j];
	            	num[j] = temp;
	            	dfs(i, cnt + 1);
	            	temp = num[i];
	            	num[i] = num[j];
	            	num[j] = temp;
	            
	        }
	    }
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t =1; t<=T;t++)
		{
			result = 0;
			num = sc.next().toCharArray();
			n = sc.nextInt();
			dfs(0,0);
			System.out.println("#"+t+" "+result);
		}
	}
	
}
