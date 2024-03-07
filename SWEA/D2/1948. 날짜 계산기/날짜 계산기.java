import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 각 달의 날짜 누적합 배열을 만든다.
 * 2. 두 날짜의 차 + 1을 구한다.
 *    2-1. (두 번째 달 누적합-1에서 첫 번째 달 누적합-1을 뺀 값) + (두 번째 날에서 첫 번째 날을 뺀 값 + 1)
 *         2-1-1. 누적합은 예를 들어 3번째 달이면 3/31까지 보낸 일 수이기 때문에 2월까지의 누적합으로 계산해야 한다.
 *    2-2. 두 번째 날짜가 항상 첫 번째 날짜보다 더 크다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static final int[] DAYS = {0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365}; // 각 달의 날짜 누적합
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			
			int month1 = Integer.parseInt(st.nextToken());
			int day1 = Integer.parseInt(st.nextToken());
			int month2 = Integer.parseInt(st.nextToken());
			int day2 = Integer.parseInt(st.nextToken());
			
			int dayCount = DAYS[month2 - 1] - DAYS[month1 - 1] + day2 - day1 + 1;
			
			sb.append("#").append(tc).append(" ").append(dayCount).append("\n");
		}
		System.out.println(sb);
	}
}