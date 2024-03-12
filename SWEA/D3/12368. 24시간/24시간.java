import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 현재 시각과 경과 시간을 입력받는다.
 *    2-1. 시간은 항상 정각이다.
 *    2-2. 24시간제로, 자정은 0시이다.
 * 3. 현재 시각에 경과 시간을 더한다.
 *    3-1. 만약 더한 값이 24 이상이라면 24를 뺀다.
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
			int currentTime = Integer.parseInt(st.nextToken()); // 현재 시각
			int elapsedTime = Integer.parseInt(st.nextToken()); // 경과 시간
			
			// 현재 시각에 경과 시간을 더한다
			int futureTime = currentTime + elapsedTime; // 계산한 시간
			
			// 만약 더한 값이 24 이상이라면 24를 뺀다
			if (futureTime >= 24) {
				futureTime -= 24;
			}
			
			sb.append("#").append(tc).append(" ").append(futureTime).append("\n");
		}
		System.out.println(sb);
	}
}