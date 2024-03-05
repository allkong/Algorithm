import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 여러 개의 숫자를 입력받아 그 합을 구한다.
 *    2-1. total 변수를 0으로 초기화한다.
 *         2-1-1. 평균을 구해야 하기 때문에 잃어버리는 값이 없도록 double로 선언한다.
 *    2-2. 숫자를 입력받을 때마다 해당 숫자를 total에 더한다.
 * 3. 숫자들의 합(total)에 숫자 개수(10)를 나누어 반올림하여 출력한다.
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
			double total = 0;
			st = new StringTokenizer(br.readLine().trim());
			
			for (int idx = 0; idx < 10; idx++) {
				int num = Integer.parseInt(st.nextToken());
				total += num;
			}
			sb.append("#").append(tc).append(" ").append(Math.round(total / 10)).append("\n");
		}
		System.out.println(sb);
	}
}
