package algo0205;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class baekjoon_7227_Main {
	public static class com implements Comparator<int[]>
	{
		@Override
		public int compare(int[] o1, int[] o2) {
			if(o1[0]>o2[0])
			{
				return 1;
			}
			return -1;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		ArrayList<int[]> arr = new ArrayList<int[]>();
		int T = sc.nextInt();
		for(int t=1;t<=T;t++) {
			int N = sc.nextInt();
			for(int i=0;i<N;i++)
			{
				int temp[] = new int[2];
				temp[0] = sc.nextInt();
				temp[1] = sc.nextInt();
				arr.add(temp);
			}
			arr.sort(new com());		
			System.out.println();
		}
	}

}