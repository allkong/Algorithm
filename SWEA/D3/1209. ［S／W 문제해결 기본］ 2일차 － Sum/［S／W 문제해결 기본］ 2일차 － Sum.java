import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 테스트 케이스를 입력받는다.
 * 2. 2차원 숫자 배열을 입력받는다.
 * 3. 각 행의 합을 구해서 기존 최댓값과 비교한다.
 *    3-1. 기존 최댓값보다 더 크면 갱신한다.
 * 4. 각 열의 합을 구해서 기존 최댓값과 비교한다.
 *    4-1. 기존 최댓값보다 더 크면 갱신한다.
 * 5. 각 대각선의 합을 구해서 기존 최댓값과 비교한다.
 *    5-1. '\' 대각선 합(totalRightDiagonal): 행 번호와 열 번호가 같으면 더한다.
 *    5-2. '/' 대각선 합(totalLeftDiagonal): 열 번호가 ((SIZE - 1) - 행 번호)이면 더한다.
 *    5-3. 기존 최댓값보다 더 크면 갱신한다.
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static final int SIZE = 100;
	public static int maxValue; // 최댓 값
	public static int[][] numArr; // 숫자 배열
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		final int testCase = 10;
		
		for (int tc = 1; tc <= testCase; tc++) {			
			br.readLine();
			numArr = new int[SIZE][SIZE]; // 2차원 배열 생성
			maxValue = 0;
			
			for (int row = 0; row < SIZE; row++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int col = 0; col < SIZE; col++) {
					numArr[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 각 행의 합, 각 열의 합, 각 대각선의 합  중 최댓값을 구한다
			
			int totalRightDiagonal = 0; // '\' 대각선의 합
			int totalLeftDiagonal = 0; // '/' 대각선의 합
			
			for (int row = 0; row < SIZE; row++) {
				int totalRow = 0; // 한 행의 합
				int totalCol = 0; // 한 열의 합
				
				for (int col = 0; col < SIZE; col++) {
					totalRow += numArr[row][col];
					totalCol += numArr[col][row];
					
					// '\' 대각선 합(totalRightDiagonal): 행 번호와 열 번호가 같으면 더한다
					if (row == col) {
						totalRightDiagonal += numArr[row][col];
					}
					// '/' 대각선 합(totalLeftDiagonal): 열 번호가 ((SIZE - 1) - 행 번호)이면 더한다
					else if (col == SIZE - 1 - row) {
						totalLeftDiagonal += numArr[row][col];
					}
				}
				
				// 행의 합, 열의 합이 기존 최댓값보다 더 크면 갱신한다
				maxValue = Math.max(maxValue, totalRow);
				maxValue = Math.max(maxValue, totalCol);
			}
			// 대각선의 합이 기존 최댓값보다 더 크면 갱신한다
			maxValue = Math.max(maxValue, totalRightDiagonal);
			maxValue = Math.max(maxValue, totalLeftDiagonal);
			
			sb.append("#").append(tc).append(" ").append(maxValue).append("\n");
		}
		System.out.println(sb);
	}
}