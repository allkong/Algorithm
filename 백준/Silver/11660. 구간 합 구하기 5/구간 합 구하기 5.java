import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 표의 크기, 합을 구해야 하는 횟수를 입력받는다.
 * 2. 표에 들어갈 수를 입력받아 배열에 저장한다.
 *    2-1. 2차원 배열을 선언한다.
 *    2-2. 입력받을 때 숫자 그대로가 아니라 누적합으로 저장한다.
 * 3. 합을 구해야 하는 횟수만큼 반복한다.
 * 4. (x1, y1), (x2, y2)를 입력받는다.
 * 5. (x2, y2)까지의 누적합에서 좌측 네모 칸 모양과 위 네모 칸 모양을 뺀 후 두 네모 칸의 겹치는 부분을 다시 더한다. 
 */
public class Main {
	public static BufferedReader br;
	public static StringBuilder sb;
	public static StringTokenizer st;

	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine().trim());
		int size = Integer.parseInt(st.nextToken()); // 표의 크기
		int totalCount = Integer.parseInt(st.nextToken()); // 합을 구해야 하는 횟수
		int[][] table = new int[size + 1][size + 1]; // 표 배열
		
		// 0번째 행과 0번째 0은 누적합을 구하기 위해 0으로 냅둔다
		// 1번째 행부터 누적합을 구한다
		for (int col = 1; col <= size; col++) {
			st = new StringTokenizer(br.readLine().trim());
			for (int row = 1; row <= size; row++) {
				int currentNum = Integer.parseInt(st.nextToken());
				// 현재 위치의 숫자 + 좌측 네모 칸 + 위 네모 칸 - 두 네모 칸이 겹치는 부분
				table[col][row] = currentNum + table[col - 1][row] + table[col][row - 1] - table[col - 1][row - 1];
			}
		}
		
		// 합을 구해야 하는 횟수만큼 반복한다
		for (int totalNum = 0; totalNum < totalCount; totalNum++) {
			st = new StringTokenizer(br.readLine().trim());
			// (x1, y1), (x2, y2) 구간의 좌표를 입력받는다
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 큰 네모 칸을 구하고 해당되지 않는 두 네모 칸을 뺀 다음, 두 네모 칸에서 겹치는 부분을 뺀다
			int total = table[x2][y2] - table[x2][y1 - 1] - table[x1 - 1][y2] + table[x1 - 1][y1 - 1];
			sb.append(total).append("\n");
		}
		System.out.println(sb);
	}
}