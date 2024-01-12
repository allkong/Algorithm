import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner	sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println((a % 3 == (b + 1) % 3) ? 'A' : 'B');
	}
}