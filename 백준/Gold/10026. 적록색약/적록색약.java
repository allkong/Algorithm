import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 배열의 크기를 입력받는다.
 * 2. R(빨강), G(초록), B(파랑) 중 하나를 색칠한 그림(grid) 배열을 입력받는다.
 * 3. 그림 배열을 탐색한다.
 * 4. 적록색약이 아닌 사람
 *    4-1. 탐색 시작 위치와 같은 색일 때만 탐색해서 방문 처리한다.
 *    4-2. 한 번(한 구역) 탐색할 때 탐색 횟수를 1 증가시킨다.
 * 5. 적록색약인 사람
 *    5-1. 그림 배열에서 초록색을 모두 빨간색으로 바꿔서 3~4번처럼 탐색한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static final int[] deltaRow = { -1, 1, 0, 0 };
	public static final int[] deltaCol = { 0, 0, -1, 1 };
	
	public static int size;
	public static char color;
	public static int normalCount;
	public static int abnormalCount;
	public static int nextRow, nextCol;
	
	public static char[][] grid;
	public static boolean[][] visited;
	
	public static void devideSection(int currentRow, int currentCol) {		
		visited[currentRow][currentCol] = true;
		color = grid[currentRow][currentCol];
		
		
		for (int direction = 0; direction < deltaRow.length; direction++) {
			nextRow = currentRow + deltaRow[direction];
			nextCol = currentCol + deltaCol[direction];
			
			if (nextRow < 0 || nextCol < 0 || nextRow >= size || nextCol >= size || visited[nextRow][nextCol]) {
				continue;
			}
			
			if (grid[nextRow][nextCol] == color) {
				devideSection(nextRow, nextCol);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		size = Integer.parseInt(br.readLine().trim());
		
		grid = new char[size][size];
		
		visited = new boolean[size][size];
		for (int row = 0; row < size; row++) {
			String line = br.readLine().trim();
			for (int col = 0; col < size; col++) {
				grid[row][col] = line.charAt(col);
			}
		}
		
		// 적록색약이 아닌 사람이 봤을 때의 구역의 개수를 구한다
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (!visited[row][col]) {
					devideSection(row, col);
					normalCount++;
				}
			}
		}
		
		// 적록색약인 사람은 R과 G의 차이를 느끼지 못하므로
		// G를 모두 R로 바꾼다
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (grid[row][col] == 'G') {
					grid[row][col] = 'R';
				}
			}
		}
		
		visited = new boolean[size][size];
		// 적록색약인 사람이 봤을 때의 구역의 개수를 구한다
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++) {
				if (!visited[row][col]) {
					devideSection(row, col);
					abnormalCount++;
				}
			}
		}
		
		sb.append(normalCount).append(" ").append(abnormalCount);
		System.out.println(sb);
	}
}