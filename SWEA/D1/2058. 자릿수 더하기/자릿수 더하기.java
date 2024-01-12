import java.util.Scanner;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner	sc = new Scanner(System.in);
		String strNum = sc.nextLine();
		int sum = 0;
		for (int idx = 0; idx < strNum.length(); idx++) {
			sum += Character.getNumericValue(strNum.charAt(idx));
		}
		System.out.println(sum);
	}
}