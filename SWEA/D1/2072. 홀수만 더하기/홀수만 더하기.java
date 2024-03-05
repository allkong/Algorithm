import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 여러 숫자들을 입력받아 홀수면 더한다.
 *    2-1. oddTotal을 0으로 초기화한다.
 *    2-2. 입력받은 숫자가 2로 나누어 떨어지지 않으면 홀수이므로 oddTotal에 더한다.
 *         2-2-1. 2로 나누어 떨어지면 2의 배수이므로 짝수이다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int oddTotal = 0;
			st = new StringTokenizer(br.readLine().trim());
			
			for (int idx = 0; idx < 10; idx++) {
				int num = Integer.parseInt(st.nextToken());
				
				if (num % 2 != 0) {
					oddTotal += num;
				}
			}
			sb.append("#").append(tc).append(" ").append(oddTotal).append("\n");
		}
		System.out.println(sb);
	}
}
