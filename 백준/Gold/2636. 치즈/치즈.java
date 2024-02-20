import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 1. 행의 크기, 열의 크기를 입력받는다.
 * 2. 치즈 배열을 입력받는다.
 *    2-1. 치즈가 없는 칸은 0, 있는 칸은 1
 * 3. 치즈 배열을 bfs 탐색한다.
 * 4. 치즈가 없는 칸이면 다음 탐색을 위해 queue에 넣는다.
 * 5. 치즈가 있는 칸이면 치즈의 가장자리이므로 queue에 넣지 않는다.
 *    4-1. 치즈의 가장자리를 탐색하면 안쪽 치즈를 녹이게 되기 때문이다.
 *    4-2. 녹인 치즈 개수를 1 증가시킨다.
 * 6. 치즈 녹인 개수가 0이 될 대까지 3~5번을 반복한다.
 * 7. bfs 탐색을 한 번 할 때마다 시간이 한 시간 걸린다.
 * 8. 치즈가 모두 녹기 한 시간 전에 남아있는 치즈조각 칸의 개수는 마지막 이전 탐색에서 녹인 치즈의 개수이다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int[] deltaRow = new int[] {-1, 1, 0, 0};
	public static final int[] deltaCol = new int[] {0, 0, -1, 1};
	
	public static int rowSize; // 행의 크기
	public static int colSize; // 열의 크기
	public static int hour; // 치즈가 모두 녹아서 없어지는 데 걸리는 시간
	public static int meltingCount; // 치즈가 모두 녹기 한 시간 전에 남아있는 치즈조각이 놓여 있는 칸의 개수
	public static int nextRow, nextCol;
	
	public static int[][] cheese; // 치즈 배열
	public static boolean[][] visited; // 치즈 배열 방문 처리
	public static List<Integer> melting; // 녹인 치즈의 개수를 담는 배열
	public static Queue<int[]> queue; // 다음 탐색 좌표를 저장할 큐
	
	public static void meltCheese(int currentRow, int currentCol) {
		if (visited[currentRow][currentCol]) {
			return;
		}
		
		queue = new ArrayDeque<>();
		queue.offer(new int[] {currentRow, currentCol});
		nextRow = 0; nextCol = 0;
		meltingCount = 0;
		
		while (!queue.isEmpty()) {
			int[] temp = queue.poll();
			currentRow = temp[0];
			currentCol = temp[1];
			
			for (int direction = 0; direction < deltaRow.length; direction++) {
				nextRow = currentRow + deltaRow[direction];
				nextCol = currentCol + deltaCol[direction];
				
				// 범위를 벗어나거나 이미 방문한 칸이면 탐색하지 않는다
				// 방문한 칸을 또 탐색하면 치즈 녹인 자리를 탐색하게 될 수 있다
				// -> 안쪽 치즈를 녹이게 된다
				if (nextRow < 0 || nextCol < 0 || nextRow >= rowSize || nextCol >= colSize || visited[nextRow][nextCol]) {
					continue;
				}
				
				visited[nextRow][nextCol] = true;
				
				// 치즈가 없는 칸이면 다음 탐색을 위해 queue에 넣는다
				if (cheese[nextRow][nextCol] == 0) {
					queue.offer(new int[] {nextRow, nextCol});
				}
				// 치즈가 있는 칸이면 치즈의 가장자리이므로 queue에 넣지 않는다
				else {
					// 치즈를 녹인다
					cheese[nextRow][nextCol] = 0;
					meltingCount++;
				}
			}
		}
		melting.add(meltingCount);
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine().trim());
		rowSize = Integer.parseInt(st.nextToken());
		colSize = Integer.parseInt(st.nextToken());
		
		cheese = new int[rowSize][colSize];
		melting = new ArrayList<>();
		
		for (int row = 0; row < rowSize; row++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int col = 0; col < colSize; col++) {
				cheese[row][col] = Integer.parseInt(st.nextToken());
			}
		}
		
		while (true) {
			visited = new boolean[rowSize][colSize];
			meltCheese(0, 0);
			
			// 치즈를 다 녹였다면 종료한다
			if (meltingCount == 0) {
				System.out.println(hour);
				System.out.println(melting.get(melting.size() - 2));
				break;
			}
			
			// 탐색을 한 번 할 때마다 한 시간 걸린다
			hour += 1;
		}
	}
}