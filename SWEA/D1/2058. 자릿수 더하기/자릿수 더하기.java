import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static BufferedReader br;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		String strNum = br.readLine().trim();
		int total = 0;
		
		for (int idx = 0; idx < strNum.length(); idx++) {
			total += Character.getNumericValue(strNum.charAt(idx));
		}
		
		System.out.println(total);
	}
}