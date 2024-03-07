import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 밑에 해당하는 상수 숫자들을 저장하는 배열을 선언한다.
 * 2. 지수에 해당하는 숫자를 저장할 배열을 선언한다.
 * 3. 소인수분해를 할 숫자를 입력받는다.
 * 4. 입력받은 숫자를 밑으로 나눈다.
 *    4-1. 나누어 떨어지면 해당 인덱스의 지수를 1 증가시킨다.
 *    4-2. 나누어 떨어지지 않은 다음 밑으로 넘어간다.
 * 5. 4번을 밑을 모두 탐색할 때까지 반복하여 5개의 밑의 지수를 구한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static final int[] base = {2, 3, 5, 7, 11}; // 밑
	public static int[] power; // 지수
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			int num = Integer.parseInt(br.readLine().trim());
			power = new int[base.length];
			
			int baseIdx = 0;
			while (baseIdx < base.length) {
				if (num % base[baseIdx] == 0) {
					num /= base[baseIdx];
					power[baseIdx]++;
				} else {
					baseIdx++;
				}
			}
			
			sb.append("#").append(tc).append(" ");
			for (int idx = 0; idx < power.length; idx++) {
				sb.append(power[idx]).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}