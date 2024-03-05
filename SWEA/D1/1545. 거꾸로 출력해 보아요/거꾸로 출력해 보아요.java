import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 숫자를 입력받는다.
 * 2. 입력받는 숫자를 출력한다.
 * 3. 숫자를 하나 감소시켜서 출력한다.
 * 4. 숫자가 0이 될 때까지 3번을 반복한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine().trim());
		
		for (int idx = num; idx >= 0; idx--) {
			sb.append(idx).append(" ");
		}
		
		System.out.println(sb);
	}
}
