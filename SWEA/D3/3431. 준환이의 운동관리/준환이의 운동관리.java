import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 최소 운동 시간, 최대 운동 시간, 실제로 운동한 시간을 입력받는다.
 * 3. 실제로 운동한 시간이 최대로 운동한 시간보다 크다면 -1을 출력한다.
 * 4. 실제로 운동한 시간이 최소 운동 시간과 최대 운동 시간 사이라면 0을 출력한다.
 * 5. 실제로 운동한 시간이 최소 운동 시간보다 작다면 최소 운동 시간에서 실제로 운동한 시간을 뺀 값을 출력한다.
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
			
			int minTime = Integer.parseInt(st.nextToken()); // 최소 운동 시간
			int maxTime = Integer.parseInt(st.nextToken()); // 최대 운동 시간
			int exerciseTime = Integer.parseInt(st.nextToken()); // 실제로 운동한 시간
			
			sb.append("#").append(tc).append(" ");
			// 실제로 운동한 시간이 최대로 운동한 시간보다 크다면 -1을 출력한다
			if (exerciseTime > maxTime) {
				sb.append(-1);
			}
			// 실제로 운동한 시간이 최소 운동 시간보다 작다면 최소 운동 시간에서 실제로 운동한 시간을 뺀 값을 출력한다
			else if (exerciseTime < minTime) {
				sb.append(minTime - exerciseTime);
			}
			// 실제로 운동한 시간이 최소 운동 시간과 최대 운동 시간 사이라면 0을 출력한다
			else {
				sb.append(0);
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}