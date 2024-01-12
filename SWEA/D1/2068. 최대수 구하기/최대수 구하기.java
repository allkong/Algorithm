import java.util.Scanner;

public class Solution {

	public static void main(String args[]) throws Exception {
		Scanner	sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc < T + 1; tc++) {
			int max = 0;
			for (int idx = 0; idx < 10; idx++) {
				int num = sc.nextInt();
				if (max < num) {
					max = num;
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}