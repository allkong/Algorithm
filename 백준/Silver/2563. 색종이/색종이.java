import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 1. 색종이의 수를 입력받는다.
 * 2. 색종이를 붙인 위치를 입력받는다.
 *    2-1. 색종이 좌표는 색종이의 왼쪽 아래 꼭짓점이다.
 * 3. 가로, 세로의 크기가 각각 100인 도화지 배열을 선언한다.
 *    3-1. 도화지 배열은 false로 초기화되어 있다.
 * 4. 색종이의 영역만큼 true로 초기화해준다.
 *    4-1. 색종이 하나의 영역은 (색종이 좌표, 색종이 좌표)부터 (색종이 좌표 + 10, 색종이 좌표 + 10)만큼이다.
 * 5. 도화지에 붙인 색종이들의 영역은 도화지 배열에서 true인 영역이다. 
 */
public class Main {
	public static BufferedReader br;
	public static StringTokenizer st;
	
	public static final int whitePaperSize = 100; // 도화지 가로, 세로 사이즈
	public static final int blackPaperSize = 10; // 색종이 가로, 세로 사이즈
	public static boolean[][] whitePaper; // 도화지 영역
	public static int blackPaperArea; // 검은 영역의 넓이
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		int blackPaperCount = Integer.parseInt(br.readLine().trim()); // 색종이 수
		whitePaper = new boolean[whitePaperSize][whitePaperSize];
		
		for (int count = 0; count < blackPaperCount; count++) {
			st = new StringTokenizer(br.readLine().trim());
			int blackPaperCol = Integer.parseInt(st.nextToken()); // 열
			int blackPaperRow = Integer.parseInt(st.nextToken()); // 행
			
			// 색종이의 영역만큼 true로 초기화해준다
			// 색종이 하나의 영역은 (색종이 좌표, 색종이 좌표)부터 (색종이 좌표 + 10, 색종이 좌표 + 10)만큼이다
			for (int row = blackPaperRow; row < blackPaperRow + blackPaperSize; row++) {
				for (int col = blackPaperCol; col < blackPaperCol + blackPaperSize; col++) {
					whitePaper[row][col] = true;
				}
			}
		}
		// 도화지에 붙인 색종이들의 영역은 도화지 배열에서 true인 영역이므로
		// true인 영역을 구한다
		blackPaperArea = 0;
		for (int row = 0; row < whitePaperSize; row++) {
			for (int col = 0; col < whitePaperSize; col++) {
				if (whitePaper[row][col]) {
					blackPaperArea++;
				}
			}
		}
		System.out.println(blackPaperArea);
	}
}