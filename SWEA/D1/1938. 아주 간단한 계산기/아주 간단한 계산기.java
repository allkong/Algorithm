import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 두 수를 입력받는다.
 * 2. 사칙연산(+, -, *, /) 순으로 연산 결과를 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		// 두 수를 입력받는다.
		st = new StringTokenizer(br.readLine().trim());
		int num1 = Integer.parseInt(st.nextToken());
		int num2 = Integer.parseInt(st.nextToken());
		
		// 사칙연산(+, -, *, /) 순으로 연산 결과를 출력한다.
		System.out.println(num1 + num2);
		System.out.println(num1 - num2);
		System.out.println(num1 * num2);
		System.out.println(num1 / num2);
	}
}