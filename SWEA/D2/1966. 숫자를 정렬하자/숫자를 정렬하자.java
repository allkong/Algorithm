import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 여러 개의 숫자를 입력받아 배열에 저장한다.
 * 2. 배열을 정렬한다.
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
			int size = Integer.parseInt(br.readLine().trim());
			int[] nums = new int[size];
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < size; idx++) {
				nums[idx] = Integer.parseInt(st.nextToken());
			}
			
			// 배열을 정렬한다
			Arrays.sort(nums);
			
			sb.append("#").append(tc).append(" ");
			for (int idx = 0; idx < size; idx++) {
				sb.append(nums[idx]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}