import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 숫자 두 개를 입력받는다.
 * 2. 두 숫자를 나눴을 대의 몫과 나머지를 구한다.
 *    2-1. 자바에서 몫은 /, 나머지는 %로 구한다.
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
			st = new StringTokenizer(br.readLine().trim());
			
			int operand1 = Integer.parseInt(st.nextToken());
			int operand2 = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(tc).append(" ").append(operand1 / operand2).append(" ").append(operand1 % operand2).append("\n");
		}
		System.out.println(sb);
	}
}
