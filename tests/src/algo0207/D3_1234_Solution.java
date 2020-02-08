package algo0207;

import java.util.Scanner;

public class D3_1234_Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int t = 1; t <= 10; t++) {
			int n = sc.nextInt();
			char arr[] = sc.next().toCharArray();
			char temp = arr[0];
			int index = 0;
			for (int i = 1; i < n; i++) {
				if (arr[i] == 'A')
					continue;
				if (temp == arr[i]) {
					arr[index] = 'A';
					arr[i] = 'A';
					while (arr[index] == 'A') {
						if (index - 1 < 0) {
							break;
						}
						index--;
					}
					temp = arr[index];
				} else {
					temp = arr[i];
					index = i;
				}
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != 'A')
					System.out.print(arr[i]);
			}
			System.out.println();
		}
	}
}
