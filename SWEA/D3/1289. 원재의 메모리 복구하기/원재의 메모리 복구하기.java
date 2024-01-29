import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 테스트 케이스만큼 반복하여 원래 메모리 값을 입력받는다.
 * 3. 초기화 상태의 메모리 값을 담는 배열을 선언한다.
 * 4. 초기화 상태의 메모리 값과 원래 메모리 값을 한자리씩 비교한다.
 *    4-1. 값이 다르면 현재 위치부터 끝까지 바꾼다.
 *    4-2.          수정 횟수를 증가시킨다.
 */
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 테스트 케이스를 입력받는다
		int T = Integer.parseInt(br.readLine());
		
		// 테스트 케이스만큼 반복한다
		for (int tc = 1; tc < T + 1; tc++) {
			// 원래 메모리 값을 입력받는다
			String originMemory = br.readLine();
			// 초기화 상태의 메모리 값을 담는 배열을 선언한다
			// 배열의 길이는 원래 메모리 값의 길이와 같다
			int[] initMemory = new int[originMemory.length()];
			// 변경 횟수
			int count = 0;
			
			// 초기화 상태의 메모리 값과 원래 메모리 값을 한자리씩 비교한다
			for (int idx = 0; idx < originMemory.length(); idx++) {
				// 값이 다르면 수행한다
				// initMemory는 배열이라 숫자가 담겨있지만
				// originMemory는 문자열에서 문자를 추출한 것이기 때문에 숫자로 바꿔주어야 한다
				if (initMemory[idx] != Character.getNumericValue(originMemory.charAt(idx))) {
					// 현재 위치부터 끝까지 바꾼다
					for (int change = idx; change < originMemory.length(); change++) {
						initMemory[change] = Character.getNumericValue(originMemory.charAt(idx)); 
					}
					// 변경했으면 수정 횟수를 증가시킨다
					count += 1;
				}
			}
			System.out.println("#" + tc + " " + count);
		}
	}
}