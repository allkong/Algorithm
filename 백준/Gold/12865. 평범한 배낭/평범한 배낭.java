import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 물품의 수와 버틸 수 있는 무게를 입력받는다.
 * 2. 각 물품의 무게와 해당 물품의 가치를 입력받는다.
 * 3. 물품들을 하나씩 살펴보며 넣을 수 있는지 없는지 판단한다. (0-1 Knapsack)
 *    3-1. 배낭의 무게가 1일 때부터 제한 무게일 때까지 탐색한다.
 *    3-2. 탐색 중인 물품이 제한 무게보다 가볍거나 같으면, 배낭에 넣을 수 있다.
 *         3-2-1. 현재 물품을 넣기 전에 다른 물품(들)이 들어있을 때의 가치와
 *                이전 물품을 빼고 현재 물품을 넣었을 때의 가치를 비교한다. 
 *         3-2-2. 둘 중 더 높은 가치인 경우로 갱신한다.
 * 4. 3번 배열(dp)의 가장 마지막 칸 값을 출력한다.
 */
public class Main {
	static BufferedReader br;
	static StringTokenizer st;
	
	static final int WEIGHT = 0; // 무게
	static final int VALUE = 1; // 가치
	static int itemCount; // 물품의 수
	static int limitWeight; // 버틸 수 있는 무게
	static int[][] items; // 물건의 무게와 가치
	static int[][] knapsack; // 배낭에 들어 있는 물건들의 무게
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		// 1. 물품의 수와 버틸 수 있는 무게를 입력받는다.
		itemCount = Integer.parseInt(st.nextToken());
		limitWeight = Integer.parseInt(st.nextToken());
		items = new int[itemCount + 1][2];
		knapsack = new int[itemCount + 1][limitWeight + 1];
		
		// 2. 각 물품의 무게와 해당 물품의 가치를 입력받는다.
		for (int idx = 1; idx <= itemCount; idx++) {
			st = new StringTokenizer(br.readLine().trim());
			items[idx][WEIGHT] = Integer.parseInt(st.nextToken());
			items[idx][VALUE] = Integer.parseInt(st.nextToken());
		}
		
		// 3. 물품들을 하나씩 살펴보며 넣을 수 있는지 없는지 판단한다.
		for (int idx = 1; idx <= itemCount; idx++) {
			// 3-1. 배낭의 무게가 1일 때부터 제한 무게일 때까지 탐색한다.
			for (int weight = 1; weight <= limitWeight; weight++) {
				// 3-2. 탐색 중인 물품이 배낭 무게보다 가볍거나 같으면, 배낭에 넣을 수 있다.
				if (items[idx][WEIGHT] <= weight) {
					// 3-2-1. 현재 물품을 넣기 전에 다른 물품(들)이 들어있을 때의 가치와 이전 물품을 빼고 현재 물품을 넣었을 때의 가치를 비교한다.
					knapsack[idx][weight] = Integer.max(knapsack[idx - 1][weight], knapsack[idx - 1][weight - items[idx][WEIGHT]] + items[idx][VALUE]);
				} else {
					knapsack[idx][weight] = knapsack[idx - 1][weight];
				}
			}
		}
		
		// 4. 배열(dp)의 가장 마지막 칸 값을 출력한다.
		System.out.println(knapsack[itemCount][limitWeight]);
	}
}