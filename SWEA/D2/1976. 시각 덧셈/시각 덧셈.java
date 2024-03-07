import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 시 분으로 이루어진 시각 2개를 입력받는다.
 * 2. 시를 분 단위로 바꿔서 두 시각을 더한다.
 *    2-1. 시를 분 단위로 변환: 시 * 60 + 분
 * 3. 계산한 시간(분)을 다시 시와 분으로 계산한다.
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
			int hour1 = Integer.parseInt(st.nextToken());
			int min1 = Integer.parseInt(st.nextToken());
			int hour2 = Integer.parseInt(st.nextToken());
			int min2 = Integer.parseInt(st.nextToken());
			
			// 시간을 분 단위로 변환한다
			int time1 = hour1 * 60 + min1;
			int time2 = hour2 * 60 + min2;
			
			int totalTime = time1 + time2;
			
			// 다시 시간을 시와 분으로 계산한다.
			int hour = totalTime / 60;
			int min = totalTime % 60;
			
			// 시각은 12시간제이므로 hour가 12보다 크다면 12를 빼준다
			sb.append("#").append(tc).append(" ").append(hour > 12 ? hour - 12 : hour).append(" ").append(min).append("\n");
		}
		System.out.println(sb);
	}
}