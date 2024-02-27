import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * DP 풀이
 * 1. 기본적으로 현재 횟수는 바로 전 숫자 횟수보다 +1이다.
 *    1-1. 3번 연산(1을 뺀다)을 실행했을 경우이다.
 * 2. 3의 배수이면 1번 연산(3으로 나눈다)을 실행한다.
 *    2-1. 3으로 나눈 숫자 횟수보다 +1이다.
 * 3. 2의 배수이면 2번 연산(2로 나눈다)을 실행한다.
 *    3-1. 2로 나눈 숫자 횟수보다 +1이다.
 */
public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine().trim());
		int[] count = new int[num + 1];
		
		for (int idx = 2; idx <= num; idx++) {
			count[idx] = count[idx - 1] + 1;
			
			if (idx % 3 == 0) {
				count[idx] = Math.min(count[idx], count[idx / 3] + 1);
			}
			
			if (idx % 2 == 0) {
				count[idx] = Math.min(count[idx], count[idx / 2] + 1);
			}
		}
		System.out.println(count[num]);
	}
}