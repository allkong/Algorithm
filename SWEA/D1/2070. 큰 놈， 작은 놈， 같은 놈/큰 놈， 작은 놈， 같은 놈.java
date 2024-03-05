import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 두 개의 숫자를 입력받는다.
 * 2. if문을 통해 두 개의 숫자를 비교한다.
 *    2-1. 첫 번째 숫자가 더 크면 >를 출력한다.
 *    2-2. 두 번째 숫자가 더 크면 <를 출력한다.
 *    2-3. 두 수가 같으면 =를 출력한다.
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
			
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
			sb.append("#").append(tc).append(" ");
			
			if (num1 > num2) {
				sb.append(">").append("\n"); // 첫 번째 숫자가 더 크면 >를 출력한다
			} else if (num1 < num2) {
				sb.append("<").append("\n"); // 두 번째 숫자가 더 크면 <를 출력한다
			} else {
				sb.append("=").append("\n"); // 두 수가 같으면 =를 출력한다
			}
		}
		
		System.out.println(sb);
	}
}
