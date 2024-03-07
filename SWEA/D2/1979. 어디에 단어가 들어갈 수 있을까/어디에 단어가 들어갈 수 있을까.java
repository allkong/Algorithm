import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 배열의 크기와 단어의 길이를 입력받는다.
 * 2. 배열의 행을 한 행씩 검사한다.
 *    2-1. 연속으로 단어의 길이만큼 이어지는 자리가 있는지 확인한다.
 * 3. 배열의 열을 한 열씩 검사한다.
 *    3-1. 연속으로 단어의 길이만큼 이어지는 자리가 있는지 확인한다. 
 */
public class Solution {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;
	
	public static int size; // 배열의 길이
	public static int wordLength; // 단어의 길이
	public static int totalCount; // 자리의 총 개수
	public static int[][] puzzle; // 퍼즐 배열
	
	/** 퍼즐을 검사하는 메소드 */
	public static int searchPuzzle() {
		totalCount = 0;
		
		// 배열의 행을 검사한다
		for (int row = 0; row < size; row++) {
			int col = 0;
			int digit = 0;
			while (col < size) {				
				if (puzzle[row][col] == 0) {
					// 단어의 길이만큼 연속으로 이어진다면 자리 개수를 1 증가시킨다
					if (digit == wordLength) {
						totalCount++;
					}
					// 다시 자리 길이는 0으로 만들고 열 번호를 증가시킨다
					digit = 0;
				} else {
					// 이어지는 자리면 이어서 탐색한다
					digit++;
					
					// 마지막 칸이면 자리 개수를 확인한다
					if (col == size -1 && digit == wordLength) {
						totalCount++;
					}
				}
				col++;
			}
		}
		
		// 배열의 열을 검사한다
		for (int col = 0; col < size; col++) {
			int row = 0;
			int digit = 0;
			while (row < size) {
				if (puzzle[row][col] == 0) {
					// 단어의 길이만큼 연속으로 이어진다면 자리 개수를 1 증가시킨다
					if (digit == wordLength) {
						totalCount++;
					}
					// 다시 자리 길이는 0으로 만들고 열 번호를 증가시킨다
					digit = 0;
				} else {
					// 이어지는 자리면 이어서 탐색한다
					digit++;
					
					// 마지막 칸이면 자리 개수를 확인한다
					if (row == size -1 && digit == wordLength) {
						totalCount++;
					}
				}
				row++;
			}
		}
		
		return totalCount;
	}

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		int testCase = Integer.parseInt(br.readLine().trim());
		
		for (int tc = 1; tc <= testCase; tc++) {
			st = new StringTokenizer(br.readLine().trim());
			size = Integer.parseInt(st.nextToken());
			wordLength = Integer.parseInt(st.nextToken());
			puzzle = new int[size][size];
			
			for (int row = 0; row < size; row++) {
				st = new StringTokenizer(br.readLine().trim());
				for (int col = 0; col < size; col++) {
					puzzle[row][col] = Integer.parseInt(st.nextToken());
				}
			}
			
			searchPuzzle();
			
			sb.append("#").append(tc).append(" ").append(totalCount).append("\n");
		}
		System.out.println(sb);
	}
}