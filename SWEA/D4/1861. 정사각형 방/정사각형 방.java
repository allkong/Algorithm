import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 방 배열의 사이즈를 입력받는다.
 * 3. 방 번호를 입력받는다.
 *    3-1. 배열을 선언해서 배열에 저장한다.
 * 4. 2차원 방 배열의 모든 좌표를 시작 지점으로 삼아서 탐색한다.
 *    4-1. 반복문으로 시작 위치를 정한다.
 * 5. 상하좌우를 탐색해서 방 번호가 1 더 큰 방이 있으면 해당 좌표와 이동한 방 개수를 큐에 넣는다.
 * 6. 가장 여러 방을 많이 이동한 횟수(깊이)를 구한다.
 */
public class Solution {
    public static BufferedReader br;
    public static StringBuilder sb;
    public static StringTokenizer st;
    
    public static final int[] deltaRow = new int[] {-1, 1, 0, 0}; // 델타 배열(행)
    public static final int[] deltaCol = new int[] {0, 0, -1, 1}; // 델타 배열(열)
    
    public static int roomSize; // 방 배열의 사이즈
    public static int[][] rooms; // 방 번호를 저장하는 배열
    public static boolean[][] visited; // 방 방문 처리
    public static Queue<int[]> queue; // 이동할 좌표와 이동한 방 개수를 담는 큐
    public static int moveCount; // 방 이동 횟수
    public static int maxMoveCount; // 가장 방을 많이 탐색한 횟수
    public static int startRoom; // 최대로 이동할 수 있는 시작 방 번호
    
    public static int nextRow, nextCol;
    
    public static void bfs(int currentRow, int currentCol) {
    	// 이미 지나갔던 방이면 탐색하지 않는다
		if (visited[currentRow][currentCol]) {
			return;
		}
		
    	queue = new ArrayDeque<>();
    	queue.offer(new int[] {currentRow, currentCol}); // 탐색 시작점의 좌표
    	nextRow = 0; nextCol = 0;
    	moveCount = 1;
    	
    	while (!queue.isEmpty()) {
    		int[] temp = queue.poll();
    		currentRow = temp[0];
    		currentCol = temp[1];
    		
    		for (int direction = 0; direction < deltaRow.length; direction++) {
    			// 델타 배열을 이용해 다음 좌표로 이동한다
    			nextRow = currentRow + deltaRow[direction];
    			nextCol = currentCol + deltaCol[direction];
    			
    			// 다음 좌표가 범위를 벗어난다면 이동할 수 없다
    			if (nextRow < 0 || nextCol < 0 || nextRow >= roomSize || nextCol >= roomSize) {
    				continue;
    			}
    			
    			// 다음 방 번호가 현재 방 번호보다 1 더 크다면 다음 탐색하기 위해 큐에 넣는다
    			if (rooms[nextRow][nextCol] == rooms[currentRow][currentCol] + 1) {
    				queue.offer(new int[] {nextRow, nextCol});
    				visited[nextRow][nextCol] = true;
    				moveCount++;
    				break;
    			}
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= testCase; tc++) {
        	roomSize = Integer.parseInt(br.readLine().trim());
        	rooms = new int[roomSize][roomSize];
        	visited = new boolean[roomSize][roomSize];
            for (int row = 0; row < roomSize; row++) {
            	st = new StringTokenizer(br.readLine().trim());
            	for (int col = 0; col < roomSize; col++) {
            		rooms[row][col] = Integer.parseInt(st.nextToken());
            	}
            }
            maxMoveCount = 0;

            // 2차원 방 배열의 모든 좌표를 시작 지점으로 삼아서 탐색한다
            for (int row = 0; row < roomSize; row++) {
            	for (int col = 0; col < roomSize; col++) {
            		bfs(row, col);
            		// 현재 시작 좌표에서 이동한 방 횟수가 더 크거나
            		// 이동한 방 횟수는 같지만 방 시작 번호가 더 작다면
            		// 이동한 방 횟수를 갱신하고 시작 좌표를 현재 좌표로 갱신한다 
            		if (maxMoveCount < moveCount || (maxMoveCount == moveCount && startRoom > rooms[row][col])) {
            			maxMoveCount = moveCount;
            			startRoom = rooms[row][col];
            		}
            	}
            }
            sb.append("#").append(tc).append(" ").append(startRoom).append(" ").append(maxMoveCount).append("\n");
        }
        System.out.println(sb);
    }
}