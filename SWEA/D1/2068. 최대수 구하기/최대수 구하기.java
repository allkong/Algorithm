import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. maxNum 변수를 0으로 초기화한다.
 * 3. 반복문으로 10개의 숫자를 입력받으면서 maxNum과 비교한다.
 *    3-1. 입력받은 숫자가 maxNum보다 크면 갱신한다. 
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
			int maxNum = 0;
			st = new StringTokenizer(br.readLine().trim());
			
			for (int idx = 0; idx < 10; idx ++) {
				maxNum = Math.max(maxNum, Integer.parseInt(st.nextToken()));
			}
			
			sb.append("#").append(tc).append(" ").append(maxNum).append("\n");
		}
		System.out.println(sb);
	}
}
