import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 거슬러 주어야 할 금액을 입력받는다.
 * 2. 해당 금액을 돈의 최소 개수로 거슬러 줘야 한다.
 *    2-1. 금액이 5만원 권으로 나눌 수 있다면 5만원 권으로 나눈 몫을 구하고 나머지 값을 구한다.
 *    2-2. 나머지 값으로 1만원권으로 나눌 수 있다면 3만원 권으로 나눈 몫을 구하고 나머지 값을 구한다.
 *    2-3. 위 내용을 5만원 권부터 10원까지 반복한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static final int[] changeType = {50000, 10000, 5000, 1000, 500, 100, 50, 10}; // 지폐와 동전의 종류
	public static int[] changeCount; // 각 지폐 혹은 동전의 거슬러 줘야 하는 개수

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int money = Integer.parseInt(br.readLine().trim());
			changeCount = new int[changeType.length];
			
			for (int idx = 0; idx < changeType.length; idx++) {
				// 금액이 현재 계산 중인 지폐나 동전으로 나눌 수 있다면 나눈 몫을 구하고 나머지 값을 구한다
				if (money / changeType[idx] > 0) {
					changeCount[idx] += money / changeType[idx]; // 몫
					money %= changeType[idx]; // 나머지
				}
			}
			
			sb.append("#").append(tc).append("\n");
			for (int idx = 0; idx < changeCount.length; idx++) {
				sb.append(changeCount[idx]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}