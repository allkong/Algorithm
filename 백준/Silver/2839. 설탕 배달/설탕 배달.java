import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 배달해야 하는 무게(kg)를 입력받는다.
 * 2. 담아야 하는 설탕의 무게가 5의 배수이면 몫만큼 봉지 개수를 더하고 종료한다.
 * 3. 2번에 해당하지 않는다면 3킬로그램 봉지를 챙기고 봉지 개수를 1 더한 다음 다시 2번을 체크한다.
 * 4. 2~3번을 반복하고 만약 담아야 하는 설탕의 무게가 0 미만이 되었다면 -1을 출력하고 종료한다.
 */
public class Main {
	public static BufferedReader br;
	
	public static int sugarWeight; // 설탕 무게
	public static int bagCount; // 봉지 개수
	public static boolean isPossible; // 정확하게 설탕 무게를 맞출 수 있는지 체크

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		sugarWeight = Integer.parseInt(br.readLine().trim());
		bagCount = 0;
		isPossible = false;
		
		while (sugarWeight >= 0) {
			// 담아야 하는 설탕의 무게가 5의 배수이면 몫만큼 봉지 개수를 더하고 종료한다
			if (sugarWeight % 5 == 0) {
				bagCount += sugarWeight / 5;
				isPossible = true;
				break;
			}
			// 그렇지 않으면 3킬로그램 봉지를 챙기고 봉지 개수를 1 더한다
			sugarWeight -= 3;
			bagCount++;
		}
		
		if (isPossible) {
			System.out.println(bagCount);
		} else {
			System.out.println(-1);
		}
	}
}