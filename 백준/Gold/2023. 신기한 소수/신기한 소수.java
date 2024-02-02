import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 자릿수를 입력받는다.
 * 2. 한 자리 숫자 중에 소수인 수로 시작한다.
 *    2-1. {2, 3, 5, 7}
 * 3. 2번에서의 소수인 한 자리 옆에 한 자리 숫자를 더 붙인 두 자리 숫자가 소수인지 확인한다.
 *    3-1. 이때, 추가로 붙이는 한 자리 숫자는 {1, 3, 5, 7} 중 하나이다.
 *    3-2. 소수인 숫자는 모두 {1, 3, 5, 7} 중에 하나로 끝나기 때문이다.
 * 4. 2번에서 만든 숫자가 입력받은 자릿수가 될 때까지 재귀를 호출한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static final int[] oneDigit = {2, 3, 5, 7}; // 한 자리 소수
	public static final int[] otherDigit = {1, 3, 5, 7, 9}; // 여러 자리일 때 소수 마지막 자리
	public static int maxDigit; // 만들어야 하는 숫자의 자릿수
	
	public static boolean primeNumber(int number) {
		// 소수인지 판별한다
		// number의 절반은 2로 나눈 것과 같으므로 절반 이전까지 검사한다
		for (int operand = 2; operand < number / 2; operand++) {
			// 나눠진다면 소수가 아니므로 false를 반환한다
			if (number % operand == 0) {
				return false;
			}
		}
		// 나눠지지 않았다면 소수이므로 true를 반환한다
		return true;
	}
	
	public static void recursive(int number, int digit) {
		// 기저 조건
		// 자릿수가 원하는 자릿수가 되었으면 종료한다
		if (digit == maxDigit) {
			sb.append(number).append("\n");
			return;
		}
		
		// number에 숫자를 붙였을 때 해당 숫자도 소수인지 판별한다
		for (int idx = 0; idx < otherDigit.length; idx++) {
			// 소수이면 재귀를 활용해 한 자리를 더 추가한다
			if (primeNumber(number * 10 + otherDigit[idx])) {
				recursive(number * 10 + otherDigit[idx], digit + 1);
			}
		}
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		maxDigit = Integer.parseInt(br.readLine().trim()); // 자릿수
		
		// 한 자리 소수를 시작으로 그 뒤에 다른 숫자를 연결한다
		for (int idx = 0; idx < oneDigit.length; idx++) {
			recursive(oneDigit[idx], 1);
		}
		
		System.out.println(sb);
	}
}