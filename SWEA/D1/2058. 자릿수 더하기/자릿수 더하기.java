import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String strNum = br.readLine();
		int sum = 0;
		
		for (int idx = 0; idx < strNum.length(); idx++) {
			sum += Character.getNumericValue(strNum.charAt(idx));
		}
		System.out.println(sum);
	}
}