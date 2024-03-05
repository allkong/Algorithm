import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 여러 개의 매매가 중 가장 뒤에서부터 살펴본다.
 * 2. 맨 뒤의 매매가를 기준으로 앞 칸과 매매가를 비교한다.
 *    2-1. 자신보다 비교하는 물건의 매매가가 더 작으면 해당 원료를 구매한다.
 *         2-1-1. 자신의 매매가에서 비교하는 물건의 매매가를 뺀 값을 이익에 더한다.
 *    2-2. 자신보다 비교하는 물건의 매매가가 더 크면 기준을 해당 물건으로 바꾼다.
 * 3. 2번을 반복하여 최대 이익을 구한다.
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
			int count = Integer.parseInt(br.readLine().trim()); // 원료의 개수
			int[] price = new int[count]; // 원료의 매매가를 저장하는 배열
			long profit = 0; // 최대 이익
			
			st = new StringTokenizer(br.readLine().trim());
			for (int idx = 0; idx < count; idx++) {
				price[idx] = Integer.parseInt(st.nextToken());
			}
			
			int current = count - 1; // 맨 뒤의 원료를 기준으로 삼는다
			for (int idx = current - 1; idx >= 0; idx--) {
				if (price[current] < price[idx]) {
					// 자신보다 비교하는 물건의 매매가가 더 크면 기준을 해당 물건으로 바꾼다
					current = idx;
				} else {
					// 자신보다 비교하는 물건의 매매가가 더 작으면 해당 원료를 구매한다
					// 자신의 매매가에서 비교하는 물건의 매매가를 뺀 값을 이익에 더한다
					profit += price[current] - price[idx];
				}
			}
			sb.append("#").append(tc).append(" ").append(profit).append("\n");
		}
		System.out.println(sb);
	}
}