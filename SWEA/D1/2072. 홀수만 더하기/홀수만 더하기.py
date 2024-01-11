import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner	sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int sum = 0;
			for (int idx = 0; idx < 10; idx++) {
				int num = sc.nextInt();
				if (num % 2 != 0) {
					sum += num;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}