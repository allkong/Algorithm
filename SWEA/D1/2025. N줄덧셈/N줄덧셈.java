import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int end = Integer.parseInt(br.readLine());
		int sum = 0;
		for (int num = 1; num <= end; num++) {
			sum += num;
		}
		System.out.println(sum);
	}
}