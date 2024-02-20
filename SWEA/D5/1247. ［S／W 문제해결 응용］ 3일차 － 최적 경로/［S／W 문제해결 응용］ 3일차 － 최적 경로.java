import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 회사에서 출발 -> 고객들 방문 -> 집 도착
 * DFS + 백트래킹
 * 
 * 1. 테스트 케이스를 입력받는다.
 * 2. 고객의 수를 입력받는다.
 * 3. 회사의 좌표, 집의 좌표, 고객들의 좌표를 입력받는다.
 * 4. 회사에서 출발하여 고객들의 좌표를 탐색한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static int customerCount; // 고객의 수
    public static int houseRow, houseCol; // 집의 좌표
    public static int[][] position; // 0번째는 회사의 좌표, 1번째부터는 고객들의 좌표
    public static boolean[] visited; // 고객들 방문 처리
    public static int totalDistance, minTotalDistance; // 경로의 이동 거리, 최단 경로의 이동 거리
    
    public static void selectRoute(int current, int searchIdx, int totalDistance) {
    	if (searchIdx == customerCount) {
    		// 마지막 고객에서 집까지의 거리
    		totalDistance += Math.abs(position[current][0] - houseRow) + Math.abs(position[current][1] - houseCol);
    		minTotalDistance = Math.min(minTotalDistance, totalDistance);
    		return;
    	}
    	
    	for (int next = 1; next <= customerCount; next++) {
    		if (!visited[next]) {
    			// 현재 고객에서 다음 고객까지의 거리 계산
    			int distance = Math.abs(position[current][0] - position[next][0]) + Math.abs(position[current][1] - position[next][1]);
    			
    			// 최단 경로가 아니면 더 탐색할 필요 없다
    			if (totalDistance + distance > minTotalDistance) {
    				return;
    			}
    			
    			// 다음 방문할 고객 방문 처리
    			visited[next] = true;
    			// 다음 방문할 고객 탐색
    			selectRoute(next, searchIdx + 1, totalDistance + distance);
    			// 다른 경로 탐색을 위해 방문 초기화
    			visited[next] = false;
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
        	customerCount = Integer.parseInt(br.readLine().trim());
        	position = new int[customerCount + 1][2];
        	
        	st = new StringTokenizer(br.readLine().trim());
        	
        	position[0][0] = Integer.parseInt(st.nextToken());
        	position[0][1] = Integer.parseInt(st.nextToken());
        	
        	houseRow = Integer.parseInt(st.nextToken());
        	houseCol = Integer.parseInt(st.nextToken());
        	
        	for (int idx = 1; idx <= customerCount; idx++) {
        		position[idx][0] = Integer.parseInt(st.nextToken());
        		position[idx][1] = Integer.parseInt(st.nextToken());
        	}
        	
        	minTotalDistance = Integer.MAX_VALUE;
        	visited = new boolean[customerCount + 1];
    		
        	// 회사에서 탐색 시작
    		selectRoute(0, 0, 0);
        	
        	sb.append("#").append(tc).append(" ").append(minTotalDistance).append("\n");
        }
        System.out.println(sb);
    }
}