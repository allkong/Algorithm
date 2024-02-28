import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 3개의 벽을 세운다.
 *    1-1. 반복문을 통해 3개의 벽을 세우고 아래 내용을 검증한다.
 * 2. bfs 탐색으로 바이러스를 전파한다.
 *    2-1. 탐색 칸이 바이러스(2)일 때, 상하좌우에 벽이 아닌 칸(0)이 있으면 바이러스가 퍼진다.
 * 3. 안전 영역의 크기를 체크한다.
 *    3-1. 2차원 배열에서 0인 칸을 모두 센다.
 */
public class Main {	
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int[] deltaRow = {-1, 1, 0, 0};
	public static final int[] deltaCol = {0, 0, -1, 1};
	
	public static int rowSize; // 행의 크기
	public static int colSize; // 열의 크기
	public static int maxTotalSafeZone; // 안전 영역의 최댓값
	public static int[][] lab; // 연구소 배열
	public static Queue<Position> queue;
	
	public static class Position {
		int row, col;
		
		public Position(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}
	
	/** 안전 영역의 칸 수를 세는 메소드 */
	public static void countSafeZone(int[][] afterLab) {
		int totalSafeZone = 0;
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (afterLab[row][col] == 0) {
					totalSafeZone++;
				}
			}
		}
		maxTotalSafeZone = Math.max(maxTotalSafeZone, totalSafeZone);
	}
	
	/** 바이러스를 전파하는 메소드 */
	public static void spreadVirus() {
		// 각 케이스마다 바이러스 전파를 해주기 위해 새로운 배열 선언
		int[][] afterLab = new int[rowSize][colSize];
		
		// lab을 afterLab으로 깊은 복사
		for (int row = 0; row < rowSize; row++) {
			afterLab[row] = lab[row].clone();
		}
		
		queue = new ArrayDeque<>();
		
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				if (lab[row][col] == 2) {
					queue.offer(new Position(row, col));
				}
			}
		}
		
		// 바이러스 전파
		while (!queue.isEmpty()) {
			Position current = queue.poll();
			
			for (int direction = 0; direction < deltaRow.length; direction++) {
				int nextRow = current.row + deltaRow[direction];
				int nextCol = current.col + deltaCol[direction];
				
				// 범위를 벗어나면 탐색하지 않는다
				if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize) {
					continue;
				}
				
				// 빈 칸이면 바이러스를 전파한다
				if (afterLab[nextRow][nextCol] == 0) {
					afterLab[nextRow][nextCol] = 2;
					queue.offer(new Position(nextRow, nextCol));
				}
			}
		}
		
		// 안전 영역의 칸을 세는 메소드 호출
		countSafeZone(afterLab);
	}
	
	/** 3개의 벽을 세우는 메소드 */
	public static void makeWalls(int wallCount) {
		// 3개의 벽이 모두 세워졌다면 바이러스를 전파하는 메소드 호출
		if (wallCount == 3) {
			spreadVirus();
			return;
		}
		
		for (int row = 0; row < rowSize; row++) {
			for (int col = 0; col < colSize; col++) {
				// 빈 칸이면 벽을 세운다
				if (lab[row][col] == 0) {
					lab[row][col] = 1;
					makeWalls(wallCount + 1); // 다음 벽을 세우러 간다
					lab[row][col] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		lab = new int[rowSize][colSize];
		
		for (int row = 0; row < rowSize; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < colSize; col++) {
				lab[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 벽을 세우는 메소드 호출
		makeWalls(0);
		// 안전 영역의 최대 크기 출력
		System.out.println(maxTotalSafeZone);
	}
}