import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 숫자를 입력받는다.
 * 3. 숫자 * 숫자를 출력한다. (정사각형이 가장 넓이가 넓은 경우이다)
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int number = Integer.parseInt(br.readLine().trim());
			sb.append("#").append(tc).append(" ").append(number * number).append("\n");
		}
		System.out.println(sb);
	}
}