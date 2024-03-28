import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 사람 수, 사람 네트워크의 인접 행렬을 한 줄에 입력받는다.
 *    2-1. 사람 네트워크의 인접 행렬에서 한 칸이 1이면 그대로 저장한다.
 *    2-2. 0이면서 행 번호와 열 번호가 같으면 0 그대로 저장한다.
 *    2-3. 0이면서 행 번호와 열 번호가 다르면 INF 값으로 저장한다.
 * 3. CC(i)는 노드 i로부터 노드 j까지의 최단 거리이다. (플로이드-워샬 알고리즘)
 * 4. 경로의 중간에 방문할 정점 개수를 1부터 사람 수만큼 반복한다.
 *    4-1. 출발 정점을 1부터 사람 수만큼 반복한다.
 *         4-1-1. 도착 정점을 1부터 사람 수만큼 반복한다.
 *                4-1-1-1. 4-1번 출발점에서 4-1-1번 도착점으로 가는 경로와 중간에 4번 정점을 경유하는 경로를 비교한다.
 *                4-1-1-2. 더 짧은 경로로 갱신한다.
 * 5. CC 값들 중 최솟값을 출력한다.
 */
public class Solution {
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	
	static int headCount; // 사람 수
	static int minCC; // CC 값들 중 최솟값
	static int[][] network; // 사람 네트워크의 인접행렬
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			headCount = Integer.parseInt(st.nextToken());
			network = new int[headCount][headCount];
			
			for (int row = 0; row < headCount; row++) {
				for (int col = 0; col < headCount; col++) {
					int node = Integer.parseInt(st.nextToken());
					// 0이면서 행 번호와 열 번호가 다르면 INF 값으로 저장한다
					// 그 외는 그대로 저장한다
					if (node == 0 && row != col) {
						network[row][col] = Integer.MAX_VALUE;
					} else {
						network[row][col] = node;
					}
				}
			}
			
			// mid: 경유 지점, start: 출발 지점, end: 도착 지점
			for (int mid = 0; mid < headCount; mid++) {
				for (int start = 0; start < headCount; start++) {
					if (start != mid) {
						for (int end = 0; end < headCount; end++) {
							if (end != mid && end != start) {
								int midRoute = network[start][mid] + network[mid][end]; // 중간 지점을 경유해가는 경로
								
								// 만약 중간 지점을 경유하는 방법이 INF일 경우 INF에 다른 값을 더하면 int를 넘어가 음수 값이 되기에
								// 다시 int의 max 값으로 조정한다.
								if (midRoute < 0) {
									midRoute = Integer.MAX_VALUE;
								}
								
								// 출발점에서 도착점으로 가는 경로와 그 중간에 mid 정점을 경유하는 경로를 비교한다
								network[start][end] = Integer.min(network[start][end], midRoute);
							}
						}
					}
				}
			}
			
			// CC 값들 중 최솟값을 구한다
			minCC = Integer.MAX_VALUE;
			for (int start = 0; start < headCount; start++) {
				int total = 0;
				for (int end = 0; end < headCount; end++) {
					total += network[start][end];
				}
				minCC = Integer.min(minCC, total);
			}
			
			sb.append("#").append(tc).append(" ").append(minCC).append("\n");
		}
		
		System.out.println(sb);
	}
}