package algo0208;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class baekjoon_17413_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer main = new StringBuffer();
		StringBuffer sub = new StringBuffer();
		
		char c[] = br.readLine().toCharArray();
		boolean plag = false;
		for(int i = 0;i<c.length;i++)
		{
			if(c[i]=='<')
			{				
				sub.reverse();
				main.append(sub);
				main.append(c[i]);
				sub = new StringBuffer();
				plag = true;
				continue;
			}
			if(c[i]=='>')
			{
				main.append(c[i]);
				plag = false;
				continue;
			}
			if(c[i] ==' ')
			{
				sub.reverse();
				main.append(sub);
				main.append(' ');
				sub = new StringBuffer();
				continue;
			}
			if(plag)
				main.append(c[i]);
			else
			{
				sub.append(c[i]);
			}
		}
		sub.reverse();
		main.append(sub);
		System.out.println(main);
	}
}
