import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 1월부터 12월까지의 각 월들이 며칠까지 있는지 배열에 저장한다.
 * 2. 입력받은 날짜에서의 월이 며칠까지 있는지 찾는다.
 * 3. 입력받은 날짜에서 일이 1과 2번에서 찾은 값 사이의 값인지 확인한다.
 *    3-1. 사이에 있는 값이 맞다면 날짜를 출력한다.
 *    3-2. 아니라면 -1을 출력한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		// 1월부터 12월까지의 각 월들이 며칠까지 있는지 배열에 저장한다
		int[] days = new int[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		for (int tc = 1; tc <= testCase; tc++) {
			String date = br.readLine().trim();
			
			sb.append("#").append(tc).append(" ");
			
			int month = Character.getNumericValue(date.charAt(4)) * 10 + Character.getNumericValue(date.charAt(5)); // 월
			int day = Character.getNumericValue(date.charAt(6)) * 10 + Character.getNumericValue(date.charAt(7)); // 일
			
			// 입력받은 날짜의 일이 1과 해당 월의 끝 값 사이인지 확인한다
			if (day >= 1 && day <= days[month]) {
				sb.append(date.charAt(0)).append(date.charAt(1)).append(date.charAt(2)).append(date.charAt(3)).append("/").append(String.format("%02d", month)).append("/").append(String.format("%02d", day)).append("\n");
			} else {
				sb.append(-1).append("\n");
			}
		}
		
		System.out.println(sb);
	}
}