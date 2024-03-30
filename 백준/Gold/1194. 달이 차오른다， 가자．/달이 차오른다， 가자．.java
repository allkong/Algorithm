import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br;
    static StringTokenizer st;
    
    static final int[] deltaRow = {-1, 1, 0, 0};
    static final int[] deltaCol = {0, 0, -1, 1};
    static final int MAX_KEY = 1 << 'f'; // 열쇠 비트 마스킹 최댓값
    
    static int rowSize; // 미로의 행 크기
    static int colSize; // 미로의 열 크기
    static char[][] maze; // 미로 배열
    static boolean[][][] visited; // 방문 처리 배열
    
    static class Position {
    	int row, col, moveCount, key;
    	
    	Position (int row, int col, int moveCount, int key) {
    		this.row = row; // 현재 위치
    		this.col = col;
    		this.moveCount = moveCount; // 현재 위치까지의 이동 횟수
    		this.key = key; // 현재 위치까지 획득한 열쇠 정보
    	}
    }
    
    static int escapeMaze(Position start) {
    	Queue<Position> queue = new ArrayDeque<>();
    	queue.offer(start);
    	
    	while (!queue.isEmpty()) {
    		Position current = queue.poll();
    		
    		for (int direction = 0; direction < deltaRow.length; direction++) {
    			int nextRow = current.row + deltaRow[direction];
    			int nextCol = current.col + deltaCol[direction];
    			
    			// 범위를 벗어나면 탐색하지 않는다
    			if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize) {
    				continue;
    			}
    			
    			// 벽이면 이동할 수 없다
    			if (maze[nextRow][nextCol] == '#') {
    				continue;
    			}
    			
    			// 현재 가지고 있는 열쇠를 들고 이미 지나간 곳이면 또 갈 필요 없다
    			if (visited[nextRow][nextCol][current.key]) {
    				continue;
    			}
    			
    			// 출구면 탈출한다
    			if (maze[nextRow][nextCol] == '1') {
    				// 시작 위치부터 출구까지의 이동 횟수를 반환한다
    				return current.moveCount + 1;
    			}
    			
    			// 열쇠면 열쇠 획득 표시를 하고 이동한다
    			if (maze[nextRow][nextCol] >= 'a' && maze[nextRow][nextCol] <= 'f') {
    				// 획득한 열쇠를 표시하고 이동 횟수를 1 증가시켜 queue에 담는다
    				int nextKey = current.key | 1 << (maze[nextRow][nextCol] - 'a');
    				queue.offer(new Position(nextRow, nextCol, current.moveCount + 1, nextKey));
    				visited[nextRow][nextCol][nextKey] = true;
    			}
    			
    			// 문이면 현재 맞는 열쇠가 있는지 확인한다
    			else if (maze[nextRow][nextCol] >= 'A' && maze[nextRow][nextCol] <= 'F') {
    				// 현재 문에 맞는 열쇠가 있는지 확인한다
    				int hasKey = current.key & 1 << (maze[nextRow][nextCol] - 'A');
    				// 현재 문제 맞는 열쇠가 없다면 일단 건너뛴다
    				if (hasKey == 0) {
    					continue;
    				}
    				// 현재 문에 맞는 열쇠가 있다면 이동한다
    				queue.offer(new Position(nextRow, nextCol, current.moveCount + 1, current.key));
    				visited[nextRow][nextCol][current.key] = true;
    			}
    			
    			// 빈 칸이면 이동한다 (혹은 민식이의 처음 위치)
    			else {
    				queue.offer(new Position(nextRow, nextCol, current.moveCount + 1, current.key));
    				visited[nextRow][nextCol][current.key] = true;
    			}
    		}
    	}
    	
    	// 출구를 찾지 못했다면 -1을 반환한다
    	return -1;
    }
    
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine().trim());
        
        rowSize = Integer.parseInt(st.nextToken());
        colSize = Integer.parseInt(st.nextToken());
        maze = new char[rowSize][colSize];
        visited = new boolean[rowSize][colSize][MAX_KEY];
        Position start = null;
        
        for (int row = 0; row < rowSize; row++) {
        	String line = br.readLine().trim();
        	for (int col = 0; col < colSize; col++) {
        		maze[row][col] = line.charAt(col);
        		
        		// 민식이의 처음 위치를 찾는다
        		if (maze[row][col] == '0') {
        			start = new Position(row, col, 0, 0);
        		}
        	}
        }
        
        int minMoveCount = escapeMaze(start);
        System.out.println(minMoveCount);
    }    
}