import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 1부터 입력받은 숫자까지의 누적 값을 구한다.
 *    1-1. 홀수이면 더하고, 짝수이면 뺀다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int end = Integer.parseInt(br.readLine().trim());
			int prefix = 0; // 누적 값
			
			for (int num = 1; num <= end; num++) {
				// 홀수면 더하고 짝수면 뺀다
				if (num % 2 != 0) {
					prefix += num;
				} else {
					prefix -= num;
				}
			}
			sb.append("#").append(tc).append(" ").append(prefix).append("\n");
		}
		System.out.println(sb);
	}
}