import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. N(배열 크기의 지수에 해당하는 수), 타겟 탐색 위치를 입력받는다.
 *    1-1. 배열 크기는 2^N이다.
 * 2. 배열을 4등분해서 타겟 위치가 어디에 속하는지 탐색한다.
 * 3. Z 모양 순서로 0, 1, 2, 3칸 중에 0번째 칸이 아니라면 0번째 칸으로 이동한다.
 *    3-1. 이동한 횟수는 moveCount에 더한다.
 * 4. 타겟 위치가 속하는 부분 배열에서 2x2 배열이 될 때까지 2~3번을 반복한다.
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static int exponent; // 지수
	public static int size; // 배열의 길이
	public static int targetRow, targetCol; // 타겟 탐색 위치
	public static int moveCount; // 이동 횟수
	
	public static void searchZ(int row, int col, int size) {
		// 2칸보다 작아지면 탐색을 더 진행하지 않는다
		if (size == 1) {
			return;
		}
		// 왼쪽 위 칸(0)
		if (row < size / 2 && col < size / 2) { 
			searchZ(row, col, size / 2);
		}
		// 오른쪽 위 칸(1)
		else if (row < size / 2 && col >= size / 2) {
			// 4등분 중 한 칸만큼 이동하니까 전체(size * size)의 1/4을 이동 횟수에 더한다
			moveCount += size * size / 4;
			// 왼쪽으로 이동해야 하므로 행은 그대로고 열만 왼쪽(-)으로 이동한다
			searchZ(row, col - size / 2, size / 2);
		}
		// 왼쪽 아래 칸(2)
		else if (row >= size / 2 && col < size / 2) {
			// Z 모양의 두 번째 칸이므로 size * size / 4에 2를 곱한다 
			moveCount += (size * size / 4) * 2;
			// 위로 이동해야 하므로 행은 위(-)로 이동하고 열은 그대로이다
			searchZ(row - size / 2, col, size / 2);
		}
		// 오른쪽 아래 칸(3)
		else if (row >= size / 2 && col >= size / 2) {
			// Z 모양의 두 번째 칸이므로 size * size / 4에 3를 곱한다 
			moveCount += (size * size / 4) * 3;
			// 왼쪽 위로 이동해야 하므로 행은 위(-)로 이동하고 열도 왼쪽(-)으로 이동한다
			searchZ(row - size / 2, col - size / 2, size / 2);
		}
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		st = new StringTokenizer(br.readLine().trim());
		exponent = Integer.parseInt(st.nextToken());
		targetRow = Integer.parseInt(st.nextToken());
		targetCol = Integer.parseInt(st.nextToken());
		
		size = (int) Math.pow(2, exponent);
		
		moveCount = 0;
		
		// 타겟 위치를 시작으로 탐색하여 2*2 크기의 왼쪽 위 칸 배열이 될 때까지 쪼갠다
		searchZ(targetRow, targetCol, size);
		
		System.out.println(moveCount);
	}
}