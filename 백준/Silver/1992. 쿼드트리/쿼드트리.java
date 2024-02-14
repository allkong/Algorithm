import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 1. 영상의 크기(size)를 입력받는다.
 * 2. 영상 배열을 입력받는다.
 * 3. 배열을 4등분하여 한 면이 모두 0이거나 1인지 확인한다.
 * 4. 모두 0(또는 1)이면 0(또는 1)을 압축 결과에 넣는다.
 * 5. 그렇지 않다면 압축 결과에 여는 괄호('(')를 넣고 해당 면을 다시 4등분하여 4번을 검사하는 것을 반복한다.
 *    5-1. 한 면의 탐색을 끝낼 때마다 닫는 괄호(')')도 넣어준다.
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	
	public static int size; // 영상의 길이
	public static int[][] video; // 영상 배열
	public static int value; // 배열 안의 원소가 0인지 1인지 구분
	
	public static boolean checkVideo(int row, int col, int size) {
		// 배열의 모든 원소가 0 또는 1인지 확인한다
		value = video[row][col];
		for (int checkRow = row; checkRow < row + size; checkRow++) {
			for (int checkCol = col; checkCol < col + size; checkCol++) {
				if (video[checkRow][checkCol] != value) {
					return false;
				}
			}
		}
		return true;
	}
	
	public static void quardTree(int row, int col, int size) {
		// 모두 0이면 0을 압축 결과에 넣고, 모두 1이면 1을 넣는다
		if (checkVideo(row, col, size)) {
			sb.append(value);
			return;
		}
		
		// 한 면에 0과 1이 섞여있다면, 다시 4등분을 한다 (재귀)
		sb.append("(");
		
		int halfSize = size >> 1;
		quardTree(row, col, halfSize); // 왼쪽 위
		quardTree(row, col + halfSize, halfSize); // 오른쪽 위
		quardTree(row + halfSize, col, halfSize); // 왼쪽 아래
		quardTree(row + halfSize, col + halfSize, halfSize); // 오른쪽 아래
		
		sb.append(")");
	}
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		size = Integer.parseInt(br.readLine().trim());
		video = new int[size][size];
		
		for (int row = 0; row < size; row++) {
			String line = br.readLine().trim();
			for (int col = 0; col < size; col++) {
				video[row][col] = Character.getNumericValue(line.charAt(col));
			}
		}
		
		quardTree(0, 0, size);
		
		System.out.println(sb);
	}
}