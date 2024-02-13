import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 보드의 행 개수와 열 개수를 입력받는다.
 * 2. 보드에 적혀 있는 알파벳들을 입력받는다.
 *    2-1. 아스키코드를 활용해 알파벳에 65를 빼서 숫자로 저장한다. ex) A는 0으로 저장
 * 3. (0, 0) 칸에서 탐색을 시작한다.
 * 4. 현재 자리의 상하좌우를 탐색하여 방문하지 않은 알파벳이라면 다음 탐색을 진행한다.
 *    4-1. 알파벳 26개의 방문 처리 배열을 만든다.
 *    4-2. 2-1번에서 알파벳을 숫자로 저장했으니 해당 숫자를 index로 사용하면 된다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int[] deltaRow = {-1, 1, 0, 0}; // 상하좌우 행
	public static final int[] deltaCol = {0, 0, -1, 1}; // 상하좌우 열
	public static final int alphabetCount = 26; // 알파벳 개수	
	
	public static int rowCount; // 행의 개수
	public static int colCount; // 열의 개수
	public static int[][] board; // 알파벳(숫자)을 저장할 보드 배열
	public static boolean[] visited; // 알파벳 방문 처리
	public static int moveCount; // 말이 이동할 수 있는 횟수
	public static int maxMoveCount; // 말이 최대로 이동할 수 있는 횟수
	
	public static void dfs(int currentRow, int currentCol, int moveCount) {
		maxMoveCount = Math.max(maxMoveCount, moveCount);
		
		// 현재 자리의 알파벳을 방문 처리
		visited[board[currentRow][currentCol]] = true;
		
		// 현재 자리의 상하좌우를 탐색하여 방문하지 않은 알파벳이라면 다음 탐색을 진행한다
		for (int direction = 0; direction < deltaRow.length; direction++) {
			int nextRow = currentRow + deltaRow[direction];
			int nextCol = currentCol + deltaCol[direction];
			
			// 보드 배열의 범위에서 벗어난다면 탐색하지 않는다
			if (nextRow < 0 || nextCol < 0 || nextRow >= rowCount || nextCol >= colCount) {
				continue;
			}
			
			// 현재 알파벳과 같은 알파벳이라면 탐색하지 않는다
			// 즉, 이미 방문한 알파벳이면 탐색하지 않는다
			if (visited[board[nextRow][nextCol]]) {
				continue;
			}
			
			dfs(nextRow, nextCol, moveCount + 1);
		}
		
		visited[board[currentRow][currentCol]] = false;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		rowCount = Integer.parseInt(st.nextToken());
		colCount = Integer.parseInt(st.nextToken());
		
		board = new int[rowCount][colCount];
		for (int row = 0; row < rowCount; row++) {
			String line = br.readLine().trim();
			for (int col = 0; col < colCount; col++) {
				// 아스키코드를 활용해 알파벳에 65를 빼서 숫자로 저장한다
				board[row][col] = line.charAt(col) - 65;
			}
		}
		
		visited = new boolean[alphabetCount];
		maxMoveCount = 0;
		
		dfs(0, 0, 1);
		System.out.println(maxMoveCount);
	}
}