import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 최장 증가 부분 수열의 길이 계산
 * 1. 테스트 케이스를 입력받는다.
 * 2. 수열의 길이를 입력받는다.
 * 3. 수열을 입력받는다.
 * 4. LIS 1차원 배열을 선언한다.
 * 5. 수열의 길이만큼 반복문을 돌린다.
 *    5-1. 배열의 값을 1로 초기화한다.
 *    5-2. 현재 수열 길이 - 1만큼 반복문을 돌린다.
 *         5-2-1. 수열의 숫자가 직전 숫자보다 작으면서 직전까지의 최적해보다 현재 숫자를 뒤에 붙였을 때의 최적해 + 1이 더 크다면 갱신한다.
 * 6. LIS 배열에서 가장 큰 값을 출력한다.
 */
public class Solution {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int length; // 수열의 길이
	static int maxLIS; // LIS 배열에서 가장 큰 값 -> 최장증가부분수열의 길이
	static int[] sequence; // 수열 
	static int[] LIS; // 최장증가부분수열
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			length = Integer.parseInt(br.readLine().trim());
			sequence = new int[length + 1];
			LIS = new int[length + 1];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 1; idx <= length; idx++) {
				sequence[idx] = Integer.parseInt(st.nextToken());
			}
			
			// 수열의 길이만큼 반복문을 돌린다
			// prev: 이전, 비교 "기준"
			// current: 현재 비교 대상
			for (int prev = 1; prev <= length; prev++) {
				LIS[prev] = 1; // 배열의 값을 1로 초기화한다
				
				// 현재 수열 길이 - 1만큼 반복문을 돌린다
				for (int current = 1; current < prev; current++) {
					// 수열의 숫자가 직전 숫자보다 작으면서
					// 직전까지의 최적해보다 현재 숫자를 뒤에 붙였을 때의 최적해 + 1이 더 크다면 갱신한다
					if (sequence[prev] > sequence[current] && LIS[prev] < LIS[current] + 1) {
						LIS[prev] = LIS[current] + 1;
					}
				}
			}
			
			// LIS 배열에서 가장 큰 값을 출력한다
			maxLIS = 0;
			for (int idx = 1; idx <= length; idx++) {
				maxLIS = Integer.max(maxLIS, LIS[idx]);
			}
			
			sb.append("#").append(tc).append(" ").append(maxLIS).append("\n");
		}
		System.out.println(sb);
	}
}