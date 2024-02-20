import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 회전 초밥 벨트에 놓인 접시의 수, 초밥의 가짓수, 연속해서 먹는 접시의 수, 쿠폰 번호를 입력받는다.
 * 2. 초밥들의 종류를 입력받는다.
 * 3. 한 위치부터 연속해서 먹는 접시의 수만큼을 살펴보아 중복된 번호가 있다면 패스한다.
 *    3-1. 슬라이딩 윈도우로 탐색한다.
 * 4. 중복되는 번호가 없는 경우가 여럿이라면, 쿠폰 번호와 겹치지 않는 경우가 있는지 확인한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static int plateCount; // 회전 초밥 벨트에 놓인 접시의 수
	public static int sushiCount; // 초밥의 가짓수
	public static int combo; // 연속해서 먹는 접시의 수
	public static int coupon; // 쿠폰 번호
	public static int[] conveyorBelt; // 회전 초밥 벨트
	public static int[] selectSushi; // 초밥을 먹을 수 있는 경우
	public static int maxHasSushi; // 먹을 수 있는 초밥의 가짓수의 최댓값
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		plateCount = Integer.parseInt(st.nextToken());
		sushiCount = Integer.parseInt(st.nextToken());
		combo = Integer.parseInt(st.nextToken());
		coupon = Integer.parseInt(st.nextToken());
		
		conveyorBelt = new int[plateCount];
		for (int idx = 0; idx < plateCount; idx++) {
			conveyorBelt[idx] = Integer.parseInt(br.readLine().trim());
		}
		
		int start = 0;
		int end = combo - 1;
		selectSushi = new int[sushiCount];
		
		// 회전 초밥 벨트에서 연속해서 먹는 접시의 개수만큼 선택한 초밥을 체크한다
		for (int idx = start; idx <= end; idx++) {
			selectSushi[conveyorBelt[idx] - 1] += 1;
		}
		
		// 쿠폰 번호도 체크한다
		selectSushi[coupon - 1] += 1;	
		
		// 회전 초밥 벨트의 처음 sushiCount만큼의 초밥 중 중복된 번호가 없는 초밥의 개수를 센다
		int hasSushi = 0;
		for (int idx = 0; idx < sushiCount; idx++) {
			if (selectSushi[idx] > 0) {
				hasSushi++;
			}
		}
		maxHasSushi = hasSushi;
		
		// 슬라이딩 윈도우로 탐색한다
		while (start < plateCount) {	
			// 시작 초밥의 개수를 하나 빼고
			// 빼면서 해당 초밥의 개수가 0이 되었다면(중복된 번호의 초밥이라 하나 빼도 같은 초밥이 또 있다면) hasSushi도 감소시킨다
			if (--selectSushi[conveyorBelt[start] - 1] == 0) {
				hasSushi--;
			}
			start++;
			
			// 마지막 다음 초밥의 개수를 하나 더하고
			// 더하면서 초밥 개수가 1이 되었다면 (기존에 없던 초밥 번호라면) hasSushi를 증가시킨다
			end = (end + 1) % plateCount;
			if (++selectSushi[conveyorBelt[end] - 1] == 1) {
				hasSushi++;
			}
			maxHasSushi = Math.max(maxHasSushi, hasSushi);
		}
		
		System.out.println(maxHasSushi);
	}
}