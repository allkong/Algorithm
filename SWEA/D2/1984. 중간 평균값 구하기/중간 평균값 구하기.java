import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 10개의 숫자를 입력받아 배열에 저장한다.
 * 2. 숫자 배열을 정렬한다.
 * 3. 1번째 인덱스부터 n-2번째 인덱스까지의 합계를 구한다.
 * 4. 3번에서 구한 합계에 8(0번째, n-1번째 제외)을 나눠 절사평균을 구한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static final int SIZE = 10; // 배열 길이
	public static int[] nums; // 숫자 배열

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			nums = new int [SIZE];
			
			for (int idx = 0; idx < SIZE; idx++) {
				nums[idx] = Integer.parseInt(st.nextToken());
			}
			
			// 배열을 정렬한다
			Arrays.sort(nums);
			
			// 1번째 인덱스부터 n-2번째 인덱스까지의 합계를 구한다
			float total = 0;
			for (int idx = 1; idx < SIZE - 1; idx++) {
				total += nums[idx];
			}
			
			sb.append("#").append(tc).append(" ").append(Math.round(total / (SIZE - 2))).append("\n");
		}
		System.out.println(sb);
	}
}