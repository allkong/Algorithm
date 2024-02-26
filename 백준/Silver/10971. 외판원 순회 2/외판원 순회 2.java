import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. n개의 도시를 다른 순서로 지나가는 경로들을 찾는다.
 *    1-1. nPn: n개의 도시 중 n개의 도시를 선택한다. (순서가 다 다르게)
 * 2. 1-1에서 구한 경로의 비용을 구한다.
 * 3. 가장 적게 든 비용을 저장한다. 
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static int cityCount; // 도시의 수
	public static int minTotalCost; // 모든 도시를 방문하기 위한 최소 비용
	public static int[][] cityCost; // 도시 이동 비용
	public static int[] selected; // 선택한 도시
	public static boolean[] visited; // 도시 방문 여부
	
	public static void selectCity(int selectIdx) {
		// 도시 순서를 다 선택했다면 이동 비용을 구한다
		if (selectIdx == cityCount) {
			int totalCost = 0;
			
			for (int idx = 0; idx < cityCount; idx++) {
				// 한 도시에서 다음 도시로 이동하는 도시 이동 비용을 구한다
				// 마지막 도시에서 처음 도시로 돌아오는 비용까지 더한다
				int cost = cityCost[selected[idx]][selected[(idx + 1) % cityCount]];
				
				// 0이면 갈 수 없는 경우이다
				if (cost == 0) {
					return;
				}
				
				totalCost += cost;
			}
			
			minTotalCost = Math.min(minTotalCost, totalCost);
			return;
		}
		
		for (int cityIdx = 0; cityIdx < cityCount; cityIdx++) {
			if (visited[cityIdx]) {
				continue;
			}
			
			visited[cityIdx] = true;
			selected[selectIdx] = cityIdx;
			selectCity(selectIdx + 1);
			visited[cityIdx] = false;
		}
	}
		
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		cityCount = Integer.parseInt(br.readLine().trim());
		
		cityCost = new int[cityCount][cityCount];
		selected = new int[cityCount];
		visited = new boolean[cityCount];
		minTotalCost = Integer.MAX_VALUE;
		
		for (int row = 0; row < cityCount; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < cityCount; col++) {
				cityCost[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		selectCity(0);
		System.out.println(minTotalCost);
	}
}