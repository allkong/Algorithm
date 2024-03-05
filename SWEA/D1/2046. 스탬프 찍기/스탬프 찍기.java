import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 스탬프를 출력할 횟수를 입력받는다.
 * 2. 입력받은 횟수만큼 스탬프를 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();

		// 스탬프를 출력할 횟수를 입력받는다
		int count = Integer.parseInt(br.readLine().trim());

		// 입력받은 횟수만큼 스탬프를 출력한다
		for (int idx = 0; idx < count; idx++) {
			sb.append("#");
		}
		System.out.println(sb);
	}
}
