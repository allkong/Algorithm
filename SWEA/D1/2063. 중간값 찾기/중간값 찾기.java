import java.util.Scanner;
import java.util.Arrays;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner	sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] intArray = new int[N];
		for (int idx = 0; idx < N; idx++) {
			int num = sc.nextInt();
			intArray[idx] = num;
		}
        Arrays.sort(intArray);
		System.out.println(intArray[N/2]);
	}
}