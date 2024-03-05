import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 자연수를 입력받는다.
 * 2. 각 자릿수의 합을 구한다.
 *    2-1. 입력받은 숫자의 자릿수만큼 반복해서 숫자의 자리마다 접근한다.
 *    2-2. charAt()으로 문자열의 문자에 접근하고, Character.getNumericValue()로 문자를 숫자로 변환한다.
 */
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
