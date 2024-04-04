import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {
	static BufferedReader br;
    static StringBuilder sb;
    
    static final int INF = Integer.MAX_VALUE;
    static final int[] deltaRow = {-1, 1, 0, 0};
    static final int[] deltaCol = {0, 0, -1, 1};
    
    static int size; // 배열의 크기
    static int[][] map; // 지도 배열
    static int[][] time; // 특정 칸까지 걸린 시간을 저장하는 배열
    
    static class Point {
    	int row, col;

		Point(int row, int col) {
			this.row = row;
			this.col = col;
		}
    }
    
    static void move(int startRow, int startCol) {
    	Queue<Point> queue = new ArrayDeque<>();
    	queue.offer(new Point(startRow, startCol));
    	// 시작 위치는 무조건 0이다
    	time[startRow][startCol] = 0;
    	
    	while (!queue.isEmpty()) {
    		Point current = queue.poll();
    		
    		for (int direction = 0; direction < deltaRow.length; direction++) {
    			int nextRow = current.row + deltaRow[direction];
    			int nextCol = current.col + deltaCol[direction];
    			
    			// 범위를 벗어나면 탐색하지 않는다
    			if (nextRow < 0 || nextCol < 0 || nextRow >= size || nextCol >= size) {
    				continue;
    			}
    			
    			// 현재까지 걸린 시간에 다음 칸의 시간을 더한 값이 다음 칸의 이전 경로에서 걸린 시간보다 더 짧다면 갱신한다
    			if (time[current.row][current.col] + map[nextRow][nextCol] < time[nextRow][nextCol]) {
    				time[nextRow][nextCol] = time[current.row][current.col] + map[nextRow][nextCol];
    				queue.offer(new Point(nextRow, nextCol));
    			}
    		}
    	}
    }
    
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int testCase = Integer.parseInt(br.readLine().trim());
        
        for (int tc = 1; tc <= testCase; tc++) {
        	size = Integer.parseInt(br.readLine().trim());
        	map = new int[size][size];
        	// time 배열을 dp 배열로 써서 각 칸까지 걸린 시간을 저장한다
        	time = new int[size][size];
        	
        	for (int row = 0; row < size; row++) {
        		String line = br.readLine().trim();
        		for (int col = 0; col < size; col++) {
        			map[row][col] = Character.getNumericValue(line.charAt(col));
        			time[row][col] = INF;
        		}
        	}
        	
        	move(0, 0);
        	// 마지막 칸(도착지)를 출력한다
        	sb.append("#").append(tc).append(" ").append(time[size - 1][size - 1]).append("\n");
        }
        System.out.println(sb);
	}
}